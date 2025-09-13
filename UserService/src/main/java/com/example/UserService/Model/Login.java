package com.example.UserService.Model;

public class Login {
    private String username;
    private String password;
    public  Login(){}
    public  Login(String username,String password){
        this.password=password;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
