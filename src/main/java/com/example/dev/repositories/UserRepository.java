package com.example.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
