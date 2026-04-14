package br.edu.infnet.gerenciador_documentos.service;

import br.edu.infnet.gerenciador_documentos.dto.InformeRequestDTO;
import br.edu.infnet.gerenciador_documentos.dto.InformeResponseDTO;
import br.edu.infnet.gerenciador_documentos.exception.RecursoNaoEncontradoException;
import br.edu.infnet.gerenciador_documentos.model.Informe;
import br.edu.infnet.gerenciador_documentos.repository.InformeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformeService {

    private final InformeRepository informeRepository;

    public List<InformeResponseDTO> listarTodos() {
        return informeRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public InformeResponseDTO buscarPorId(Long id) {
        return informeRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Informe não encontrado com id: " + id));
    }

    public InformeResponseDTO criar(InformeRequestDTO dto) {
        Informe informe = Informe.builder()
                .titulo(dto.getTitulo())
                .conteudo(dto.getConteudo())
                .assunto(dto.getAssunto())
                .setor(dto.getSetor())
                .build();
        return toResponse(informeRepository.save(informe));
    }

    public InformeResponseDTO atualizar(Long id, InformeRequestDTO dto) {
        Informe informe = informeRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Informe não encontrado com id: " + id));
        informe.setTitulo(dto.getTitulo());
        informe.setConteudo(dto.getConteudo());
        informe.setAssunto(dto.getAssunto());
        informe.setSetor(dto.getSetor());
        return toResponse(informeRepository.save(informe));
    }

    public void deletar(Long id) {
        if (!informeRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Informe não encontrado com id: " + id);
        }
        informeRepository.deleteById(id);
    }

    private InformeResponseDTO toResponse(Informe informe) {
        return InformeResponseDTO.builder()
                .id(informe.getId())
                .titulo(informe.getTitulo())
                .conteudo(informe.getConteudo())
                .assunto(informe.getAssunto())
                .setor(informe.getSetor())
                .dataCriacao(informe.getDataCriacao())
                .dataAtualizacao(informe.getDataAtualizacao())
                .build();
    }
}
