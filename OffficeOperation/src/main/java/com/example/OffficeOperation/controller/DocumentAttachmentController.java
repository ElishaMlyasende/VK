package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.DocumentAttachment;
import com.example.OffficeOperation.service.DocumentAttachmentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/document-attachments")
public class DocumentAttachmentController {

    private final DocumentAttachmentService service;

    public DocumentAttachmentController(DocumentAttachmentService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public DocumentAttachment save(@RequestBody DocumentAttachment attachment) {
        // decode Base64 if exists in fileData
        if (attachment.getFileData() != null && attachment.getFileData().length > 0) {
            // tayari ni byte[] basi huna haja ya decode tena
        }


        // check document exists
        if (attachment.getDocument() == null || attachment.getDocument().getId() == null) {
            throw new RuntimeException("Attachment must have a valid document reference");
        }

        return service.save(attachment);
    }

    // UPDATE
    @PutMapping("/{id}")
    public DocumentAttachment update(@PathVariable Long id, @RequestBody DocumentAttachment attachment) {
        if (attachment.getFileBase64() != null && !attachment.getFileBase64().isEmpty()) {
            attachment.setFileData(Base64.getDecoder().decode(attachment.getFileBase64()));
        }
        return service.update(id, attachment);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public DocumentAttachment getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // GET ALL
    @GetMapping
    public List<DocumentAttachment> getAll() {
        return service.findAll();
    }

    // GET BY DOCUMENT ID
    @GetMapping("/document/{documentId}")
    public ResponseEntity<List<DocumentAttachment>> getByDocumentId(@PathVariable Long documentId) {
        try {
            List<DocumentAttachment> attachments = service.findByDocumentId(documentId);
            return ResponseEntity.ok(attachments);
        } catch (Exception e) {
            e.printStackTrace(); // log error
            return ResponseEntity.status(500).body(List.of());
        }
    }

    // DOWNLOAD FILE
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        DocumentAttachment attachment = service.findById(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getNameOfTheDocument() + "\"")
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .body(attachment.getFileData());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
