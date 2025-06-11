package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.model.workFloor;
import com.example.OffficeOperation.service.workFloorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.OffficeOperation.Repository.workFlowRepository

import java.util.List;
import java.util.Optional;

@Service
public class workFlowImplement implements workFloorService {
    private final  workFlowRepository workFlowRepository;
    // constructor
    public  workFlowImplement(workFlowRepository workFlowRepository){
        this.workFlowRepository=workFlowRepository;
    }

    @Override
    public ResponseEntity<?> addWorkFlow(workFloor workFloor) {
      workFlowRepository.save(workFloor);
      return ResponseEntity.ok("Client added successfully");
    }

    @Override
    public ResponseEntity<?> editWorkFlow(workFloor workFloor, Long id) {
     //check if user exist in the database
        Optional<workFloor>checkId=workFlowRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Sorry Client Does not exist");
        }
        workFlowRepository.save(workFloor);
        return ResponseEntity.ok("Client Data Updated Successfully");
    }

    @Override
    public ResponseEntity<?> deleteWorkFlow(workFloor workFloor, Long id) {
        Optional<workFloor>checkId=workFlowRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Sorry Client Does not exist");
        }
        workFlowRepository.deleteById(id);
        return ResponseEntity.ok("Client deleted successfully");

    }

    @Override
    public List<workFloor> getAllClientWithworks() {
        return List.of();
    }

    @Override
    public ResponseEntity<?> getClientById(Long id) {
        return null;
    }
}
