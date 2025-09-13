package com.example.UserService.Controller;
import com.example.UserService.Model.Menu;
import com.example.UserService.Service.menuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class menuController {
    private menuService menuService;
    public  menuController(menuService menuService){
        this.menuService=menuService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addMenu(Menu menu ){
        return menuService.addMenu(menu);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?>updateMenu(@RequestBody Menu menuUpdated, @PathVariable("id") Long id){
       return menuService.updateMenu(id, menuUpdated);
    }
    @GetMapping("/all")
    public List<Menu> getAllMenu(){
        return menuService.listAllMEnu();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") long id){
        return menuService.deleteMenu(id);
    }

}
