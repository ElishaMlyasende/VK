package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.workFloor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface workFloorService {
    public ResponseEntity<?>addWorkFlow(workFloor workFloor);
    public ResponseEntity<?>editWorkFlow(workFloor workFloor,Long id);
    public ResponseEntity<?>deleteWorkFlow(Long id);
    List<workFloor> getAllClientWithworks();
    ResponseEntity<?>getClientById(Long id);
}
