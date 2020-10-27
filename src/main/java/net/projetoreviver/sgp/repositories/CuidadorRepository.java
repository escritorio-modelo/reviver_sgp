package net.projetoreviver.sgp.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import net.projetoreviver.sgp.models.Cuidador;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    List<Cuidador> findByNomeContainingIgnoreCase(String query);
}
