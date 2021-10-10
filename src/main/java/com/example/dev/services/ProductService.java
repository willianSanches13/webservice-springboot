package com.example.dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.entities.Product;
import com.example.dev.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service 
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepository; 
	
	public List<Product> findAll(){
		return ProductRepository.findAll(); 
	}
	public Product findById(Long id) {
		Optional <Product> obj = ProductRepository.findById(id);
		return obj.get(); 
	}

} 
