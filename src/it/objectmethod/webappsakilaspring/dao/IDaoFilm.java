package it.objectmethod.webappsakilaspring.dao;

import java.util.List;

import it.objectmethod.webappsakilaspring.model.Category;
import it.objectmethod.webappsakilaspring.model.Film;

public interface IDaoFilm {
	public List<Film> filmpercategoria(int category_id);
	public List<Film> filmperattore(int actor_id);

}
