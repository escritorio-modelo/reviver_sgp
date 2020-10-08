package net.projetoreviver.sgp.controllers;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
	public ModelAndView listar(@RequestParam(required = false) Boolean deletada) {
		ModelAndView mv = new ModelAndView("pages/chamadas/listar");
		mv.addObject("chamadas", chamadaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Chamada chamada) {
		ModelAndView mv = new ModelAndView("pages/chamadas/cadastrar");
		mv.addObject("minDate", LocalDate.now());
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid Chamada chamada, BindingResult result) {
		if(result.hasErrors()) {
			return this.cadastrar(chamada);
		}
		chamadaService.toPersist(chamada);
		return new ModelAndView("redirect:/chamadas/" + chamada.getId());
	}
	
	@GetMapping("/{id}/alterar")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pages/chamadas/alterar");
		mv.addObject("chamada", chamadaService.getChamadaById(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chamada chamada, BindingResult result) {
		if(result.hasErrors()) {
			return this.alterar(chamada.getId());
		}
		chamadaService.toPersist(chamada);
		return new ModelAndView("redirect:/chamadas/" + chamada.getId());
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Chamada chamada = chamadaService.getChamadaById(id);
		chamadaService.toRemove(chamada);
		return new ModelAndView("redirect:/chamadas/listar" + "?deletada=true");
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pages/chamadas/detalhes");
		mv.addObject("chamada", chamadaService.getChamadaById(id));
		return mv;
	}
}
