package net.projetoreviver.sgp.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import net.projetoreviver.sgp.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNomeContainingIgnoreCase(String query);

    Optional<Paciente> findByCpf(String cpf);
}