package net.projetoreviver.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.projetoreviver.sgp.models.RegistroChamadaPaciente;

@Repository
public interface RegistroChamadaPacienteRepository extends JpaRepository<RegistroChamadaPaciente, Long>{   
}