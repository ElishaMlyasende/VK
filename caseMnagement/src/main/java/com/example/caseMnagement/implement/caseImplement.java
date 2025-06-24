package com.example.caseMnagement.implement;

import com.example.caseMnagement.model.caseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.caseMnagement.service.caseService;
import com.example.caseMnagement.Respository.caseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class caseImplement implements  caseService{
    private final caseRepository caseRepository;
    // constructor
    public caseImplement(caseRepository caseRepository){
        this.caseRepository=caseRepository;
    }
    @Override
    public ResponseEntity<?> addCase(caseModel caseModel) {
        caseRepository.save(caseModel);
        return  ResponseEntity.ok("Record added successfully");
    }

    @Override
    public ResponseEntity<?> updateCase(caseModel caseModel, Long id) {
        Optional<caseModel> checkId=caseRepository.findById(id);
        if (checkId.isEmpty()){
            return  ResponseEntity.badRequest().body("case not found");
        }
        caseRepository.save(caseModel);
        return ResponseEntity.ok("record updated successfully");
    }

    @Override
    public ResponseEntity<?> deleteCase(Long id) {
        Optional<caseModel> checkId=caseRepository.findById(id);
        if (checkId.isEmpty()){
            return  ResponseEntity.badRequest().body("case not found");
        }
        caseRepository.deleteById(id);
        return ResponseEntity.ok("Record remove successfully");
    }

    @Override
    public ResponseEntity<?> getCaseById(Long id) {
        Optional<caseModel> checkId=caseRepository.findById(id);
        if (checkId.isEmpty()){
            return  ResponseEntity.badRequest().body("case not found");
        }
        return ResponseEntity.ok(checkId);
    }

    @Override
    public List<caseModel> getListOfAllCase() {
        List<caseModel> allCase=caseRepository.findAll();
        return  allCase;
    }
}
