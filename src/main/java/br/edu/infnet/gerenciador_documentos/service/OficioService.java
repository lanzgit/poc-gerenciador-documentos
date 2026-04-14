package br.edu.infnet.gerenciador_documentos.service;

import br.edu.infnet.gerenciador_documentos.dto.OficioRequestDTO;
import br.edu.infnet.gerenciador_documentos.dto.OficioResponseDTO;
import br.edu.infnet.gerenciador_documentos.exception.RecursoNaoEncontradoException;
import br.edu.infnet.gerenciador_documentos.model.Oficio;
import br.edu.infnet.gerenciador_documentos.repository.OficioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OficioService {

    private final OficioRepository oficioRepository;

    public List<OficioResponseDTO> listarTodos() {
        return oficioRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OficioResponseDTO buscarPorId(Long id) {
        return oficioRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ofício não encontrado com id: " + id));
    }

    public OficioResponseDTO criar(OficioRequestDTO dto) {
        Oficio oficio = Oficio.builder()
                .titulo(dto.getTitulo())
                .conteudo(dto.getConteudo())
                .numero(dto.getNumero())
                .destinatario(dto.getDestinatario())
                .origem(dto.getOrigem())
                .build();
        return toResponse(oficioRepository.save(oficio));
    }

    public OficioResponseDTO atualizar(Long id, OficioRequestDTO dto) {
        Oficio oficio = oficioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ofício não encontrado com id: " + id));
        oficio.setTitulo(dto.getTitulo());
        oficio.setConteudo(dto.getConteudo());
        oficio.setNumero(dto.getNumero());
        oficio.setDestinatario(dto.getDestinatario());
        oficio.setOrigem(dto.getOrigem());
        return toResponse(oficioRepository.save(oficio));
    }

    public void deletar(Long id) {
        if (!oficioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ofício não encontrado com id: " + id);
        }
        oficioRepository.deleteById(id);
    }

    private OficioResponseDTO toResponse(Oficio oficio) {
        return OficioResponseDTO.builder()
                .id(oficio.getId())
                .titulo(oficio.getTitulo())
                .conteudo(oficio.getConteudo())
                .numero(oficio.getNumero())
                .destinatario(oficio.getDestinatario())
                .origem(oficio.getOrigem())
                .dataCriacao(oficio.getDataCriacao())
                .dataAtualizacao(oficio.getDataAtualizacao())
                .build();
    }
}
