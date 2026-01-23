package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.Documents;
import com.example.OffficeOperation.model.DocumentsRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentsService {
    ResponseEntity<?> register(Documents SavedFile);
    ResponseEntity<?>updateDocument(Documents Documents,Long id);
    ResponseEntity<?>DeleteDocuments(Long id);
    ResponseEntity<List<Documents>>GetAllDocuments();
    ResponseEntity<?>addBulkFiles(List<Documents> documents);
}
