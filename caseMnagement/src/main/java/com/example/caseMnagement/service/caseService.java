package com.example.caseMnagement.service;

import org.springframework.http.ResponseEntity;
import  com.example.caseMnagement.model.caseModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface caseService {
    ResponseEntity<?> addCase(caseModel caseModel);
    ResponseEntity<?>updateCase(caseModel caseModel, Long id);
    ResponseEntity<?> deleteCase(Long id);
    ResponseEntity<?> getCaseById(Long id);
    List<caseModel> getListOfAllCase();
}
