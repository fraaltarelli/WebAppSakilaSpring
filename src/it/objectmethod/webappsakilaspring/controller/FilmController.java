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
import org.springframework.web.bind.annotation.PostMapping;
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

		return "forward:/stepRiempimentoForm";
	}

	@GetMapping("/ricercaFilmPerCategoria")
	public String filmPerCategoria (@RequestParam("categoriaFilm") Integer category_id, ModelMap model) {
		List<Film> list = daoFilm.filmPerCategoria(category_id);
		model.addAttribute("listaFilm", list);

		return "forward:/stepRiempimentoForm";
	}


	@GetMapping("/ricercaFilmPerAttore")
	public String filmPerAttore (@RequestParam("attoreId") int actor_id, ModelMap model) {
		List<Film> list = daoFilm.filmPerAttore(actor_id);
		model.addAttribute("listaFilm", list);
		return "forward:/stepRiempimentoForm";
	}

	@GetMapping("/filmPerAttore/{attoreId}")
	public String filmPerAttorePathVariable (@PathVariable("attoreId") int actor_id, ModelMap model) {
		List<Film> list = daoFilm.filmPerAttore(actor_id);
		model.addAttribute("listaFilm", list);
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

	
	@GetMapping("/inserimentoFilm")
	String inserimentoFilmForm(ModelMap model) {
		List<Category> allCategories = new ArrayList<Category>();
		allCategories = daoCategory.allCategories();
		model.addAttribute("allCategories", allCategories);

		List<Actor> allActors = new ArrayList<Actor>();
		allActors = daoActor.allActors();
		model.addAttribute("allActors", allActors);
		return "inserimentoFilm";
	}



	@PostMapping("/inserisciFilm")
	public String inserimentoFilm (@RequestParam("titolo") String titolo,
			@RequestParam("prezzo") String prezzo, @RequestParam("durata") int durata, 
			@RequestParam("anno") int anno, @RequestParam("idAttoriDaInserire") int[] attori,
			@RequestParam("categoria") int categoriaId, ModelMap model) {
	
		try{
			Film filmDaInserire = new Film();
			filmDaInserire.setTitle(titolo);
			double prezzoInDouble= Double.parseDouble(prezzo);
			filmDaInserire.setRental_rate(prezzoInDouble);
			filmDaInserire.setLength(durata);
			filmDaInserire.setRelease_year(anno);
			daoFilm.inserisciFilm(filmDaInserire, categoriaId, attori);
			
		} catch(Exception e) {
			model.addAttribute("messaggio", "inserimento film non riuscito");
			List<Category> allCategories = new ArrayList<Category>();
			allCategories = daoCategory.allCategories();
			model.addAttribute("allCategories", allCategories);

			List<Actor> allActors = new ArrayList<Actor>();
			allActors = daoActor.allActors();
			model.addAttribute("allActors", allActors);
			return "inserimentoFilm";
		}
		model.addAttribute("messaggio", "inserimento film riuscito");
		List<Category> allCategories = new ArrayList<Category>();
		allCategories = daoCategory.allCategories();
		model.addAttribute("allCategories", allCategories);

		List<Actor> allActors = new ArrayList<Actor>();
		allActors = daoActor.allActors();
		model.addAttribute("allActors", allActors);
		return "inserimentoFilm";

	}



}
