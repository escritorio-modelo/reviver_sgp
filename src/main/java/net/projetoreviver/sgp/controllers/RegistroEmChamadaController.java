package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.models.RegistroChamadaPaciente;
import net.projetoreviver.sgp.services.ChamadaService;
import net.projetoreviver.sgp.services.CuidadorService;
import net.projetoreviver.sgp.services.RegistroChamadaPacienteService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registrochamada")
public class RegistroEmChamadaController {

    @Autowired
    private ChamadaService chamadaService;

    @Autowired
    private RegistroChamadaPacienteService registroChamadaPacienteService;

    @Autowired
    private CuidadorService cuidadorService;

    @GetMapping("/{chamada_id}")
    public ModelAndView cadastrarNaChamada(@PathVariable("chamada_id") Long chamadaId){
        System.out.println(chamadaId);
        ModelAndView mv = new ModelAndView("pages/cadastro-participante/index"); //Adicionar view
        mv.addObject("registro", new RegistroChamadaPaciente()); //Onde chamada, paciente serão relacionados
        mv.addObject("chamada", chamadaService.getChamadaById(chamadaId)); //Aqui vai a chamada onde o paciente está sendo cadastrado.
        //Como acessar cuidador? registro.cuidadoresList
        return mv;
    }

    @PostMapping("/")
    public String cadastrarChamada(@Valid RegistroChamadaPaciente registro, BindingResult result, @RequestParam("cuidador") Long cuidadorId,
                                   final RedirectAttributes attributes){
        Cuidador cuidador = cuidadorService.getCuidadorById(cuidadorId);
        registro.addCuidador(cuidador);
        registroChamadaPacienteService.toPersist(registro);
        attributes.addFlashAttribute("novoRegistro", true);
        return ("redirect:/chamadas/"+registro.getChamada().getId());
    }
}



