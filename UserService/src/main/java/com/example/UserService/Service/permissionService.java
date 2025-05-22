package com.example.UserService.Service;

import com.example.UserService.Model.permission;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;

@Service
public interface permissionService {
    ResponseEntity<?> addPermission(permission savedPermission);
    List<permission> getAllPermission();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> updatePermission(Long id, permission UpdatedPermission);
}
