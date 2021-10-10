package com.example.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dev.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
