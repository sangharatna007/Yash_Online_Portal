package com.yash.Yash_Online_Portal.controller;


import com.yash.Yash_Online_Portal.dao.CategoryDaoImpl;
import com.yash.Yash_Online_Portal.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController
{
    @Autowired
    private CategoryDaoImpl dao;

    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category> categories = dao.getAllCategories();

        if(categories == null || categories.isEmpty())
        {
            return ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
    }






}
