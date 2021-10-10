package com.example.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
