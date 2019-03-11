package com.yash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.yash.mapper.CategoryRowMapper;
import com.yash.model.Category;


@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;  
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public List<Category> getAllCategories() {
		String sql = "SELECT CATEGORY_ID,CATEGORY_TYPE FROM CATEGORY_MASTER";
		  List<Category> lstCategories  = getNamedParameterJdbcTemplate().query(sql, new CategoryRowMapper());
	        return lstCategories;
	}

	public Category getCategory(int id) {
		
		 String sql = "SELECT CATEGORY_ID,CATEGORY_TYPE FROM CATEGORY_MASTER WHERE CATEGORY_ID = :id";
	        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
	        Category category = getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters,new CategoryRowMapper());
	        return category;
		
		
	}

}
