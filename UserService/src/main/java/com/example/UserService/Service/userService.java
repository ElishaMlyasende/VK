package com.example.UserService.Service;

import com.example.UserService.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface userService {
    ResponseEntity<?> saveUser(User savedUser);
    List<User> getAllUser();
    ResponseEntity<?> getUserById(Long id);
    ResponseEntity<?> deleteUser(Long id);
    ResponseEntity<?> updateUser(Long id, User updatedUser);
}
