package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.model.Reception;
import com.example.OffficeOperation.Repository.ReceptionRepository;
import com.example.OffficeOperation.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    private ReceptionRepository receptionRepository;

    @Override
    public ResponseEntity<Reception> registerVisitor(Reception reception) {
        reception.setTimeIn(LocalDateTime.now());
        reception.setAttended(false);
        Reception saved = receptionRepository.save(reception);
        return ResponseEntity.status(201).body(saved); // 201 CREATED
    }

    @Override
    public ResponseEntity<List<Reception>> getAllVisitors() {
        List<Reception> visitors = receptionRepository.findAll();
        return ResponseEntity.ok(visitors); // 200 OK
    }

    @Override
    public ResponseEntity<Reception> getVisitorById(Long id) {
        Optional<Reception> visitor = receptionRepository.findById(id);
        return visitor.map(ResponseEntity::ok) // 200 OK if found
                .orElse(ResponseEntity.notFound().build()); // 404 NOT FOUND
    }

    @Override
    public ResponseEntity<Reception> markVisitorAsAttended(Long id) {
        Optional<Reception> optionalReception = receptionRepository.findById(id);
        if (optionalReception.isPresent()) {
            Reception reception = optionalReception.get();
            reception.setAttended(true);
            reception.setTimeOut(LocalDateTime.now());
            Reception updated = receptionRepository.save(reception);
            return ResponseEntity.ok(updated); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 NOT FOUND
        }
    }
    @Override
    public ResponseEntity<Reception> updateVisitor(Long id, Reception updatedReception) {
        Optional<Reception> optionalReception = receptionRepository.findById(id);
        if (optionalReception.isPresent()) {
            Reception existing = optionalReception.get();
            existing.setVisitorName(updatedReception.getVisitorName());
            existing.setPurpose(updatedReception.getPurpose());
            existing.setPhoneNumber(updatedReception.getPhoneNumber());
            existing.setDepartmentToVisit(updatedReception.getDepartmentToVisit());
            existing.setAttended(updatedReception.getAttended());
            existing.setTimeIn(updatedReception.getTimeIn());
            existing.setTimeOut(updatedReception.getTimeOut());
            Reception saved = receptionRepository.save(existing);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteVisitor(Long id) {
        Optional<Reception> optionalReception = receptionRepository.findById(id);
        if (optionalReception.isPresent()) {
            receptionRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 NO CONTENT
        } else {
            return ResponseEntity.notFound().build(); // 404 NOT FOUND
        }
    }

}
