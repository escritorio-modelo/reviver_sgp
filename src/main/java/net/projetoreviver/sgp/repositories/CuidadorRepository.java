package net.projetoreviver.sgp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.projetoreviver.sgp.models.Cuidador;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
}
