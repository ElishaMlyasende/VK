package com.example.UserService.Implement;

import com.example.UserService.Model.permission;
import com.example.UserService.Service.permissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.UserService.Repository.permissionRepository;

import java.util.List;
import java.util.Optional;


@Service
public class permissionImpl implements permissionService {
    private final permissionRepository permissionRepository;
    public  permissionImpl (permissionRepository permissionRepository){
        this.permissionRepository=permissionRepository;
    }

    @Override
    public ResponseEntity<?> addPermission(permission savedPermission) {
        permissionRepository.save(savedPermission);
        return ResponseEntity.ok("Permission Added successfully");
    }

    @Override
    public List<permission> getAllPermission() {
        return  permissionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Optional<permission> checkId=permissionRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("permissioon not found so can not be delete");
        }
        permissionRepository.deleteById(id);
        return ResponseEntity.ok("permission deleted successfully");
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<permission> checkId=permissionRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("permission not found");
        }
        return ResponseEntity.ok(checkId);
    }

    @Override
    public ResponseEntity<?> updatePermission(Long id, permission UpdatedPermission) {
        Optional<permission> checkid=permissionRepository.findById(id);
        if (checkid.isEmpty()){
            return  ResponseEntity.badRequest().body("permission not found so can not be edited");
        }
        permissionRepository.save(UpdatedPermission);
        return ResponseEntity.ok("Permission Updated successfully");
    }
}
