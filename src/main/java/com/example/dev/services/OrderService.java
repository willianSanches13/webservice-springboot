package com.example.dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.entities.Order;
import com.example.dev.entities.User;
import com.example.dev.repositories.OrderRepository;
import com.example.dev.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service 
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository; 
	
	public List<Order> findAll(){
		return orderRepository.findAll(); 
	}
	public Order findById(Long id) {
		Optional <Order> obj = orderRepository.findById(id);
		return obj.get(); 
	}

} 
