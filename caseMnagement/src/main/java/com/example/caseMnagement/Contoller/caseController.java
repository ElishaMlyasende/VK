package com.example.caseMnagement.Contoller;

import com.example.caseMnagement.model.caseModel;
import com.example.caseMnagement.service.caseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/case")
public class caseController {

    private final caseService caseService;
    private final ObjectMapper objectMapper;

    public caseController(caseService caseService, ObjectMapper objectMapper) {
        this.caseService = caseService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ResponseEntity<?> saveCase(
            @RequestPart("caseModel") String caseModelJson,
            @RequestPart(value = "document", required = false) MultipartFile document
    ) {
        try {
            caseModel savedCase = objectMapper.readValue(caseModelJson, caseModel.class);
            return caseService.addCase(savedCase, document);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid caseModel JSON");
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> editCase(
            @PathVariable("id") Long id,
            @RequestPart("caseModel") String caseModelJson,
            @RequestPart(value = "document", required = false) MultipartFile document
    ) {
        try {
            caseModel caseModelObj = objectMapper.readValue(caseModelJson, caseModel.class);
            return caseService.updateCase(caseModelObj, id, document);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid caseModel JSON");
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        return caseService.deleteCase(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return caseService.getCaseById(id);
    }

    @GetMapping("/all")
    public List<caseModel> getAllCases() {
        return caseService.getListOfAllCase();
    }
    @GetMapping("/document/{id}")
    public ResponseEntity<Resource> downloadCaseDocument(@PathVariable("id") Long id) {
        return caseService.downloadCaseFile(id);
    }

}
