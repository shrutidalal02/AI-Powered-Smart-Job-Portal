package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    
    // REGISTER API
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    
    // LOGIN API
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password) {

        return userService.loginUser(email, password);
    }
}