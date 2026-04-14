package br.edu.infnet.gerenciador_documentos.service;

import br.edu.infnet.gerenciador_documentos.dto.DocumentoResumoDTO;
import br.edu.infnet.gerenciador_documentos.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public List<DocumentoResumoDTO> listarTodos() {
        return documentoRepository.findAll().stream()
                .map(doc -> DocumentoResumoDTO.builder()
                        .id(doc.getId())
                        .tipo(doc.getClass().getSimpleName())
                        .titulo(doc.getTitulo())
                        .dataCriacao(doc.getDataCriacao())
                        .build())
                .collect(Collectors.toList());
    }
}
