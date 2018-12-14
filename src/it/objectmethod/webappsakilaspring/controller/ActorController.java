package it.objectmethod.webappsakilaspring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappsakilaspring.dao.IDaoActor;
import it.objectmethod.webappsakilaspring.model.Actor;

@Controller
public class ActorController {
	
	@Autowired
	IDaoActor daoActor;
	
	@GetMapping("/attoriperfilm")
	public String attoriperfilm(@RequestParam("filmId") Integer filmId, ModelMap model) {
		List<Actor> list = new ArrayList<Actor>();
		list = daoActor.attoriperfilm(filmId);
		model.addAttribute("listaattori", list);
		return "main";
	}

}
