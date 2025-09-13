package com.example.UserService.Controller;

import com.example.UserService.DTO.userWithRoleDTO;
import com.example.UserService.Model.User;
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
    @PostMapping("/add/{user_id}/{role_id}")
    public ResponseEntity<?>assignUserRole(@PathVariable("user_id") Long user_id, @PathVariable("role_id") Long role_id){
        return userRoleService.assignUserRole(user_id,role_id);
    }
    @DeleteMapping("/remove/{user_id}/{role_id}")
    public ResponseEntity<?> removeUserRoles(@PathVariable("user_id") Long user_id,
                                             @PathVariable("role_id") Long role_id){
        return userRoleService.deleteUserRole(user_id,role_id);
    }
    @GetMapping("/roles/{user_id}")
    public  ResponseEntity<?> getAllUserRoles(@PathVariable("user_id") Long userId){
        return userRoleService.getUserWithRoles(userId);
    }
    @PutMapping("/users/{userId}/roles")
    public ResponseEntity<?> updateUserRoles(
            @PathVariable("user_id") Long user_id,
            @RequestBody List<Long> roleIds) {
        User updatedUser = userRoleService.updateUserRoles(user_id, roleIds);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllWithPermission(){
        List<userWithRoleDTO> data = userRoleService.getAllRolesWithPermissions();
        return ResponseEntity.ok(data);
    }


}
