package com.example.UserService.Service;

import com.example.UserService.Model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface roleService {
    Role addRole(Role roleAdded);
    List<Role> allRoles();
    ResponseEntity<?> findRoleById(Long id);
    ResponseEntity<?> deleteRole(Long id);
    ResponseEntity<?> updateRole(Long id, Role roleUpdated);
}
