package com.example.AUTH_SERVICE.model;

public class loginRequest {
    private String username;
    private String password;
    public  loginRequest(){}
    public  loginRequest(String username, String password){
        this.password=password;
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
