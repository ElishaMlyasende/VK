package com.example.UserService.Controller;

import com.example.UserService.Model.user;
import com.example.UserService.Service.userService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class userController {
    private final userService userService;
    public userController(userService userService){
        this.userService=userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> savedUser(@RequestBody user savedUser){
     return  userService.saveUser(savedUser);
    }
    @GetMapping("/all")
    public Page<user> getAllUser(@RequestParam(defaultValue="0") int page,
                                 @RequestParam(defaultValue = "5") int size)
    {
        Pageable pageable= PageRequest.of(page,size);
        return userService.getAllUser(pageable);
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
    public ResponseEntity<?> updateUser(@PathVariable("id")Long id, @RequestBody  user updatedUser){
        return userService.updateUser(id,updatedUser);
    }
    @GetMapping("/getUser/{username}")
    public  ResponseEntity<?> findUserByUsername(@PathVariable("username") String username){
        return  userService.findUserByUsername(username);
    }

}

