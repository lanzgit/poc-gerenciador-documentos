-- =============================================================================
-- Dados iniciais: 10 Ofícios + 10 Informes
--
-- Estratégia JOINED: registros na tabela pai (documentos) + tabela filha.
-- O discriminador padrão do Hibernate 6 (coluna dtype) identifica o subtipo.
-- =============================================================================

-- -----------------------------------------------------------------------------
-- OFÍCIOS (IDs 1 – 10)
-- -----------------------------------------------------------------------------
INSERT INTO documentos (id, titulo, conteudo, data_criacao, data_atualizacao) VALUES
(1,  'Ofício nº 001/2026 – Solicitação de Recursos',          'Solicitamos à Diretoria Financeira a liberação de recursos orçamentários para o segundo semestre.',         TIMESTAMP '2026-01-05 08:00:00', TIMESTAMP '2026-01-05 08:00:00'),
(2,  'Ofício nº 002/2026 – Convite para Palestra',             'Convidamos V.Sa. para a palestra de abertura do semestre letivo 2026.',                                     TIMESTAMP '2026-01-10 09:30:00', TIMESTAMP '2026-01-10 09:30:00'),
(3,  'Ofício nº 003/2026 – Comunicação de Férias Coletivas',   'Informamos que o recesso coletivo ocorrerá de 20 a 31 de janeiro de 2026.',                                 TIMESTAMP '2026-01-12 10:00:00', TIMESTAMP '2026-01-12 10:00:00'),
(4,  'Ofício nº 004/2026 – Pedido de Vistoria',                'Solicitamos vistoria nas instalações do bloco C para verificação das condições das salas de aula.',          TIMESTAMP '2026-01-15 11:00:00', TIMESTAMP '2026-01-15 11:00:00'),
(5,  'Ofício nº 005/2026 – Encaminhamento de Relatório',       'Encaminhamos o relatório anual de atividades acadêmicas do ano letivo de 2025.',                            TIMESTAMP '2026-01-20 14:00:00', TIMESTAMP '2026-01-20 14:00:00'),
(6,  'Ofício nº 006/2026 – Solicitação de Prorrogação',        'Solicitamos prorrogação do prazo de entrega dos relatórios de estágio supervisionado.',                     TIMESTAMP '2026-02-01 08:30:00', TIMESTAMP '2026-02-01 08:30:00'),
(7,  'Ofício nº 007/2026 – Comunicação de Novo Docente',       'Comunicamos a admissão do Prof. Dr. João da Silva para integrar o corpo docente do curso de Ciências.',     TIMESTAMP '2026-02-05 09:00:00', TIMESTAMP '2026-02-05 09:00:00'),
(8,  'Ofício nº 008/2026 – Solicitação de Transferência',      'Requeremos a transferência do aluno matrícula nº 20260001 para o turno noturno.',                           TIMESTAMP '2026-02-10 10:30:00', TIMESTAMP '2026-02-10 10:30:00'),
(9,  'Ofício nº 009/2026 – Convênio Institucional',            'Encaminhamos minuta de convênio para aprovação do Conselho Acadêmico.',                                     TIMESTAMP '2026-02-15 13:00:00', TIMESTAMP '2026-02-15 13:00:00'),
(10, 'Ofício nº 010/2026 – Agradecimento Institucional',       'Agradecemos a colaboração prestada pelo Ministério da Educação durante o evento de certificação 2025.',     TIMESTAMP '2026-02-20 16:00:00', TIMESTAMP '2026-02-20 16:00:00');

INSERT INTO oficios (id, numero, destinatario, origem) VALUES
(1,  'OF-001/2026', 'Diretoria Financeira',       'Coordenação de Planejamento'),
(2,  'OF-002/2026', 'Prof. Ana Paula Martins',    'Departamento de Eventos'),
(3,  'OF-003/2026', 'Todos os Colaboradores',     'Recursos Humanos'),
(4,  'OF-004/2026', 'Setor de Infraestrutura',    'Coordenação Administrativa'),
(5,  'OF-005/2026', 'Conselho Superior',          'Secretaria Acadêmica'),
(6,  'OF-006/2026', 'Coordenação de Estágios',    'Colegiado do Curso'),
(7,  'OF-007/2026', 'Departamento de RH',         'Diretoria Acadêmica'),
(8,  'OF-008/2026', 'Secretaria Acadêmica',       'Coordenação do Curso de TI'),
(9,  'OF-009/2026', 'Conselho Acadêmico',         'Núcleo de Relações Institucionais'),
(10, 'OF-010/2026', 'Ministério da Educação',     'Reitoria');

