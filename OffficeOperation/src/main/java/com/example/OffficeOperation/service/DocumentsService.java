package com.example.OffficeOperation.service;

import com.example.OffficeOperation.dto.DocumentDTO;
import com.example.OffficeOperation.model.Documents;
import com.example.OffficeOperation.model.DocumentsRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentsService {
    ResponseEntity<?> register(Documents SavedFile);
    public Documents updateDocument(Long id, DocumentDTO dto);
    ResponseEntity<?>DeleteDocuments(Long id);
    List<DocumentDTO> getAllDocuments();
    ResponseEntity<?>addBulkFiles(List<Documents> documents);
}
