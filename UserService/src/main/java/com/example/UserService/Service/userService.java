package com.example.UserService.Service;

import com.example.UserService.Model.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface userService {
    ResponseEntity<?> saveUser(user savedUser);
    Page<user> getAllUser(Pageable pageable);
    ResponseEntity<?> getUserById(Long id);
    ResponseEntity<?> deleteUser(Long id);
    ResponseEntity<?> updateUser(Long id, user updatedUser);
    ResponseEntity<?> findUserByUsername(String username);
}
