package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.Reception;
import com.example.OffficeOperation.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reception")
public class ReceptionController {

    @Autowired
    private ReceptionService receptionService;

    // Register a new visitor
    @PostMapping("/register")
    public ResponseEntity<Reception> registerVisitor(@RequestBody Reception reception) {
        return receptionService.registerVisitor(reception);
    }

    // Get all visitors
    @GetMapping("/all")
    public ResponseEntity<List<Reception>> getAllVisitors() {
        return receptionService.getAllVisitors();
    }

    // Get a single visitor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reception> getVisitor(@PathVariable Long id) {
        return receptionService.getVisitorById(id);
    }

    // Mark a visitor as attended
    @PutMapping("/attend/{id}")
    public ResponseEntity<Reception> markVisitorAttended(@PathVariable Long id) {
        return receptionService.markVisitorAsAttended(id);
    }

    // Update visitor information
    @PutMapping("/update/{id}")
    public ResponseEntity<Reception> updateVisitor(@PathVariable Long id, @RequestBody Reception updatedReception) {
        return receptionService.updateVisitor(id, updatedReception);
    }

    // Delete a visitor record
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id) {
        return receptionService.deleteVisitor(id);
    }
}
