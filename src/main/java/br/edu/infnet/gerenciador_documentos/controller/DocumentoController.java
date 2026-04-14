package br.edu.infnet.gerenciador_documentos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.gerenciador_documentos.dto.DocumentoResumoDTO;
import br.edu.infnet.gerenciador_documentos.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
@Tag(name = "Documentos", description = "Listagem consolidada de todos os documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    @GetMapping
    @Operation(summary = "Listar todos os documentos", description = "Retorna um resumo de todos os Ofícios e Informes cadastrados")
    public ResponseEntity<List<DocumentoResumoDTO>> listarTodos() {
        return ResponseEntity.ok(documentoService.listarTodos());
    }
}
