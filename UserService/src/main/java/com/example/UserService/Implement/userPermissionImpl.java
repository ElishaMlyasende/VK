package com.example.UserService.Implement;

import com.example.UserService.DTO.UserPermissionDTO;
import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Model.permission;
import com.example.UserService.Model.user;
import com.example.UserService.Repository.permissionRepository;
import com.example.UserService.Repository.userRepository;
import com.example.UserService.Service.UserPermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userPermissionImpl implements UserPermissionService {
    private final userRepository userRepository;
    private  final permissionRepository permissionRepository;

    public userPermissionImpl(userRepository userRepository, permissionRepository permissionRepository){
        this.permissionRepository=permissionRepository;
        this.userRepository=userRepository;
    }
    @Override
    public ResponseEntity<?> addUserPermission(Long user_id, List<Long> permission_id) {
        Optional<user> checkUser=userRepository.findById(user_id);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user does not exist");
        }
        List<permission> permissionsCheck=permissionRepository.findAllById(permission_id);
        if (permissionsCheck.size()!=permission_id.size()){
            return ResponseEntity.badRequest().body("some permissions do not exist");
        }
        user user=checkUser.get();
        user.getPermissions().addAll(permissionsCheck);
        userRepository.save(user);
        return ResponseEntity.ok("permission added successfully to user");

    }

    @Override
    public ResponseEntity<?> updateUserPermission(Long user_id, List<Long> permission_id) {Optional<user> checkUser=userRepository.findById(user_id);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user does not exist");
        }
        List<permission> permissionsCheck=permissionRepository.findAllById(permission_id);
        if (permissionsCheck.size()!=permission_id.size()){
            return ResponseEntity.badRequest().body("some permissions do not exist");
        }
        user user=checkUser.get();
        user.getPermissions().addAll(permissionsCheck);
        userRepository.save(user);
        return ResponseEntity.ok("permission updated successfully to user");
    }

    @Override
    public ResponseEntity<?> deleteUserPermissions(Long user_id, List <Long> permission_id) {
        Optional<user> checkUser=userRepository.findById(user_id);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user does not exist");
        }
        List<permission> permissionsCheck=permissionRepository.findAllById(permission_id);
        if (permissionsCheck.size()!=permission_id.size()){
            return ResponseEntity.badRequest().body("some permissions do not exist");
        }
        user user=checkUser.get();
        user.getPermissions().removeAll(permissionsCheck);
        userRepository.save(user);
        return ResponseEntity.ok("permission removed successfully to user");
    }

    @Override
    public ResponseEntity<?> getUserPermission(Long user_id) {
        Optional<user> checkUser=userRepository.findById(user_id);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user does not exist");
        }
        UserPermissionDTO dto=new UserPermissionDTO(checkUser.get());
        return ResponseEntity.ok(dto);
    }

    @Override
    public List<UserPermissionDTO> getAllRolesWithPermissions() {
        List<user> user = userRepository.findAll();
        return user.stream()
                .map(UserPermissionDTO::new)
                .collect(Collectors.toList());
    }
}
