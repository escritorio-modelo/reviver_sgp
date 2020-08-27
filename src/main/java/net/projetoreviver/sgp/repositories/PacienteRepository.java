package net.projetoreviver.sgp.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.projetoreviver.sgp.models.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}