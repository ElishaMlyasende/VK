package com.example.UserService.Implement;

import com.example.UserService.DTO.RolePermissionWithDTO;
import com.example.UserService.Model.Permission;
import com.example.UserService.Model.Role;
import com.example.UserService.Service.RolePermissionService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import com.example.UserService.Repository.roleRepository;
import com.example.UserService.Repository.permissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class rolePermissionImpl implements RolePermissionService {
    private final roleRepository roleRepository;
    private  final permissionRepository permissionRepository;
    public rolePermissionImpl(roleRepository roleRepository, permissionRepository permissionRepository){
        this.permissionRepository=permissionRepository;
        this.roleRepository=roleRepository;
    }
    @Override
    public ResponseEntity<?> assignRolePermission(Long role_id, List<Long> permissions) {
        Optional<Role> checkRole=roleRepository.findById(role_id);
        if ((checkRole.isEmpty())){
            return  ResponseEntity.badRequest().body("role does not exist");
        }
        List<Permission> checkPermissions=permissionRepository.findAllById(permissions);
        if (checkPermissions.size()!= permissions.size()){
            return ResponseEntity
                    .badRequest()
                    .body("Some permissions do not exist");
        }
        Role role=checkRole.get();
        role.getPermissions().addAll(checkPermissions);
        roleRepository.save(role);
        return  ResponseEntity.ok("permission assigned successfully to user");

    }

    @Override
    public ResponseEntity<?> deleteRolePermission(Long role_id, List<Long> permissions) {
        Optional<Role> checkRole=roleRepository.findById(role_id);
        if ((checkRole.isEmpty())){
            return  ResponseEntity.badRequest().body("role does not exist");
        }
        List<Permission> checkPermissions=permissionRepository.findAllById(permissions);
        if (checkPermissions.size()!= permissions.size()){
            return ResponseEntity
                    .badRequest()
                    .body("Some permissions do not exist");
        }
        Role role=checkRole.get();
        role.getPermissions().removeAll(checkPermissions);
        roleRepository.save(role);
        return  ResponseEntity.ok("permission deleted successfully to user");

    }

    @Override
    @Transactional
    public ResponseEntity<?> updateRolePermission(Long role_id, List<Long> permissions) {
        Optional<Role> optionalRole = roleRepository.findById(role_id);
        if (optionalRole.isEmpty()) {
            return ResponseEntity.badRequest().body("Role does not exist");
        }

        List<Permission> permissionList = permissionRepository.findAllById(permissions);
        if (permissionList.size() != permissions.size()) {
            return ResponseEntity.badRequest().body("Some permissions do not exist");
        }

        Role role = optionalRole.get();

        // Clear existing permissions
        role.getPermissions().clear();

        // Add the new ones
        role.getPermissions().addAll(permissionList);

        // Save changes
        Role updatedRole = roleRepository.save(role);

        return ResponseEntity.ok(updatedRole); // return updated role
    }


    @Override
    public ResponseEntity<?> getRolePermissionById(Long role_id) {
        Optional<Role> checkRole=roleRepository.findById(role_id);
        if ((checkRole.isEmpty())){
            return  ResponseEntity.badRequest().body("role does not exist");
        }
        Role role=checkRole.get();
        RolePermissionWithDTO DTO=new RolePermissionWithDTO(checkRole.
                get());
        return  ResponseEntity.
                ok(DTO);
    }

    @Override
    public List<RolePermissionWithDTO> getAllRolesWithPermissions() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .map(RolePermissionWithDTO::new)
                .collect(Collectors.toList());
    }
}
