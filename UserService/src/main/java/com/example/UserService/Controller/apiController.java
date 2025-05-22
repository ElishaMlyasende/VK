package com.example.UserService.Controller;

import com.example.UserService.Model.api_permission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserService.Service.apiService;

import java.util.List;

@RestController
@RequestMapping("api/v1/api")
public class apiController {
    private final apiService apiService;
    public apiController(apiService apiService){
        this.apiService=apiService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addApi(@RequestBody api_permission savedApi){
        return apiService.addApi(savedApi);
    }
    @GetMapping("/apis")
    public List<api_permission> getAllApi(){
        return apiService.getAllApi();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllApi(@PathVariable("id") Long id){
        return apiService.getApiById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteApi(@PathVariable("id")Long id){
        return apiService.deleteApi(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateApi(@PathVariable("id")Long id, @RequestBody api_permission updatedApi){
        return apiService.updateApi(updatedApi, id);
    }

}
