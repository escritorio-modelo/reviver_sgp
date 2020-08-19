package net.projetoreviver.sgp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
