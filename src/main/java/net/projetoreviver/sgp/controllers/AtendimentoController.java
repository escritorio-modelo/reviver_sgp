package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.projetoreviver.sgp.models.Atendimento;
import net.projetoreviver.sgp.repositories.AtendimentoRepository;
import net.projetoreviver.sgp.services.AtendimentoService;

@Controller
public class AtendimentoController {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    
    @Autowired
    private AtendimentoService atendimentoService;
    
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("atendimentos", atendimentoRepository.findAll());
        return mv;
    }
    
    public ModelAndView detalhes(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(""); //colocar template
		mv.addObject("chamada", atendimentoService.getAtendimentoById(id));
		return mv;
	}

    public ModelAndView cadastrar(Atendimento atendimento){
        return new ModelAndView("");
    }

    public ModelAndView cadastrar(@Valid Atendimento atendimento, BindingResult result) {
		if(result.hasErrors()) {
			return this.cadastrar(atendimento);
		}
		atendimentoService.toPersist(atendimento);
		return new ModelAndView("redirect:/" + atendimento.getId()); //colocar url correta
    }
    
    public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView(""); //colocar atendimentos 
		mv.addObject("atendimento", atendimentoService.getAtendimentoById(id));
		return mv;
	}
	
	public ModelAndView alterar(@Valid Atendimento atendimento, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName(""); //colocar template
			mv.addObject("atendimento", atendimento);
			return mv;
		}
		atendimentoService.toPersist(atendimento);
		mv.setViewName("redirect:/" + atendimento.getId()); //url completa
		return mv;		
	}

    @GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") final Long id, final RedirectAttributes attributes){
		atendimentoService.toRemove(id);
		attributes.addFlashAttribute("deletada", true);
		return "redirect:/"; //colocar url
	}

}
