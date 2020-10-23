package net.projetoreviver.sgp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.projetoreviver.sgp.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>  {
    
}
