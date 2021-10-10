package com.example.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
