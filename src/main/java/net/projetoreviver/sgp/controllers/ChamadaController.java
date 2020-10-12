package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pages/chamadas/detalhes");
		mv.addObject("chamada", chamadaService.getChamadaById(id));
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("pages/chamadas/listar");
		mv.addObject("chamadas", chamadaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Chamada chamada) {
		return new ModelAndView("pages/chamadas/cadastrar");
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
	public ModelAndView alterar(@Valid Chamada chamada, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("pages/chamadas/alterar");
			mv.addObject("chamada", chamada);
			return mv;
		}
		chamadaService.toPersist(chamada);
		mv.setViewName("redirect:/chamadas/" + chamada.getId());
		return mv;		
	}
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") final Long id, final RedirectAttributes attributes){
		Chamada chamada = chamadaService.getChamadaById(id);
		chamadaService.toRemove(chamada);
		attributes.addFlashAttribute("deletada", true);
		return "redirect:/chamadas/listar";
	}

	
	@GetMapping("/")
	@ResponseBody()
	public Page<Chamada> listarAll(@RequestParam(value = "titulo", required = false, defaultValue = "") String titulo,
		@RequestParam(value = "pagina", required = false , defaultValue = "0") @Min(0) int pagina,
		@RequestParam(value = "tamanho", required = false, defaultValue = "10") @Min(0) int tamanho)
	{
		return chamadaService.procurarPorTitulo(titulo, pagina, tamanho);
	}
}
