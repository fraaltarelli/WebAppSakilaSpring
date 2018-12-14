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
	public List<Film> filmpercategoria(int categoryId) {
		List<Film> list = new ArrayList<Film>();
		String sql = "select film.film_id, film.title, film.rental_rate, film.length from film "+
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
	public List<Film> filmperattore(int actorId) {
		List<Film> list = new ArrayList<Film>();
		String sql = "select film.film_id, film.title, film.rental_rate, film.length from film "+
		             "inner join film_actor on film.film_id= film_actor.film_id "+
				     "inner join actor on film_actor.actor_id= actor.actor_id "+
		             "where actor.actor_id = :actorId";
		BeanPropertyRowMapper<Film> rm = new BeanPropertyRowMapper<Film>(Film.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("actorId", actorId);
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}

}
