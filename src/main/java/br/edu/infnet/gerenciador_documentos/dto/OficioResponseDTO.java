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
public class OficioResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private String numero;
    private String destinatario;
    private String origem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
