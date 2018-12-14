package it.objectmethod.webappsakilaspring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.webappsakilaspring.dao.IDaoActor;
import it.objectmethod.webappsakilaspring.model.Actor;

public class DaoActorImpl extends NamedParameterJdbcDaoSupport implements IDaoActor{

	@Override
	public List<Actor> allactors() {
		List<Actor> list = new ArrayList<Actor>();
		String sql = "select * from actor";
		BeanPropertyRowMapper<Actor> rm = new BeanPropertyRowMapper<Actor>(Actor.class);
		list = this.getNamedParameterJdbcTemplate().query(sql, rm);
		return list;
	}

	@Override
	public List<Actor> attoriperfilm(int filmId) {
		List<Actor> list = new ArrayList<Actor>();
		String sql = "select actor.actor_id, actor.first_name, actor.last_name from actor "+
		        "inner join film_actor on actor.actor_id= film_actor.actor_id  inner join film "+
				"on film_actor.film_id= film.film_id where film.film_id= :filmId";
		BeanPropertyRowMapper<Actor> rm = new BeanPropertyRowMapper<Actor>(Actor.class);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("filmId", filmId);
		list = this.getNamedParameterJdbcTemplate().query(sql, params, rm);
		return list;
	}

}
