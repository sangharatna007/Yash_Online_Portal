package com.yash.Yash_Online_Portal.service;

import com.yash.Yash_Online_Portal.dao.CategoryDao;
import com.yash.Yash_Online_Portal.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao;

    @Override
    public List<Category> getAllCategories() {
        return dao.getAllCategories();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return dao.getCategoryById(categoryId);
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
