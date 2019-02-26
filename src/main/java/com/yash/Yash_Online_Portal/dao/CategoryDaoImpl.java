package com.yash.Yash_Online_Portal.dao;

import com.yash.Yash_Online_Portal.mapper.CategoryRowMapper;
import com.yash.Yash_Online_Portal.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM category";
        RowMapper mapper = new CategoryRowMapper();
        return template.query(sql, mapper);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        String sql = "SELECT categoryId, categoryTitle from category where categoryId = ?";
        RowMapper<Category > mapper = new BeanPropertyRowMapper<Category>(Category.class);
        Category category = template.queryForObject(sql, mapper,categoryId );
        return category;
    }

    @Override
    public void addCategories(Category category) {

    }

    @Override
    public void updateCategories(Category category) {

    }

    @Override
    public void deleteCategories(Category category) {

    }

    @Override
    public boolean isExists(String category) {
        return false;
    }
}
