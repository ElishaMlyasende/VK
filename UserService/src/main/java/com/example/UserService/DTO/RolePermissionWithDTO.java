package com.example.UserService.DTO;

import com.example.UserService.Model.permission;
import com.example.UserService.Model.role;

import java.util.Set;
import java.util.stream.Collectors;

public class RolePermissionWithDTO {
    private Long id;
    private String description;
    private Set<String> permissions;

    public  RolePermissionWithDTO(role role){
        this.id=role.getId();
        this.description=role.getDescription();
        this.permissions=role.getPermissions().stream().map(permission::getName).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
