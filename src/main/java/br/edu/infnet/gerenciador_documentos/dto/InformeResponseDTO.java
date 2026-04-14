package br.edu.infnet.gerenciador_documentos.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformeResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private String assunto;
    private String setor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
