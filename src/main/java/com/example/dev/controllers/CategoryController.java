package com.example.dev.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.entities.Category;
import com.example.dev.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	@Autowired
	private CategoryService CategoryService; 
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){ 
		List<Category> Categories = CategoryService.findAll(); 
		return ResponseEntity.ok().body(Categories); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(CategoryService.findById(id)); 
	}
	

}
