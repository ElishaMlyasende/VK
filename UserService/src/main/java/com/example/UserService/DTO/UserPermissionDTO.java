package com.example.UserService.DTO;

import com.example.UserService.Model.permission;
import com.example.UserService.Model.user;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserPermissionDTO {
    private Long id;
    private String username;
    private Set<String> permissions;

    public UserPermissionDTO(user user){
        this.id=user.getId();
        this.username=user.getUsername();
        this.permissions=user.getPermissions().stream().map(permission::getName ).collect(Collectors.toSet());


    }

    public Long getId() {
        return id;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getPermissions() {
        return permissions;
    }
}
