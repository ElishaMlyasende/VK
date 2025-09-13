package com.example.UserService.Controller;

import com.example.UserService.Model.Permission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserService.Service.permissionService;

import java.util.List;


@RestController
@RequestMapping("api/v1/permission")
public class permissionController {
    private  final permissionService permissionService;
    public  permissionController(permissionService permissionService){
        this.permissionService=permissionService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPermission(@RequestBody Permission savedPermission){
        return  permissionService.addPermission(savedPermission) ;
    }
    @GetMapping("/permissions")
    public List<Permission> getAllPermission(){
        return permissionService.getAllPermission();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")Long id){
        return permissionService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return permissionService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePermission(@PathVariable("id")Long id, @RequestBody Permission UpdatedPermission){
        return permissionService.updatePermission(id, UpdatedPermission);
    }
}
