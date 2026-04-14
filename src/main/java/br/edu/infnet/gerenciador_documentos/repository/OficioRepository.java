package br.edu.infnet.gerenciador_documentos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.gerenciador_documentos.model.Oficio;

public interface OficioRepository extends JpaRepository<Oficio, Long> {

    Optional<Oficio> findByNumero(String numero);

    boolean existsByNumero(String numero);
}
