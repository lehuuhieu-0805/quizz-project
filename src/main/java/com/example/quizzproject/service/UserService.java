package com.example.quizzproject.service;

import com.example.quizzproject.model.User;

public interface UserService {
    User createUser(User user);
    User findByUsername(String username);
}
