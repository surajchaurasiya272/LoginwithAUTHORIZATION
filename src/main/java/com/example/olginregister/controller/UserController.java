package com.example.olginregister.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.olginregister.model.User;
import com.example.olginregister.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("/")
    public List<User> getAllData(String username) {
        return this.userservice.getAllUser();
    }

    @GetMapping("/{username}")
    public User getOneData(@PathVariable String username) {
        return this.userservice.getUser(username);
    }

    @PostMapping("/")
    public User getAddUser(@RequestBody User user){
        return this.userservice.getAdd(user);
    }

    
    
    
}
