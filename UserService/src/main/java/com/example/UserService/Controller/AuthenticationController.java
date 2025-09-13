package com.example.UserService.Controller;

import com.example.UserService.Jwt.CustomUserDetail;
import com.example.UserService.Jwt.CustomUserDetailService;
import com.example.UserService.Jwt.JwtService;
import com.example.UserService.Model.Login;
import com.example.UserService.Model.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private CustomUserDetail customUserDetail;
    private  final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailService customUserDetailService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService, CustomUserDetailService customUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.customUserDetailService = customUserDetailService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> Authentication(@RequestBody Login request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
       final CustomUserDetail customUserDetail1=customUserDetailService.loadUserByUsername(request.getUsername());
        final String  token=jwtService.GenerateToken(customUserDetail1);
        return  ResponseEntity.ok().body(new TokenResponse(token));

    }
}
