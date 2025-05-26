package com.example.UserService.Implement;

import com.example.UserService.Model.menu;
import com.example.UserService.Model.user;
import com.example.UserService.Service.userMenuService;
import org.springframework.http.ResponseEntity;
import com.example.UserService.Repository.userRepository;
import com.example.UserService.Repository.menuRepository;

import java.util.List;
import java.util.Optional;

public class userMenuImpl implements userMenuService {
    private userRepository userRepository;
    private menuRepository menuRepository;
    public userMenuImpl(userRepository userRepository, menuRepository menuRepository){
        this.menuRepository=menuRepository;
        this.userRepository=userRepository;
    }
    @Override
    public ResponseEntity<?> addUserMenu(Long id, List<Long> menuIds) {
        Optional<user> checkUser=userRepository.findById(id);
        if (checkUser.isEmpty()){
            return  ResponseEntity.badRequest().body("user not exist");
        }
        List<menu> checkMenuList=menuRepository.findAllById(menuIds);
        if (checkMenuList.size()!=menuIds.size()){
            return ResponseEntity.badRequest().body("Some menu not found");
        }
        user user= checkUser.get();
        user.getUserMenus().addAll(checkMenuList);
        userRepository.save(user);
        return ResponseEntity.ok("user menu added successfully");
    }

    @Override
    public ResponseEntity<?> updateUserMenu(menu updatedUserMenu, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUserMenu(Long id) {
        return null;
    }

    @Override
    public List<menu> getAllUserMenu() {
        return List.of();
    }
}
