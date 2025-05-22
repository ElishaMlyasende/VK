package com.example.UserService.Service;

import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Model.role;
import com.example.UserService.Model.user;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;



@Service
public interface UserRoleService {
    ResponseEntity<?> assignUserRole(Long user_id, Long role_id);
    ResponseEntity<?> deleteUserRole(Long user_id, Long role_id);
    user updateUserRoles(Long userId, List<Long> roleIds);
    public ResponseEntity<?> getUserWithRoles(Long userId);
    List<userWithRoleDTO> getAllRolesWithPermissions();

}
