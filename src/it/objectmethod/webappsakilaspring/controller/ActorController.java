package it.objectmethod.webappsakilaspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappsakilaspring.dao.IDaoActor;
import it.objectmethod.webappsakilaspring.dao.IDaoCategory;
import it.objectmethod.webappsakilaspring.model.Actor;
import it.objectmethod.webappsakilaspring.model.Category;

@Controller
public class ActorController {
	
	@Autowired
	IDaoActor daoActor;
	
	@Autowired
	IDaoCategory daoCategory;
	
	
	@GetMapping("/attoriPerFilm/{filmId}")
	public String attoriPerFilm(@PathVariable("filmId") int filmId, ModelMap model) {
		List<Actor> list = new ArrayList<Actor>();
		list = daoActor.attoriPerFilm(filmId);
		model.addAttribute("listaAttori", list);
		
		return "forward:/stepRiempimentoForm";
	}
	
	@GetMapping("ricercaAttore")
	public String ricercaAttore(@RequestParam("ricercaAttore") String attoreCercato, ModelMap model) {
		List<Actor> list = new ArrayList<Actor>();
		list = daoActor.ricercaAttore(attoreCercato);
		model.addAttribute("listaAttori", list);
		
		return "forward:/stepRiempimentoForm";
	}

}
