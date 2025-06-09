package com.example.AUTH_SERVICE.controller;

import com.example.AUTH_SERVICE.FEIGN.userClient;
import com.example.AUTH_SERVICE.JWT.jwtUtil;
import com.example.AUTH_SERVICE.model.loginRequest;
import com.example.AUTH_SERVICE.model.token;
import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class authController {

    @Autowired
    private userClient userClient;

    @Autowired
    private jwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public authController(userClient userClient, jwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userClient = userClient;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody loginRequest loginrequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginrequest.getUsername(), loginrequest.getPassword()));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        final userResponse response = userClient.getUserByUsername(loginrequest.getUsername());
        final String tokenGenerated = jwtUtil.generateToken(response);
        return ResponseEntity.ok(new token(tokenGenerated));
    }
}
