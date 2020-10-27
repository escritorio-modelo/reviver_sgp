package net.projetoreviver.sgp.controllers.api;

import net.projetoreviver.sgp.models.Atendimento;
import net.projetoreviver.sgp.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoRestController {
    @Autowired
    private AtendimentoService atendimentoService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/")
    public Atendimento createAtendimento(@RequestBody @Valid final Atendimento atendimento){
        return atendimentoService.toPersist(atendimento);
    }
}
