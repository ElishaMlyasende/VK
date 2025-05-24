package com.example.UserService.Implement;

import com.example.UserService.Model.user;
import com.example.UserService.Repository.userRepository;
import com.example.UserService.Service.userService;
import com.example.UserService.mapper.userMapper;
import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<?> saveUser(user savedUser){
        savedUser.setPassword(passwordEncoder.encode(savedUser.getPassword()));
         user newUser =userRepository.save(savedUser);
         return  ResponseEntity.ok("User created successfully");
    }
    @Cacheable(value = "users", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    @Override
    public Page<user> getAllUser(Pageable pageable) {
        System.out.println(">>> Fetching users from DB <<<");
        return userRepository.findAll(pageable);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(Long id) {
        Optional<user> result= userRepository.findById(id);
        if(result.isEmpty()){
            return ResponseEntity.badRequest().body("user not found");
        }

            return ResponseEntity.ok(result.get());

    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        Optional<user> findByID=userRepository.findById(id);
        if(findByID.isEmpty()){
            return ResponseEntity.badRequest().body("user not found and can not be deleted");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("user deleted successfully");
    }

    @Override
    public ResponseEntity<?> updateUser(Long id, user updatedUser) {
        Optional<user> checkId=userRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("user not found so information can not be updated");
        }
        userRepository.save(updatedUser);
        return ResponseEntity.ok("User information updated successfully");
    }

    @Override
    public ResponseEntity<?> findUserByUsername(String username) {
        Optional<user> findUserByUserName=userRepository.findByUsername(username);
        if (findUserByUserName.isEmpty()){
            return  ResponseEntity.badRequest().body("user not found");
        }
        user user=findUserByUserName.get();
        userResponse response = userMapper.mapToUserResponse(user);
        return ResponseEntity.ok(response);
    }
}
