package it.objectmethod.webappsakilaspring.dao;

import java.util.List;

import it.objectmethod.webappsakilaspring.model.Actor;

public interface IDaoActor {
	
	public List<Actor> allactors();
	public List<Actor> attoriperfilm(int filmId);

}
