package net.projetoreviver.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.projetoreviver.sgp.models.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
    
}
