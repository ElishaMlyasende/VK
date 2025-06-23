package com.example.cashBook.controller;

import com.example.cashBook.implement.mobileTransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cashBook.service.mobilePettyCashBook;
import com.example.cashBook.model.mobilePettyCash;

import java.util.List;

@RestController
@RequestMapping("cashbook/mobile")
public class mobilePettyCashController {
    private final mobilePettyCashBook mobilePettyCashBook;
    public mobilePettyCashController(mobilePettyCashBook mobilePettyCashBook){
        this.mobilePettyCashBook=mobilePettyCashBook;
    }
    @PostMapping("/add")
    public ResponseEntity<?> postAllMobileTranasaction(mobilePettyCash saved){
        return  mobilePettyCashBook.addMobilePettyCash(saved);
    }
    @PutMapping("/edit")
    public ResponseEntity<?>editMobilePettyCash(@RequestParam Long id,mobilePettyCash updated){
        return mobilePettyCashBook.updateMobilePettyCash(updated, id);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteMobilePettyCash(@PathVariable("id")Long id){
        return mobilePettyCashBook.deleteMobilePettyCash(id);
    }
    @GetMapping("/all")
    public List<mobilePettyCash>getAllMobilePettyCash(){
        return mobilePettyCashBook.gettAllTransaction();
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getMobileTransactionById(@PathVariable("id")Long id){
        return mobilePettyCashBook.getTrasactionById(id);
    }
}
