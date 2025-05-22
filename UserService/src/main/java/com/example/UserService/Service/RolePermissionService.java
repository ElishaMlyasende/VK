package com.example.UserService.Service;

import com.example.UserService.DTO.RolePermissionWithDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface RolePermissionService {
    ResponseEntity<?>assignRolePermission(Long role_id, List<Long> permissions);
    ResponseEntity<?>deleteRolePermission(Long role_id, List<Long>permissions);
    ResponseEntity<?>updateRolePermission(Long role_id,List<Long> permissions);
    ResponseEntity<?>getRolePermissionById(Long role_id);
   List<RolePermissionWithDTO> getAllRolesWithPermissions();

}
