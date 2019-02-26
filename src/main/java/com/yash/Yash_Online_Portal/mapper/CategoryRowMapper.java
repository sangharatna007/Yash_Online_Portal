package com.yash.Yash_Online_Portal.mapper;

import com.yash.Yash_Online_Portal.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setCategoryId(resultSet.getInt("categoryId"));
        category.setCategoryTitle(resultSet.getString("categoryTitle"));
        return category;
    }
}
