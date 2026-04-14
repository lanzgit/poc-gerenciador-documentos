package br.edu.infnet.gerenciador_documentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gerenciador_documentos.model.Informe;

public interface InformeRepository extends JpaRepository<Informe, Long> {
}
