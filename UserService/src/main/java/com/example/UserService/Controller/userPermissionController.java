package com.example.UserService.Controller;

import com.example.UserService.DTO.UserPermissionDTO;
import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Service.UserPermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/user-permission")
public class userPermissionController {
    private final UserPermissionService userPermissionService;

    public userPermissionController(UserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUserPermission(@RequestParam Long user_id, @RequestParam List<Long> permission_id) {
        return userPermissionService.addUserPermission(user_id, permission_id);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUserPermission(@RequestParam Long user_id, @RequestParam List<Long> permission_id){
        return userPermissionService.updateUserPermission(user_id,permission_id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserPermission(@RequestParam Long user_id, @RequestParam List<Long>permission_id){
        return userPermissionService.deleteUserPermissions(user_id, permission_id);
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<?> getUserRoles(@PathVariable("user_id") Long user_id){
        return userPermissionService.getUserPermission(user_id);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllWithPermission(){
        List<UserPermissionDTO> data = userPermissionService.getAllRolesWithPermissions();
        return ResponseEntity.ok(data);
    }

}
