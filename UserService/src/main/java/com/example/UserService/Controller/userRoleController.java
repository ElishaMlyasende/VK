package com.example.UserService.Controller;

import com.example.UserService.Model.Role;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.roleRepository;
import com.example.UserService.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user_Role")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // frontend yako URL

public class userRoleController {

    @Autowired
    private roleRepository roleRepository;

    @Autowired
    private userRepository userRepository;

    // Assign a single user to a single role
    @PutMapping("/assign")
    public ResponseEntity<?> assignUserToRole(@RequestBody Map<String, Long> payload) {
        Long userId = payload.get("userId");
        Long roleId = payload.get("roleId");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Clear previous roles so user has only this role
        user.getRoles().clear();
        user.getRoles().add(role);
        userRepository.save(user);

        return ResponseEntity.ok("User assigned to role successfully");
    }
}
