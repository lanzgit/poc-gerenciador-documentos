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

import br.edu.infnet.gerenciador_documentos.dto.InformeRequestDTO;
import br.edu.infnet.gerenciador_documentos.dto.InformeResponseDTO;
import br.edu.infnet.gerenciador_documentos.service.InformeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/informes")
@RequiredArgsConstructor
@Tag(name = "Informes", description = "Operações CRUD sobre Informes")
public class InformeController {

    private final InformeService informeService;

    @GetMapping
    @Operation(summary = "Listar todos os informes")
    public ResponseEntity<List<InformeResponseDTO>> listarTodos() {
        return ResponseEntity.ok(informeService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar informe por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Informe encontrado"),
        @ApiResponse(responseCode = "404", description = "Informe não encontrado")
    })
    public ResponseEntity<InformeResponseDTO> buscarPorId(
            @Parameter(description = "ID do informe") @PathVariable Long id) {
        return ResponseEntity.ok(informeService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo informe")
    @ApiResponse(responseCode = "201", description = "Informe criado com sucesso")
    public ResponseEntity<InformeResponseDTO> criar(@RequestBody InformeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(informeService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar informe existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Informe atualizado"),
        @ApiResponse(responseCode = "404", description = "Informe não encontrado")
    })
    public ResponseEntity<InformeResponseDTO> atualizar(
            @Parameter(description = "ID do informe") @PathVariable Long id,
            @RequestBody InformeRequestDTO dto) {
        return ResponseEntity.ok(informeService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar informe")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Informe deletado"),
        @ApiResponse(responseCode = "404", description = "Informe não encontrado")
    })
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do informe") @PathVariable Long id) {
        informeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
