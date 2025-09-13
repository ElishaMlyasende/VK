package com.example.UserService.Implement;

import com.example.UserService.Model.Menu;
import com.example.UserService.Service.menuService;
import org.springframework.http.ResponseEntity;
import com.example.UserService.Repository.menuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class menuImplement implements menuService {

    private menuRepository menuRepository;
    public menuImplement(menuRepository menuRepository){
        this.menuRepository=menuRepository;
    }
    @Override
    public ResponseEntity<?> addMenu(Menu menu) {
        menuRepository.save(menu);
        return ResponseEntity.ok("Menu added successfully");
    }

    @Override
    public ResponseEntity<?> updateMenu(Long id, Menu menuUpdated) {
        Optional<Menu> checkMenu=menuRepository.findById(id);
        if (checkMenu.isEmpty()){
            return ResponseEntity.badRequest().body("Menu not found");
        }
        menuRepository.save(menuUpdated);
        return ResponseEntity.ok("menu added succesfully");
    }

    @Override
    public ResponseEntity<?> deleteMenu(Long id) {
        Optional<Menu> checkMenu=menuRepository.findById(id);
        if (checkMenu.isEmpty()){
            return ResponseEntity.badRequest().body("Menu not found");
        }
        menuRepository.deleteById(id);
        return ResponseEntity.ok("Menu deleted successfully");
    }

    @Override
    public List<Menu> listAllMEnu() {
         return menuRepository.findAll();
    }
}
