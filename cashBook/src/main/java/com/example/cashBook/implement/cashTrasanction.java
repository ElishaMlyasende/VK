package com.example.cashBook.implement;

import com.example.cashBook.model.pettyCash;
import com.example.cashBook.service.pettyCashService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.cashBook.Repository.cashBookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class cashTrasanction implements pettyCashService {
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
        Optional<pettyCash> checkId=cashBookRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction not found");
        }
        cashBookRepository.save(pettyCash);
        return ResponseEntity.ok("Transaction updated successfully");
    }

    @Override
    public ResponseEntity<?> deletePettyCash(Long id) {Optional<pettyCash> checkId=cashBookRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction not found");
        }
        cashBookRepository.deleteById(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }

    @Override
    public ResponseEntity<?> getPettyCashById(Long id) {
        Optional<pettyCash> checkId=cashBookRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction not found");
        }
       return ResponseEntity.ok(checkId);
    }

    @Override
    public List<pettyCash> getAllPettyCash() {
       List<pettyCash> allPettyCash=cashBookRepository.findAll();
       return allPettyCash;
    }
}
