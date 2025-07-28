package com.example.caseMnagement.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import  com.example.caseMnagement.model.caseModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public interface caseService {
    ResponseEntity<?> addCase(caseModel caseModel, MultipartFile document);
    ResponseEntity<?> updateCase(caseModel caseModel, Long id, MultipartFile document);
    ResponseEntity<?> deleteCase(Long id);
    ResponseEntity<?> getCaseById(Long id);
    List<caseModel> getListOfAllCase();
    ResponseEntity<Resource> downloadCaseFile(Long id);
}
