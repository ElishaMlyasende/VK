package com.example.UserService.Controller;

import com.example.UserService.DTO.RolePermissionWithDTO;
import com.example.UserService.Service.RolePermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/role-permission")
public class rolePermissionController {
    private final RolePermissionService rolePermissionService;
    public  rolePermissionController(RolePermissionService rolePermissionService){
        this.rolePermissionService=rolePermissionService;
    }
    @PostMapping("/add")
    public ResponseEntity<?>AssignRolePermission(@RequestParam Long role_id,
                                                 @RequestParam List<Long> permissions){
        return rolePermissionService.assignRolePermission(role_id,permissions);
    }
    @DeleteMapping("/remove")
    public  ResponseEntity<?> deleteRoleWithPermission(@RequestParam Long role_id,
                                                       @RequestParam List<Long> permissions){
        return rolePermissionService.deleteRolePermission(role_id,permissions);
    }
    @GetMapping("/{role_id}")
    public  ResponseEntity<?>  getRoleWithPermissionById(@PathVariable("role_id") Long role_id){
        return rolePermissionService.getRolePermissionById(role_id);
    }
    @PutMapping("update/{role_id}")
    public  ResponseEntity<?> updateRoleWithPermissions(@PathVariable("role_id")Long role_id,
                                                        @RequestParam List<Long>permissions){
        return rolePermissionService.updateRolePermission(role_id,permissions);

    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllRolesWithPermission(){
        List<RolePermissionWithDTO> data = rolePermissionService.getAllRolesWithPermissions();
        return ResponseEntity.ok(data);
    }
}
