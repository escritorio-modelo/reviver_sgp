package net.projetoreviver.sgp.dummies;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.projetoreviver.sgp.models.Area;
import net.projetoreviver.sgp.models.Atendimento;
import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.repositories.AreaRepository;
import net.projetoreviver.sgp.services.AtendimentoService;
import net.projetoreviver.sgp.services.ChamadaService;

@Component
public class Testing {
    @Autowired
    AtendimentoService atendimentoService;

    @Autowired
    ChamadaService chamadaService;

    @Autowired
    AreaRepository AreaRepository;

    //@PostConstruct
    public void postContruct(){
        
        Optional<Area> area = AreaRepository.findById(1L);

        Atendimento atendimento = new Atendimento();
        atendimento.setDataHora(LocalDateTime.now());
        atendimento.setArea(area.get());
        Chamada chamada = chamadaService.getChamadaById(1L);

        atendimentoService.toPersist(atendimento, chamada);
    }
}
