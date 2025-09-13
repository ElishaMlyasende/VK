package com.example.UserService.Jwt;

import com.example.UserService.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.UserService.Repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private  final userRepository userRepository;
    public CustomUserDetailService(userRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
        return new CustomUserDetail(user);
    }
}
