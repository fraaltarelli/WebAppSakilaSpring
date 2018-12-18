package it.objectmethod.webappsakilaspring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.webappsakilaspring.dao.IDaoFilm;
import it.objectmethod.webappsakilaspring.model.Category;
import it.objectmethod.webappsakilaspring.model.Film;

public class DaoFilmImpl extends NamedParameterJdbcDaoSupport implements IDaoFilm{
	
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}

	@Override
	public List<Film> filmPerCategoria(int categoryId) {
		List<Film> list = new ArrayList<Film>();
		String sql = "select film.film_id, film.title, film.rental_rate, film.length, film.release_year from film "+
				"inner join film_category on film.film_id= film_category.film_id "+
				"inner join category on film_category.category_id= category.category_id "+
				"where category.category_id = :categoryId";
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<Film>(Film.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("categoryId", categoryId);
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}

	@Override
	public List<Film> filmPerAttore(int actorId) {
		List<Film> list = new ArrayList<Film>();
		String sql = "select film.film_id, film.title, film.rental_rate, film.length, film.release_year from film "+
		             "inner join film_actor on film.film_id= film_actor.film_id "+
				     "inner join actor on film_actor.actor_id= actor.actor_id "+
		             "where actor.actor_id = :actorId";
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<Film>(Film.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("actorId", actorId);
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}

	@Override
	public void inserisciFilm(Film film, int categoriaId, int[] idAttori) {
		String sql = "INSERT INTO film (title, rental_rate, length, release_year, language_id) values (:title, :prezzo, :durata, :release_year, :language_id)";
//				+ "insert into film_category (film_id, category_id) values ((select max(film_id) from film), :categoria)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", film.getTitle());
		params.addValue("prezzo", film.getRental_rate());
		params.addValue("durata", film.getLength());
		params.addValue("release_year", film.getRelease_year());
		params.addValue("language_id", 1);
//		params.addValue("categoria", categoriaId);
		this.getNamedParameterJdbcTemplate().update(sql, params);
		
		sql= "select max(film_id) from film";
		int filmId= this.getJdbcTemplate().queryForObject(sql, Integer.class);
		
		sql= "insert into film_category (film_id, category_id) values (:filmId, :categoria)";
		params = new MapSqlParameterSource();
		params.addValue("filmId", filmId);
		params.addValue("categoria", categoriaId);
		this.getNamedParameterJdbcTemplate().update(sql, params);
		
		for(int temp: idAttori) {
			sql = "insert into film_actor (actor_id, film_id) values (:idAttore, :filmId)";
			params = new MapSqlParameterSource();
			params.addValue("idAttore", temp);
			params.addValue("filmId", filmId);
			this.getNamedParameterJdbcTemplate().update(sql, params);
		}
		
		return;
	}

}
