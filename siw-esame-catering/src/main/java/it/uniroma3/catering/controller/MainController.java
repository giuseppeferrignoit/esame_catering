package it.uniroma3.catering.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.catering.model.Buffet;
import it.uniroma3.catering.model.Chef;
import it.uniroma3.catering.model.Ingrediente;
import it.uniroma3.catering.model.Piatto;


@Controller
public class MainController {

	@GetMapping(value="/buffetForm")
	public String formBuffet(Model model) {
		model.addAttribute("buffet", new Buffet());
		return "buffetForm.html";
	}
	
	@GetMapping(value="/chefForm")
	public String formChef(Model model) {
		model.addAttribute("chef", new Chef());
		return "chefForm.html";
	}
	
	@GetMapping(value="/piattoForm")
	public String formPiatto(Model model) {
		model.addAttribute("piatto", new Piatto());
		return "piattoForm.html";
	}
	
	@GetMapping(value="/ingredienteForm")
	public String formIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "ingredienteForm.html";
	}
}