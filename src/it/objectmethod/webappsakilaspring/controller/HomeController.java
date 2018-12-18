package it.objectmethod.webappsakilaspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.webappsakilaspring.dao.IDaoActor;
import it.objectmethod.webappsakilaspring.dao.IDaoCategory;
import it.objectmethod.webappsakilaspring.dao.IDaoFilm;
import it.objectmethod.webappsakilaspring.model.Actor;
import it.objectmethod.webappsakilaspring.model.Category;

@Controller
public class HomeController {
	
	@Autowired
	IDaoFilm daoFilm;
	
	@Autowired
	IDaoCategory daoCategory;
	
	@Autowired
	IDaoActor daoActor;
	
	@GetMapping("/inizio")
	public String inizio(ModelMap model) {

		return "forward:/stepRiempimentoForm";
	}
	
	
	@GetMapping("/stepRiempimentoForm")
	public String riempimentoForm (ModelMap model) {
		List<Category> allCategories = new ArrayList<Category>();
		allCategories = daoCategory.allCategories();
		model.addAttribute("allCategories", allCategories);

		List<Actor> allActors = new ArrayList<Actor>();
		allActors = daoActor.allActors();
		model.addAttribute("allActors", allActors);
		return "main";
	}

}
