package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.repositories.ChamadaRepository;
import net.projetoreviver.sgp.services.ChamadaService;

@Controller
@RequestMapping("/chamadas")
public class ChamadaController {
	
	@Autowired
	private ChamadaRepository chamadaRepository;
	
	@Autowired
	private ChamadaService chamadaService;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("chamadas/listar");
		mv.addObject("chamadas", chamadaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Chamada chamada) {
		return new ModelAndView("chamadas/cadastrar");
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid Chamada chamada, BindingResult result) {
		if(result.hasErrors()) {
			return this.cadastrar(chamada);
		}
		chamadaService.toPersist(chamada);
		return new ModelAndView("redirect:/chamadas/listar");
	}
	
	@GetMapping("/{id}/alterar")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("chamadas/alterar");
		mv.addObject("chamadas", chamadaService.getChamadaById(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chamada chamada, BindingResult result) {
		if(result.hasErrors()) {
			return this.alterar(chamada.getId());
		}
		chamadaService.toPersist(chamada);
		return new ModelAndView("redirect:/chamadas/pesquisar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Chamada chamada = chamadaService.getChamadaById(id);
		chamadaService.toRemove(chamada);
		return new ModelAndView("redirect:/chamadas/pesquisar");
	}
}
