package com.example.olginregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.olginregister.model.User;
import com.example.olginregister.repo.UserRepository;

@SpringBootApplication
public class OlginregisterApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OlginregisterApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        try {
            User user = new User();
            user.setEmail("abhishek@gmail.com");
            user.setUsername("jonny");
            user.setPassword(bCryptPasswordEncoder.encode("jonny")); // Remove "this" keyword
            user.setRole("NORMAL");
            this.userRepository.save(user); // Remove "this" keyword

            User user1 = new User();
            user1.setEmail("ankit@gmail.com"); // Changed email to avoid duplication
            user1.setUsername("ankit");
            user1.setPassword(bCryptPasswordEncoder.encode("ankit")); // Remove "this" keyword
            user1.setRole("ADMIN");
            this.userRepository.save(user1); // Remove "this" keyword
            
            System.out.println("Users saved successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred while saving users: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
