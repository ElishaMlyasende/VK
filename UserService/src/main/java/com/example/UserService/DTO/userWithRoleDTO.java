package com.example.UserService.DTO;

import com.example.UserService.Model.Role;
import com.example.UserService.Model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class userWithRoleDTO {

    private Long id;
    private String username;
    private Set<String> roles;

    // Constructor to initialize fields based on User object
    public userWithRoleDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        // Collect role names from the roles associated with the user
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for roles
    public Set<String> getRoles() {
        return roles;
    }
}
