package br.edu.infnet.gerenciador_documentos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.gerenciador_documentos.dto.OficioRequestDTO;
import br.edu.infnet.gerenciador_documentos.dto.OficioResponseDTO;
import br.edu.infnet.gerenciador_documentos.service.OficioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/oficios")
@RequiredArgsConstructor
@Tag(name = "Ofícios", description = "Operações CRUD sobre Ofícios")
public class OficioController {

    private final OficioService oficioService;

    @GetMapping
    @Operation(summary = "Listar todos os ofícios")
    public ResponseEntity<List<OficioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(oficioService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ofício por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Ofício encontrado"),
        @ApiResponse(responseCode = "404", description = "Ofício não encontrado")
    })
    public ResponseEntity<OficioResponseDTO> buscarPorId(
            @Parameter(description = "ID do ofício") @PathVariable Long id) {
        return ResponseEntity.ok(oficioService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo ofício")
    @ApiResponse(responseCode = "201", description = "Ofício criado com sucesso")
    public ResponseEntity<OficioResponseDTO> criar(@RequestBody OficioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(oficioService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar ofício existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Ofício atualizado"),
        @ApiResponse(responseCode = "404", description = "Ofício não encontrado")
    })
    public ResponseEntity<OficioResponseDTO> atualizar(
            @Parameter(description = "ID do ofício") @PathVariable Long id,
            @RequestBody OficioRequestDTO dto) {
        return ResponseEntity.ok(oficioService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar ofício")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Ofício deletado"),
        @ApiResponse(responseCode = "404", description = "Ofício não encontrado")
    })
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do ofício") @PathVariable Long id) {
        oficioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
