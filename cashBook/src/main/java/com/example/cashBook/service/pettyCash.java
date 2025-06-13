package com.example.cashBook.service;

import com.example.cashBook.model.pettyCash;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface cashTransaction {
    ResponseEntity<?>savePettyCash(pettyCash pettyCash);
    ResponseEntity<?>updatePettyCash(pettyCash pettyCash, Long id);
    ResponseEntity<?>deletePettyCash(Long id);
    ResponseEntity<?>getPettyCashById(Long id);
    List<pettyCash>getAllPettyCash();
}
