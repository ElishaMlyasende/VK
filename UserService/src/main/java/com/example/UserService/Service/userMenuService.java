package com.example.UserService.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userMenuService {
    ResponseEntity<?> addUserMenu(Long id, List<Long> menuIds);
    ResponseEntity<?> updateUserMenu(Long user_id, List<Long> menuIds);
    ResponseEntity<?> deleteUserMenu(Long id,List<Long>menuIds);
}
