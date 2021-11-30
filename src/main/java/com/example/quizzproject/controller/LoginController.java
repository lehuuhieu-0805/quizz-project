package com.example.quizzproject.controller;

import com.example.quizzproject.entity.JwtUtil;
import com.example.quizzproject.model.Token;
import com.example.quizzproject.model.User;
import com.example.quizzproject.service.TokenService;
import com.example.quizzproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        String userRe = user.getUsername();
        String userDb = (userService.findByUsername(user.getUsername())).getUsername();
        if(userDb != null && userDb.equals(userRe)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username đã tồn tại");
        }else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        }
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        user = userService.findByUsername(user.getUsername());
        if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(user));
        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(user.getId());
        tokenService.createToken(token);
        return ResponseEntity.ok(token.getToken());
    }

}
