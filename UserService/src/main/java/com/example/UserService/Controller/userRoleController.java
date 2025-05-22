package com.example.UserService.Controller;

import com.example.UserService.DTO.RolePermissionWithDTO;
import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Model.user;
import com.example.UserService.Service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user_Role")
public class userRoleController {
    private final UserRoleService userRoleService;
    public userRoleController(UserRoleService userRoleService){
        this.userRoleService=userRoleService;
    }
    @PostMapping("/add")
    public ResponseEntity<?>assignUserRole(@RequestParam Long user_id, @RequestParam Long role_id){
        return userRoleService.assignUserRole(user_id,role_id);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeUserRoles(@RequestParam Long user_id, @RequestParam Long role_id){
        return userRoleService.deleteUserRole(user_id,role_id);
    }
    @GetMapping("/roles/{userId}")
    public  ResponseEntity<?> getAllUserRoles(@PathVariable("userId") Long userId){
        return userRoleService.getUserWithRoles(userId);
    }
    @PutMapping("/users/{userId}/roles")
    public ResponseEntity<?> updateUserRoles(
            @PathVariable Long userId,
            @RequestBody List<Long> roleIds) {
        user updatedUser = userRoleService.updateUserRoles(userId, roleIds);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllWithPermission(){
        List<userWithRoleDTO> data = userRoleService.getAllRolesWithPermissions();
        return ResponseEntity.ok(data);
    }


}
