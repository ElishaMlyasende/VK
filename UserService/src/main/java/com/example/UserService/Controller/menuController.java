package com.example.UserService.Controller;
import com.example.UserService.Model.menu;
import com.example.UserService.Service.menuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("menu")
public class menuController {
    private menuService menuService;
    public  menuController(menuService menuService){
        this.menuService=menuService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addMenu(menu menu ){
        return menuService.addMenu(menu);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?>updateMenu(@RequestBody  menu menuUpdated, @PathVariable("id") Long id){
       return menuService.updateMenu(id, menuUpdated);
    }
    @GetMapping("/all")
    public List<menu> getAllMenu(){
        return menuService.listAllMEnu();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") long id){
        return menuService.deleteMenu(id);
    }

}
