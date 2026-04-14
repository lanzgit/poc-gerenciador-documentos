package br.edu.infnet.gerenciador_documentos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "oficios")
public class Oficio extends Documento {

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private String destinatario;

    private String origem;
}
