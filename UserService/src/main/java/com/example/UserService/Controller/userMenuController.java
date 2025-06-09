package com.example.UserService.Controller;

import com.example.UserService.Model.user;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserService.Service.userMenuService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user/user_menu")
public class userMenuController {
    private  final  userMenuService userMenuService;
    //constructor
    public  userMenuController(userMenuService userMenuService){
        this.userMenuService=userMenuService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUserMenu(@RequestParam Long user_id, @RequestParam List<Long> menuIds){
        return userMenuService.addUserMenu(user_id, menuIds);
    }
    @PutMapping("/update")
    public ResponseEntity<?>updateUserMenu(@RequestParam Long id, @RequestParam  List<Long> menuIds){
        return userMenuService.updateUserMenu(id,menuIds);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteUserMenu(@RequestParam Long id, @RequestParam List<Long>menuIds){
        return userMenuService.deleteUserMenu(id,menuIds);
    }
}
