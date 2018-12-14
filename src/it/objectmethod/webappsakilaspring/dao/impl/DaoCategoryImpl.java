package it.objectmethod.webappsakilaspring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import it.objectmethod.webappsakilaspring.dao.IDaoCategory;
import it.objectmethod.webappsakilaspring.model.Category;

public class DaoCategoryImpl extends NamedParameterJdbcDaoSupport implements IDaoCategory{

	@Override
	public List<Category> allcategories() {
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		BeanPropertyRowMapper<Category> rm = new BeanPropertyRowMapper<Category>(Category.class);
		list = this.getNamedParameterJdbcTemplate().query(sql, rm);
		return list;
	}

}
