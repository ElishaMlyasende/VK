package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.DocumentsRegistry;
import com.example.OffficeOperation.service.DocumentsRegistryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents-registry")
public class DocumentsRegistryController {

    private final DocumentsRegistryService documentsRegistryService;

    public DocumentsRegistryController(DocumentsRegistryService documentsRegistryService) {
        this.documentsRegistryService = documentsRegistryService;
    }

    // ✅ ADD SINGLE FILE (WITH BASE64 ATTACHMENT)
    @PostMapping("/add")
    public ResponseEntity<?> addDocument(@RequestBody DocumentsRegistry document) {

        // document tayari ina:
        // - attachment (Base64 string)
        // - attachmentName (original filename)

        return documentsRegistryService.registerDocuments(document);
    }

    // ✅ UPDATE FILE (WITH OR WITHOUT ATTACHMENT)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDocument(
            @RequestBody DocumentsRegistry document,
            @PathVariable Long id
    ) {
        return documentsRegistryService.updateDocumentRegistry(document, id);
    }

    // ✅ DELETE FILE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable Long id) {
        return documentsRegistryService.DeleteDocumentsRegistry(id);
    }

    // ✅ GET ALL FILES (INCLUDES BASE64 ATTACHMENT)
    @GetMapping("/all")
    public ResponseEntity<List<DocumentsRegistry>> getAllDocuments() {
        return documentsRegistryService.GetAllRegistry();
    }

    // ✅ BULK SAVE (NO ATTACHMENT – EXCEL)
    @PostMapping("/bulk")
    public ResponseEntity<?> addBulkDocuments(
            @RequestBody List<DocumentsRegistry> registryDocuments
    ) {
        return documentsRegistryService.addBulkFiles(registryDocuments);
    }
}
