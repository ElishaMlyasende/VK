package com.example.UserService.Service;

import com.example.UserService.Model.Permission;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface permissionService {
    ResponseEntity<?> addPermission(Permission savedPermission);
    List<Permission> getAllPermission();
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> updatePermission(Long id, Permission UpdatedPermission);
}
