package com.example.UserService.Service;

import com.example.UserService.Model.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface menuService {
    public ResponseEntity<?> addMenu(Menu menu );
    public ResponseEntity<?> updateMenu(Long id, Menu menuUpdated);
    public  ResponseEntity<?> deleteMenu(Long id);
    public List<Menu> listAllMEnu();
}
