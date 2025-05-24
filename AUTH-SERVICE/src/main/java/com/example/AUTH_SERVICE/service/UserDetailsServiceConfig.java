package com.example.AUTH_SERVICE.service;

import com.example.AUTH_SERVICE.FEIGN.userClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService(userClient userClient) {
        return new CustomUserDetailService(userClient);
    }
}
