package net.projetoreviver.sgp.repositories;

import net.projetoreviver.sgp.models.Paciente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.projetoreviver.sgp.models.Cuidador;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    List<Cuidador> findByNomeContainingIgnoreCase(String query);
    Optional<Cuidador> findByCpf(String cpf);
}
