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
		ModelAndView mv = new ModelAndView("pages/pacientes/listar");
		mv.addObject("pacientes", pacienteRepository.findAll());
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("pages/pacientes/detalhes");
		mv.addObject("paciente", pacienteService.getPacienteById(id));
		return mv;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(Paciente paciente) {
		ModelAndView mv = new ModelAndView("pages/pacientes/cadastrar");
		return mv;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(@Valid Paciente paciente, BindingResult result) {
		if (result.hasErrors()) {
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
		if (result.hasErrors()) {
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
}