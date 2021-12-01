package com.example.quizzproject.controller;

import com.example.quizzproject.entity.JwtUtil;
import com.example.quizzproject.entity.LoginResponse;
import com.example.quizzproject.model.Token;
import com.example.quizzproject.model.User;
import com.example.quizzproject.service.TokenService;
import com.example.quizzproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

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
        User userDb = userService.findByUsername(userRe);
        if(userDb == null){
            user.setRole("User");
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        }
        else if(userDb != null && (userDb.getUsername()).equals(userRe)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username đã tồn tại");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }

    @PutMapping("/updateUser/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User newUser) {
        User user = userService.findByUsername(username);
        if(user == null || !newUser.getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found User");
        }
        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @GetMapping("/findByUserName/{username}")
    public ResponseEntity<?> findById(@PathVariable String username){
        User user = userService.findByUsername(username);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found User");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userLogin){
        User user = userService.findByUsername(userLogin.getUsername());
        if (user == null || !userLogin.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(user));
        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(user.getId());
        tokenService.createToken(token);
        LoginResponse loginResponse = new LoginResponse(user.getId(), user.getUsername(), user.getRole(), token.getToken());
        return ResponseEntity.ok(loginResponse);
    }

}
