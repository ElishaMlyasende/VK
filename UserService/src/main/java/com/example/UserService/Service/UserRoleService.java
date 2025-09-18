package com.example.UserService.Service;

import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Model.Role;
import com.example.UserService.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;



@Service
public interface UserRoleService {
    ResponseEntity<?> assignUserRole(Long user_id, Long role_id);

    Role assignUsersToRole(Long roleId, List<Long> userIds);

    ResponseEntity<?> deleteUserRole(Long user_id, Long role_id);

    Role updateRoleUsers(Long roleId, List<Long> userIds);

    public ResponseEntity<?> getUserWithRoles(Long userId);
    List<userWithRoleDTO> getAllRolesWithPermissions();

}
