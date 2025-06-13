package com.example.cashBook.implement;

import com.example.cashBook.model.pettyCash;
import com.example.cashBook.service.cashTransaction
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.cashBook.Repository.cashBookRepository

import java.util.List;

@Service
public class cashTrasanction implements pettyCash {
    private  final cashBookRepository cashBookRepository;
    public cashTrasanction(cashBookRepository cashBookRepository){
        this.cashBookRepository=cashBookRepository;
    }
    @Override
    public ResponseEntity<?> savePettyCash(pettyCash pettyCash) {
        cashBookRepository.save(pettyCash);
        return ResponseEntity.ok("Transaction added successfully");
    }

    @Override
    public ResponseEntity<?> updatePettyCash(pettyCash pettyCash, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePettyCash(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getPettyCashById(Long id) {
        return null;
    }

    @Override
    public List<pettyCash> getAllPettyCash() {
        return List.of();
    }
}
