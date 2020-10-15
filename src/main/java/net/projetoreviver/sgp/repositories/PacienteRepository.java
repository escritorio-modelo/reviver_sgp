package net.projetoreviver.sgp.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import net.projetoreviver.sgp.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByNomeContainingIgnoreCase(String query, Pageable pageable);

    List<Paciente> findByNomeContainingIgnoreCase(String query);

    Optional<Paciente> findByCpf(String cpf);
}