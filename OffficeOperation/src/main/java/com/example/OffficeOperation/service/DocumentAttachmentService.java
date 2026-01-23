package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.DocumentAttachment;

import java.util.List;

public interface DocumentAttachmentService {

    DocumentAttachment save(DocumentAttachment attachment);

    DocumentAttachment update(Long id, DocumentAttachment attachment);

    DocumentAttachment findById(Long id);

    List<DocumentAttachment> findAll();

    List<DocumentAttachment> findByDocumentId(Long documentId);

    void delete(Long id);
}
