package com.example.cashBook.service;

import com.example.cashBook.model.mobilePettyCash;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface mobilePettyCashBook {
    ResponseEntity<?> addMobilePettyCash(mobilePettyCash mobilePettyCash);

    ResponseEntity<?> updateMobilePettyCash(mobilePettyCash mobilePettyCash, Long id);

    ResponseEntity<?> deleteMobilePettyCash(Long id);

    List<mobilePettyCash> gettAllTransaction();

    ResponseEntity<?> getTrasactionById(Long id);
}