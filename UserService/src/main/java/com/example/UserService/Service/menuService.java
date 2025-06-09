package com.example.UserService.Service;

import com.example.UserService.Model.menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface menuService {
    public ResponseEntity<?> addMenu(menu menu );
    public ResponseEntity<?> updateMenu(Long id, menu menuUpdated);
    public  ResponseEntity<?> deleteMenu(Long id);
    public List<menu> listAllMEnu();
}
