package com.example.AUTH_SERVICE.service;

import com.example.AUTH_SERVICE.FEIGN.userClient;
import com.example.AUTH_SERVICE.model.loginRequest;
import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService{
  private final userClient userClient;
  public CustomUserDetailService(userClient userClient){
      this.userClient=userClient;
  }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userResponse user=userClient.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }


}
