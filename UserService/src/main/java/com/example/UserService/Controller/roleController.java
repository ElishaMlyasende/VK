package com.example.UserService.Controller;

import com.example.UserService.Model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserService.Service.roleService;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class roleController {
    private final roleService roleService;
    public roleController(roleService roleService){
        this.roleService=roleService;

    }
    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role roleSaved) {
        Role savedRole = roleService.addRole(roleSaved);
        return ResponseEntity.ok(savedRole);
    }
    @GetMapping("/roles")
    public List<Role> getAllRole(){
        return roleService.allRoles();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findRoleById(@PathVariable("id") Long id){
        return roleService.findRoleById(id);

    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteRoleById(@PathVariable("id")Long id){
        return roleService.deleteRole(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoles(@PathVariable("id")Long id, @RequestBody Role updatedRole ){
        return roleService.updateRole(id,updatedRole);
    }
}
