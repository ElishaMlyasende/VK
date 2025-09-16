package com.example.UserService.Implement;

import com.example.UserService.Model.User;
import com.example.UserService.Repository.userRepository;
import com.example.UserService.Service.userService;
import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class userImpl implements userService {
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public userImpl(userRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public ResponseEntity<?> saveUser(User savedUser){
        savedUser.setPassword(passwordEncoder.encode(savedUser.getPassword()));
         User newUser =userRepository.save(savedUser);
         return  ResponseEntity.ok("User created successfully");
    }
    @Override
    public List<User>getAllUser() {
        List<User>users=userRepository.findAll();
        return  users;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(Long id) {
        Optional<User> result= userRepository.findById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("user not found");
        }

            return ResponseEntity.ok(result.get());

    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        Optional<User> findByID=userRepository.findById(id);
        if(findByID.isEmpty()){
            return ResponseEntity.badRequest().body("user not found and can not be deleted");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("user deleted successfully");
    }

    @Override
    public ResponseEntity<?> updateUser(Long id, User updatedUser) {
        Optional<User> checkId=userRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("user not found so information can not be updated");
        }
        userRepository.save(updatedUser);
        return ResponseEntity.ok("User information updated successfully");
    }



}
