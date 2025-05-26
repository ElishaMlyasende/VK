package com.example.UserService.Implement;

import com.example.UserService.Model.menu;
import com.example.UserService.Service.menuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.UserService.Repository.menuRepository;

import java.util.List;
import java.util.Optional;

public class menuImplement implements menuService {

    private menuRepository menuRepository;
    public menuImplement(menuRepository menuRepository){
        this.menuRepository=menuRepository;
    }
    @Override
    public ResponseEntity<?> addMenu(menu menu) {
        menuRepository.save(menu);
        return ResponseEntity.ok("Menu added successfully");
    }

    @Override
    public ResponseEntity<?> updateMenu(Long id, menu menuUpdated) {
        Optional<menu> checkMenu=menuRepository.findById(id);
        if (checkMenu.isEmpty()){
            return ResponseEntity.badRequest().body("Menu not found");
        }
        menuRepository.save(menuUpdated);
        return ResponseEntity.ok("menu added succesfully");
    }

    @Override
    public ResponseEntity<?> deleteMenu(Long id) {
        Optional<menu> checkMenu=menuRepository.findById(id);
        if (checkMenu.isEmpty()){
            return ResponseEntity.badRequest().body("Menu not found");
        }
        menuRepository.deleteById(id);
        return ResponseEntity.ok("Menu deleted successfully");
    }

    @Override
    public List<menu> listAllMEnu() {
         return menuRepository.findAll();
    }
}
