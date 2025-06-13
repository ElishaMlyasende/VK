package com.example.cashBook.implement;

import com.example.cashBook.model.mobilePettyCash;
import com.example.cashBook.service.mobilePettyCashBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.cashBook.Repository.pettyCash;

import java.util.List;
import java.util.Optional;

@Service
public class mobileTransaction implements mobilePettyCashBook{
     private  final pettyCash pettyCash;
     public mobileTransaction(pettyCash pettyCash){
         this.pettyCash=pettyCash;
     }
    @Override
    public ResponseEntity<?> addMobilePettyCash(mobilePettyCash mobilePettyCash) {
        pettyCash.save(mobilePettyCash);
        return ResponseEntity.ok("Mobile Trasaction added successfully");

    }

    @Override
    public ResponseEntity<?> updateMobilePettyCash(mobilePettyCash mobilePettyCash, Long id) {
        Optional<mobilePettyCash>checkId=pettyCash.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction do not exist");
        }
        pettyCash.save(mobilePettyCash);
        return ResponseEntity.ok("Transaction edited succefully");
    }

    @Override
    public ResponseEntity<?> deleteMobilePettyCash(Long id) {
        Optional<mobilePettyCash>checkId=pettyCash.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction do not exist");
        }
        pettyCash.deleteById(id);
        return ResponseEntity.ok("Transaction deleted successfully");
    }

    @Override
    public List<mobilePettyCash> gettAllTransaction() {
        List<mobilePettyCash> mobilePettyCashes=pettyCash.findAll();
        return mobilePettyCashes;
    }

    @Override
    public ResponseEntity<?> getTrasactionById(Long id) {
        Optional<mobilePettyCash>checkId=pettyCash.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Transaction do not exist");
        }
        return ResponseEntity.ok(checkId);
    }
}
