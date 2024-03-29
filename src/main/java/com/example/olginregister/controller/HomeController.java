package com.example.olginregister.controller;


import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/public")

public class HomeController {


    @GetMapping("/home")
    public String getMethodName() {
        return "this is home page";
    }
    
    
}
