package com.example.olginregister.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.olginregister.model.User;

@Service
public class UserService {
    List<User> list =new ArrayList<>();

    public UserService(){
        // list.add(new User("jonny","jonny","suraj@gmail.com","ADMIN"));
        // list.add(new User("ankit","ankit","rakesh@gmail.com","normal"));
     
        // list.add(new User("anu","anu123","anu@gmail.com","NORMAL"));


    }
   

    //get all user
    public List<User> getAllUser(){
        return this.list;
    }

    //get single users
    public User getUser(String username) {
        return this.list.stream()
                       .filter(user -> user.getUsername().equals(username))
                       .findAny()
                       .orElse(null);
    }

    //add user
    public User getAdd(User user){
        this.list.add(user);
        return user;
    }
    

    
}
