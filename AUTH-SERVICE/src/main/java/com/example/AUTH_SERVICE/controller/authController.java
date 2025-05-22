package com.example.AUTH_SERVICE.controller;

import com.example.AUTH_SERVICE.FEIGN.userClient;
import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {
    @Autowired
    private userClient userClient;
    public authController(userClient userClient){
        this.userClient=userClient;
    }

    @GetMapping("/test/{username}")
    public userResponse testFeign(@PathVariable String username) {
        return userClient.getUserByUsername(username);
    }
}
