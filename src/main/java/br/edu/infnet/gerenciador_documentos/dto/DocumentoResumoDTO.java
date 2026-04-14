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
public class DocumentoResumoDTO {

    private Long id;
    private String tipo;
    private String titulo;
    private LocalDateTime dataCriacao;
}
