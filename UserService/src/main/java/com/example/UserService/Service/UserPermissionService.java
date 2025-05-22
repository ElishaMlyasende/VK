package com.example.UserService.Service;


import com.example.UserService.DTO.RolePermissionWithDTO;
import com.example.UserService.DTO.UserPermissionDTO;
import com.example.UserService.DTO.userWithRoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserPermissionService {
    ResponseEntity<?>addUserPermission(Long user_id, List<Long> permission_id);
    ResponseEntity<?>updateUserPermission(Long user_id, List<Long>permission_id);
    ResponseEntity<?>deleteUserPermissions(Long user_id, List <Long>permission_id);
    ResponseEntity<?>getUserPermission(Long user_id);
    List<UserPermissionDTO> getAllRolesWithPermissions();



}
