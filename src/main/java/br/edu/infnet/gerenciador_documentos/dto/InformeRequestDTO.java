package br.edu.infnet.gerenciador_documentos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformeRequestDTO {

    private String titulo;
    private String conteudo;
    private String assunto;
    private String setor;
}
