package com.example.quizzproject.service;

import com.example.quizzproject.model.User;
import com.example.quizzproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public  User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
