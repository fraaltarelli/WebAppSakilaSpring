package it.objectmethod.webappsakilaspring.dao;

import java.util.List;

import it.objectmethod.webappsakilaspring.model.Category;
import it.objectmethod.webappsakilaspring.model.Film;

public interface IDaoFilm {
	public List<Film> filmPerCategoria(int category_id);
	public List<Film> filmPerAttore(int actor_id);
	public void inserisciFilm(Film filmdainserire, int categoriaId, Integer[] idAttori);

}
