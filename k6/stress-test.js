/**
 * Stress Test — Gerenciador de Documentos
 *
 * Etapas:
 *  1. Ramp-up: 0 → 50 VUs em 1 min
 *  2. Pico:    50 VUs por 3 min
 *  3. Spike:   50 → 150 VUs em 30 s (teste de pico)
 *  4. Descida: 150 → 0 VUs em 1 min
 *
 * Thresholds:
 *  - 95% das requisições devem terminar em < 1500 ms
 *  - Taxa de erros HTTP < 5%
 */
import http from "k6/http";
import { check, sleep } from "k6";
import { Rate, Trend } from "k6/metrics";

const errorRate = new Rate("error_rate");
const listLatency = new Trend("list_documents_latency", true);

export const options = {
  stages: [
    { duration: "1m", target: 50 },   // ramp-up
    { duration: "3m", target: 50 },   // carga sustentada
    { duration: "30s", target: 150 }, // spike
    { duration: "30s", target: 150 }, // pico sustentado
    { duration: "1m", target: 0 },    // ramp-down
  ],
  thresholds: {
    http_req_duration: ["p(95)<1500"],
    error_rate: ["rate<0.05"],
  },
};

const BASE_URL = __ENV.BASE_URL || "http://localhost:8080";

// Payload para criar ofícios durante o teste
function randomOficio(i) {
  return JSON.stringify({
    titulo: `Ofício de Stress Test ${i}`,
    conteudo: `Conteúdo gerado pelo k6 — VU ${__VU}, iter ${__ITER}`,
    numero: `STRESS-${__VU}-${__ITER}-${i}`,
    destinatario: "Departamento de TI",
    origem: "Setor de Testes",
  });
}

const headers = { "Content-Type": "application/json" };

export default function () {
  // ── Cenário 1: Listar todos os documentos ──────────────────────────────────
  const listRes = http.get(`${BASE_URL}/api/documentos`);
  listLatency.add(listRes.timings.duration);
  const listOk = check(listRes, {
    "GET /api/documentos → 200": (r) => r.status === 200,
    "retornou array": (r) => {
      try {
        return Array.isArray(JSON.parse(r.body));
      } catch {
        return false;
      }
    },
  });
  errorRate.add(!listOk);

  sleep(0.5);

  // ── Cenário 2: Listar ofícios ───────────────────────────────────────────────
  const oficiosRes = http.get(`${BASE_URL}/api/oficios`);
  check(oficiosRes, { "GET /api/oficios → 200": (r) => r.status === 200 });
  errorRate.add(oficiosRes.status !== 200);

  sleep(0.5);

  // ── Cenário 3: Listar informes ─────────────────────────────────────────────
  const informesRes = http.get(`${BASE_URL}/api/informes`);
  check(informesRes, { "GET /api/informes → 200": (r) => r.status === 200 });
  errorRate.add(informesRes.status !== 200);

  sleep(0.3);

  // ── Cenário 4: Criar ofício (carga de escrita) ─────────────────────────────
  const createRes = http.post(
    `${BASE_URL}/api/oficios`,
    randomOficio(Date.now()),
    { headers }
  );
  const createOk = check(createRes, {
    "POST /api/oficios → 201": (r) => r.status === 201,
  });
  errorRate.add(!createOk);

  // Se criou com sucesso, busca o recurso pelo ID e depois deleta
  if (createOk) {
    const created = JSON.parse(createRes.body);
    const id = created.id;

    const getRes = http.get(`${BASE_URL}/api/oficios/${id}`);
    check(getRes, { "GET /api/oficios/:id → 200": (r) => r.status === 200 });

    const delRes = http.del(`${BASE_URL}/api/oficios/${id}`);
    check(delRes, { "DELETE /api/oficios/:id → 204": (r) => r.status === 204 });
  }

  sleep(0.5);
}
