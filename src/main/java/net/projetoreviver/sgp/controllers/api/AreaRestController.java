package net.projetoreviver.sgp.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.projetoreviver.sgp.models.Area;
import net.projetoreviver.sgp.repositories.AreaRepository;

@RestController
@RequestMapping("/area")
public class AreaRestController {
    
    
    @Autowired
    private AreaRepository areaRepository;

    @GetMapping("/")
    public List<Area> listar(){
        return areaRepository.findAll();
    }

}
