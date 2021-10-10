package com.example.dev.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.entities.Product;
import com.example.dev.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
	private ProductService ProductService; 
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){ 
		List<Product> Products = ProductService.findAll(); 
		return ResponseEntity.ok().body(Products); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(ProductService.findById(id)); 
	}
	

}
