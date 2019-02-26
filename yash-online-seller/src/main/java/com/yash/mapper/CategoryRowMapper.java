package com.yash.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.model.Category;

public class CategoryRowMapper implements RowMapper<Category>{
	public Category mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Category category = new Category();
		category.setCategoryId(resultSet.getInt("CATEGORY_ID"));
		category.setCategoryType(resultSet.getString("CATEGORY_TYPE"));
		return category;
    }
}
