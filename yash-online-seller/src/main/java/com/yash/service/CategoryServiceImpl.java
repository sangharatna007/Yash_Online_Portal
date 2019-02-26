package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.CategoryDao;
import com.yash.model.Category;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	public Category getCategory(int id) {
		return categoryDao.getCategory(id);
	}

}
