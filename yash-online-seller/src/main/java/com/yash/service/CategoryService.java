package com.yash.service;

import java.util.List;

import com.yash.model.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories();

	public Category getCategory(int id);
}
