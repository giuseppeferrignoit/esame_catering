package it.uniroma3.catering.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.catering.model.Ingrediente;
import it.uniroma3.catering.service.IngredienteService;
import it.uniroma3.catering.validator.IngredienteValidator;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private IngredienteValidator ingredienteValidator;
	
	/*
	 * convenzione: get per le operazioni di lettura, post per gli aggiornamenti
	 * il path è associato alle classi del dominio
	*/
	
	// METODO POST PER INSERIRE UN NUOVO INGREDIENTE

	@PostMapping("/ingrediente")
	public String newIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, Model model,
			BindingResult bindingResult) {
		
		/* Se non ci sono errori inserisce la ricorrenza di ingrediente 
		 * tramite la save del service 
		 * */
		
		/* Si invoca anche il metodo validate del Validator, oltre 
		 * alle validazioni automatiche dell'annotazione @valid
		 */
		this.ingredienteValidator.validate(ingrediente, bindingResult);
		
		if (!bindingResult.hasErrors()) {
			
			this.ingredienteService.save(ingrediente); // salvo un oggetto Ingrediente
			model.addAttribute("ingrediente", ingredienteService.findById(ingrediente.getId()));
			
			// Ogni metodo ritorna la stringa col nome della vista successiva
			// se NON ci sono errori si va alla form di visualizzazione dati inseriti
			return "ingrediente.html"; 
		}
		else
			// se ci sono errori si rimanda alla form di inserimento
			return "ingredienteForm.html"; 
	}

	// METODI GET

	// richiede un singolo chef tramite id
	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id")Long id, Model model) {
		// id è una variabile associata al path
		Ingrediente ingrediente = ingredienteService.findById(id);
		model.addAttribute("ingrediente", ingrediente);
		// ritorna la form con i dati dell'entità richiesta
		return "ingrediente.html";
	}
	
	// richiede tutti gli  chefs, non c'è id
	@GetMapping("/ingredienti")
	public String getIngredienti(Model model) {
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "ingredienti.html";
	}
	
	@GetMapping("/ingredienteForm")
	public String getIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "ingredienteForm.html";
	}
}

