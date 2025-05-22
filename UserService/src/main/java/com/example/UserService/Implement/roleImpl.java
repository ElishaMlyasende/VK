package com.example.UserService.Implement;

import com.example.UserService.Model.role;
import com.example.UserService.Repository.roleRepository;
import com.example.UserService.Service.roleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class roleImpl  implements roleService {
    private final roleRepository roleRepository;

    public roleImpl(roleRepository roleRepository){
        this.roleRepository=roleRepository;
    }


    @Override
    public ResponseEntity<?> addRole(role roleAdded) {
        roleRepository.save(roleAdded);
        return ResponseEntity.ok("role added successfully");
    }

    @Override
    public List<role> allRoles() {
      return roleRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findRoleById(Long id) {
        Optional<role> checkRoles=roleRepository.findById(id);
        if (checkRoles.isEmpty()){
            return  ResponseEntity.badRequest().body("role not found");
        }
        return  ResponseEntity.ok(checkRoles);
    }

    @Override
    public ResponseEntity<?> deleteRole(Long id) {
        Optional<role> checkRoles=roleRepository.findById(id);
        if (checkRoles.isEmpty()){
            return ResponseEntity.badRequest().body("role not found so  can not be delete");
        }
        roleRepository.deleteById(id);
        return ResponseEntity.ok("role deleted successfully");
    }

    @Override
    public ResponseEntity<?> updateRole(Long id, role roleUpdated) {
        Optional<role> checkId=roleRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Role not found");
        }
        roleRepository.save(roleUpdated);
        return ResponseEntity.ok("Role updated successfully");
    }
}
