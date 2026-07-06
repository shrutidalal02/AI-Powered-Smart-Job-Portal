package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    // REGISTER USER
    public User registerUser(User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        return userRepository.save(user);
    }

    
    // LOGIN USER
    public String loginUser(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}
