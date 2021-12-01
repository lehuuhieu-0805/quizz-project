package com.example.quizzproject.entity;

public class LoginResponse {
    private int Id;
    private String UserName;
    private String Role;
    private String Token;

    public LoginResponse(){}

    public LoginResponse(int id, String userName, String role, String token) {
        Id = id;
        UserName = userName;
        Role = role;
        Token = token;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}


