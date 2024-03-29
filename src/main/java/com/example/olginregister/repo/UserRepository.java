package com.example.olginregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.olginregister.model.User;

public interface UserRepository extends JpaRepository<User,String> {

    

    
} 