-- -----------------------------------------------------------------------------
-- INFORMES (IDs 11 – 20)
-- -----------------------------------------------------------------------------
INSERT INTO documentos (id, titulo, conteudo, data_criacao, data_atualizacao) VALUES
(11, 'Informe – Calendário Acadêmico 2026',         'O calendário acadêmico do ano letivo de 2026 está disponível no portal do aluno.',                              TIMESTAMP '2026-01-06 08:00:00', TIMESTAMP '2026-01-06 08:00:00'),
(12, 'Informe – Atualização do Sistema de Notas',   'O sistema de registro de notas passará por manutenção no dia 08/01/2026 das 22h às 06h.',                       TIMESTAMP '2026-01-07 09:00:00', TIMESTAMP '2026-01-07 09:00:00'),
(13, 'Informe – Semana de Recepção aos Calouros',   'A semana de recepção aos alunos ingressantes ocorrerá de 03 a 07 de fevereiro de 2026.',                        TIMESTAMP '2026-01-13 10:00:00', TIMESTAMP '2026-01-13 10:00:00'),
(14, 'Informe – Prazo de Matrícula',                'O prazo para renovação de matrícula do semestre 2026.1 encerra em 28 de fevereiro de 2026.',                    TIMESTAMP '2026-01-16 11:30:00', TIMESTAMP '2026-01-16 11:30:00'),
(15, 'Informe – Manutenção Predial',                'O bloco A ficará fechado para manutenção preventiva nos dias 22 e 23 de janeiro de 2026.',                      TIMESTAMP '2026-01-18 14:00:00', TIMESTAMP '2026-01-18 14:00:00'),
(16, 'Informe – Bolsas de Pesquisa Disponíveis',    'Estão abertas as inscrições para bolsas de iniciação científica com vigência de março a dezembro de 2026.',     TIMESTAMP '2026-02-02 08:30:00', TIMESTAMP '2026-02-02 08:30:00'),
(17, 'Informe – Novo Regulamento de TCCs',          'O novo regulamento de Trabalhos de Conclusão de Curso entra em vigor a partir do semestre 2026.1.',             TIMESTAMP '2026-02-06 09:30:00', TIMESTAMP '2026-02-06 09:30:00'),
(18, 'Informe – Suspensão de Atividades',           'As atividades acadêmicas estarão suspensas nos dias 24 e 25 de fevereiro em virtude do feriado de Carnaval.',   TIMESTAMP '2026-02-11 10:00:00', TIMESTAMP '2026-02-11 10:00:00'),
(19, 'Informe – Atualização de Política de Dados',  'Comunicamos a atualização da Política de Privacidade e Proteção de Dados da Instituição conforme a LGPD.',      TIMESTAMP '2026-02-16 13:00:00', TIMESTAMP '2026-02-16 13:00:00'),
(20, 'Informe – Concurso Cultural 2026',            'Está aberto o concurso cultural "Infnet em Movimento". Inscrições até 28/02/2026 pelo portal.',                 TIMESTAMP '2026-02-22 15:00:00', TIMESTAMP '2026-02-22 15:00:00');

INSERT INTO informes (id, assunto, setor) VALUES
(11, 'Calendário Acadêmico',          'Secretaria Acadêmica'),
(12, 'Tecnologia da Informação',      'TI e Sistemas'),
(13, 'Eventos Institucionais',        'Departamento de Eventos'),
(14, 'Gestão de Matrículas',          'Secretaria Acadêmica'),
(15, 'Infraestrutura',                'Coordenação Administrativa'),
(16, 'Pesquisa e Extensão',           'Núcleo de Pesquisa'),
(17, 'Regulamentação Acadêmica',      'Colegiado dos Cursos'),
(18, 'Gestão de Calendário',          'Diretoria Acadêmica'),
(19, 'Compliance e Privacidade',      'Jurídico'),
(20, 'Cultura e Extensão',            'Departamento de Eventos');
