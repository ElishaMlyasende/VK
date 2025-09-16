package com.example.UserService.Controller;

import com.example.UserService.Model.User;
import com.example.UserService.Service.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class userController {
    private final userService userService;
    public userController(userService userService){
        this.userService=userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> savedUser(@RequestBody User savedUser){
     return  userService.saveUser(savedUser);
    }
    @GetMapping("/all")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id")Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        return  userService.deleteUser(id);

    }
    @PutMapping("/Edit/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id")Long id, @RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);
    }


}

