package com.yash.Yash_Online_Portal.service;

import com.yash.Yash_Online_Portal.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    void addCategories(Category category);

    void updateCategories(Category category);

    void deleteCategories(Category category);

    boolean isExists(String category);
}
