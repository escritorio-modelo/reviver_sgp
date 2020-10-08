package net.projetoreviver.sgp.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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


	@PostMapping("/api/cadastrar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void cadastrarAjax(@RequestBody @Valid Paciente paciente){
		System.out.println(paciente);
		pacienteService.toPersist(paciente);
	}
}