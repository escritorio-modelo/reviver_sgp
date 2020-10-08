package net.projetoreviver.sgp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.projetoreviver.sgp.models.Chamada;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long>{
    Page<Chamada> findByTituloContainingIgnoreCase(String query, Pageable pageable);
}
