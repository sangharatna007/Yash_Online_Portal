package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Category;
import com.yash.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getProductList() {
		List<Category> category = categoryService.getAllCategories();
		if (category.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);

	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getProductById(@PathVariable int id) {
		Category category = categoryService.getCategory(id);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
}
