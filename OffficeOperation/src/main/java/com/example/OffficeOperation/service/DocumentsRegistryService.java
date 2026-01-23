package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.DocumentsRegistry;
import org.springframework.http.ResponseEntity;

import java.rmi.registry.Registry;
import java.util.List;

public interface DocumentsRegistryService {
    ResponseEntity<?> registerDocuments(DocumentsRegistry SavedFile);
    ResponseEntity<?>updateDocumentRegistry(DocumentsRegistry DocumentsRegistry,Long id);
    ResponseEntity<?>DeleteDocumentsRegistry(Long id);
    ResponseEntity<List<DocumentsRegistry>>GetAllRegistry();
    ResponseEntity<?>addBulkFiles(List<DocumentsRegistry> registryDocuments);
}
