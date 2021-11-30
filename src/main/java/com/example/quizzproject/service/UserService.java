package com.example.quizzproject.service;

import com.example.quizzproject.model.User;

public interface UserService {
    public User createUser(User user);
    public User findByUsername(String username);
}
