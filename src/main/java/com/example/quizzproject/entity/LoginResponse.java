package com.example.quizzproject.entity;

public class LoginResponse {
    private int Id;
    private String UserName;
    private String Token;

    public LoginResponse(){}

    public LoginResponse(int id, String userName, String token) {
        Id = id;
        UserName = userName;
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
}


