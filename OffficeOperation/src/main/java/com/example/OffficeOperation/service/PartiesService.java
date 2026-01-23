package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.Parties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartiesService {
    ResponseEntity<List<Parties>> getAllPartiesById(Long id);
    ResponseEntity<List<Parties>>AddPartiesById();
    ResponseEntity<?>updateParties(Parties updatedParties,Long id);
    ResponseEntity<?>deletePartById(Long id);

}
