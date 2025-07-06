package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.Reception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReceptionService {
    ResponseEntity<Reception> registerVisitor(Reception reception);
    ResponseEntity<List<Reception>> getAllVisitors();
    ResponseEntity<Reception> getVisitorById(Long id);
    ResponseEntity<Reception> markVisitorAsAttended(Long id);
    ResponseEntity<Reception> updateVisitor(Long id, Reception updatedReception);
    ResponseEntity<Void> deleteVisitor(Long id);
}
