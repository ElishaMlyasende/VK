package com.example.UserService.Service;

import com.example.UserService.Model.role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface roleService {
    ResponseEntity<?> addRole(role roleAdded);
    List<role> allRoles();
    ResponseEntity<?> findRoleById(Long id);
    ResponseEntity<?> deleteRole(Long id);
    ResponseEntity<?> updateRole(Long id, role roleUpdated);
}
