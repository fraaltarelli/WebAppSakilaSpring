package it.objectmethod.webappsakilaspring.dao;

import java.util.List;

import it.objectmethod.webappsakilaspring.model.Actor;

public interface IDaoActor {
	
	public List<Actor> allActors();
	public List<Actor> attoriPerFilm(int filmId);
	public List<Actor> ricercaAttore(String attoreCercato);

}
