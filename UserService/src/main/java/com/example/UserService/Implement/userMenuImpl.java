package com.example.UserService.Implement;
import com.example.UserService.Model.menu;
import com.example.UserService.Model.user;
import com.example.UserService.Model.userMenu;
import com.example.UserService.Repository.userRepository;
import com.example.UserService.Repository.menuRepository;


import com.example.UserService.Service.userMenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class userMenuImpl implements userMenuService {
    private final  userRepository userRepository;
    private final menuRepository menuRepository;
    public userMenuImpl(userRepository userRepository, menuRepository menuRepository){
        this.menuRepository=menuRepository;
        this.userRepository=userRepository;
    }
    @Override
    public ResponseEntity<?> addUserMenu(Long id, List<Long> menuIds) {
        Optional<user> checkUser = userRepository.findById(id);
        if (checkUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        List<menu> checkMenuList = menuRepository.findAllById(menuIds);
        if (checkMenuList.size() != menuIds.size()) {
            return ResponseEntity.badRequest().body("Some menus not found");
        }

        user user = checkUser.get();
        Set<userMenu> userMenuSet = user.getUserMenus();  // Get existing userMenu set

        for (menu m : checkMenuList) {
            userMenu newUserMenu = new userMenu();
            newUserMenu.setUser(user);
            newUserMenu.setMenu(m);

            userMenuSet.add(newUserMenu);  // Add to the set
        }

        userRepository.save(user);  // Persist with cascade

        return ResponseEntity.ok("User menus added successfully");
    }


    @Override
    public ResponseEntity<?> updateUserMenu(Long user_id, List<Long>menuIds) {
        Optional<user> checkUser=userRepository.findById(user_id);
        if (checkUser.isEmpty()){
            return ResponseEntity.badRequest().body("user does not exist");
        }
        List<menu> checkMenu=menuRepository.findAllById(menuIds);
        if (checkMenu.size()!=menuIds.size()){
            return ResponseEntity.badRequest().body("some menu does not exist");
        }
        user user=checkUser.get();
        Set<userMenu> userMenuSet = user.getUserMenus();  // Get existing userMenu set

        for (menu m : checkMenu) {
            userMenu newUserMenu = new userMenu();
            newUserMenu.setUser(user);
            newUserMenu.setMenu(m);

            userMenuSet.add(newUserMenu);  // Add to the set
        }

        userRepository.save(user);  // Persist with cascade

        return ResponseEntity.ok("User menus updated successfully");

    }

    @Override
    public ResponseEntity<?> deleteUserMenu(Long id,List<Long>menuIds) {
        Optional<user>checkUser=userRepository.findById(id);
        if (checkUser.isEmpty()){
            return  ResponseEntity.badRequest().body("user does not exisit");
        }
        List<menu> checkMenuList=menuRepository.findAllById(menuIds);
        if (checkMenuList.size()!=menuIds.size()){
            return ResponseEntity.badRequest().body("Some menu does not exist");
        }
        user user=checkUser.get();
        Set<userMenu> updatedUserMenus = user.getUserMenus().stream()
                .filter(um -> !menuIds.contains(um.getMenu().getId()))
                .collect(Collectors.toSet());

        // Set the updated userMenus
        user.setUserMenus(updatedUserMenus);

        // Save the user
        userRepository.save(user);

        return ResponseEntity.ok("User menus deleted successfully");
    }


}
