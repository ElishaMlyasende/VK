package com.example.UserService.Implement;

import com.example.UserService.Model.Role;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.roleRepository;
import com.example.UserService.Service.UserRoleService;
import org.springframework.http.ResponseEntity;
import com.example.UserService.Repository.userRepository;
import org.springframework.stereotype.Service;
import com.example.UserService.DTO.userWithRoleDTO;


import java.util.Set;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class userRoleImpl implements UserRoleService {
    private final userRepository userRepository;
    private final roleRepository roleRepository;
    public userRoleImpl(userRepository userRepository, roleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }
    @Override
    public ResponseEntity<?> assignUserRole(Long user_id, Long role_id) {
        Optional<User> checkUser=userRepository.findById(user_id);
        Optional<Role> checkRole=roleRepository.findById(role_id);
        if (checkUser.isEmpty()|checkRole.isEmpty()){
            return ResponseEntity.badRequest().body("role or user not found");
        }
        User user=checkUser.get();
        Role role =checkRole.get();
        user.getRoles().add(role);
        userRepository.save(user);
        return ResponseEntity.ok("roles assigned to the user");

    }

    @Override
    public ResponseEntity<?> deleteUserRole(Long user_id, Long role_id) {
        Optional<User> checkUser=userRepository.findById(user_id);
        Optional<Role> checkRole=roleRepository.findById(role_id);
        if (checkUser.isEmpty()|checkRole.isEmpty()){
            return ResponseEntity.badRequest().body("role or user not found");
        }
        User user=checkUser.get();
        Role role =checkRole.get();
        user.getRoles().remove(role);
        userRepository.save(user);
        return ResponseEntity.ok("roles removed from user");

    }

    @Override
    public User updateUserRoles(Long userId, List<Long> roleIds) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Set<Role> roles = new HashSet<>(roleRepository.findAllById(roleIds));
        User existingUser = userOpt.get();
        existingUser.setRoles(roles);
        return userRepository.save(existingUser);
    }

    @Override
    public ResponseEntity<?> getUserWithRoles(Long userId) {
        Optional<User> checkUser=userRepository.findById(userId);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user roles not found");
        }
        userWithRoleDTO dto = new userWithRoleDTO(checkUser.get());
        return ResponseEntity.ok(dto);
    }

    @Override
    public List<userWithRoleDTO> getAllRolesWithPermissions() {
        List<User> user = userRepository.findAll();
        return user.stream()
                .map(userWithRoleDTO::new)
                .collect(Collectors.toList());
    }


}
