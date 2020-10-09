package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import net.projetoreviver.sgp.models.Paciente;
import net.projetoreviver.sgp.repositories.PacienteRepository;
import net.projetoreviver.sgp.services.PacienteService;



@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("pacientes/listar");
		mv.addObject("pacientes", pacienteRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Paciente paciente) {
		ModelAndView mv = new ModelAndView("pacientes/cadastrar");
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid Paciente paciente, BindingResult result) {
		if(result.hasErrors()) {
			return this.cadastrar(paciente);
		}
		pacienteService.toPersist(paciente);
		return new ModelAndView("redirect:/pacientes/listar");
	}

	
	@GetMapping("/{id}/alterar")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pacientes/alterar");
		mv.addObject("paciente", pacienteService.getPacienteById(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Paciente paciente, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("pacientes/alterar").addObject("paciente", paciente);
		}
		pacienteService.toPersist(paciente);
		return new ModelAndView("redirect:/pacientes/listar");
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Paciente paciente = pacienteService.getPacienteById(id);
		pacienteService.toRemove(paciente);
		return new ModelAndView("redirect:/pacientes/listar");
	}


	@GetMapping("/")
	@ResponseBody()
	public Page<Paciente> listarAll(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
		@RequestParam(value = "pagina", required = false , defaultValue = "0")int pagina,
		@RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho)
	{

		PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "nome");
		return pacienteRepository.findByNomeContainingIgnoreCase(nome, pageRequest);
	}


	@PostMapping("/api/cadastrar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void cadastrarAjax(@RequestBody @Valid Paciente paciente){
		System.out.println(paciente);
		pacienteService.toPersist(paciente);
	}
}