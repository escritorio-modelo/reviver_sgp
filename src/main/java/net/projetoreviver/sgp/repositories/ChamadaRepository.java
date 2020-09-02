package net.projetoreviver.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.projetoreviver.sgp.models.Chamada;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long>{
}
