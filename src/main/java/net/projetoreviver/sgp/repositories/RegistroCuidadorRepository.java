package net.projetoreviver.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.projetoreviver.sgp.models.RegistroCuidador;

@Repository
public interface RegistroCuidadorRepository extends JpaRepository<RegistroCuidador, Long>{   
}
