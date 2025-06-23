package com.example.cashBook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cashBook.service.pettyCashService;
import com.example.cashBook.model.pettyCash;

import java.util.List;

@RestController
@RequestMapping("/cashbook")
public class pettyCashController {
    private final pettyCashService pettyCashService;
    public pettyCashController(pettyCashService pettyCashService){
        this.pettyCashService=pettyCashService;
    }
    @PostMapping("/add")
    public ResponseEntity<?>addPettyCash(@RequestBody pettyCash savedPettyCash){
        return pettyCashService.savePettyCash(savedPettyCash);
    }
    @GetMapping("/all")
    List<pettyCash>listAllpettyCash(){
        return pettyCashService.getAllPettyCash();
    }
    @PutMapping("/edit")
    public  ResponseEntity<?> updatePettyCash(@RequestParam Long id, @RequestBody pettyCash updated){
        return pettyCashService.updatePettyCash(updated, id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePettyCash(@RequestParam Long id){
        return  pettyCashService.deletePettyCash(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPettyCashById(@PathVariable("id") Long id){
        return pettyCashService.getPettyCashById(id);
    }

}
