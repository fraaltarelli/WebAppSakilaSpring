package it.objectmethod.webappsakilaspring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappsakilaspring.dao.IDaoActor;
import it.objectmethod.webappsakilaspring.dao.IDaoCategory;
import it.objectmethod.webappsakilaspring.dao.IDaoFilm;
import it.objectmethod.webappsakilaspring.model.Actor;
import it.objectmethod.webappsakilaspring.model.Category;
import it.objectmethod.webappsakilaspring.model.Film;


@Controller
public class FilmController {
	
	@Autowired
	private IDaoFilm daoFilm;
	
	@Autowired
	IDaoCategory daoCategory;
	
	@Autowired
	IDaoActor daoActor;
	
	
	@GetMapping("/inizio")
	public String inizio(ModelMap model) {
		List<Category> allcategories = new ArrayList<Category>();
		allcategories = daoCategory.allcategories();
		model.addAttribute("allcategories", allcategories);
		
		List<Actor> allactors = new ArrayList<Actor>();
		allactors = daoActor.allactors();
		model.addAttribute("allactors", allactors);
		
		return "main";
	}
	
	@GetMapping("/filmpercategoria")
	public String filmpercategoria (@RequestParam("categoriafilm") Integer category_id, ModelMap model) {
		List<Film> list = daoFilm.filmpercategoria(category_id);
		model.addAttribute("listafilm", list);
		return "main";
	}
	
	@GetMapping("/filmperattore")
	public String filmperattore (@RequestParam("attorefilm") Integer actor_id, ModelMap model) {
		List<Film> list = daoFilm.filmperattore(actor_id);
		model.addAttribute("listafilm", list);
		return "main";
	}

}
