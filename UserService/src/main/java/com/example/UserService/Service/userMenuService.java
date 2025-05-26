package com.example.UserService.Service;

import com.example.UserService.Model.menu;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface userMenuService {
    ResponseEntity<?>addUserMenu(Long id, List<Long> menuIds);
    ResponseEntity<?> updateUserMenu(menu updatedUserMenu, Long id);
    ResponseEntity<?> deleteUserMenu(Long id);
    List<menu> getAllUserMenu();
}
