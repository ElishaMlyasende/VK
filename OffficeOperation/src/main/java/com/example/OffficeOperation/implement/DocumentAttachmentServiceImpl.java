package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.model.DocumentAttachment;
import com.example.OffficeOperation.Repository.DocumentAttachmentRepository;
import com.example.OffficeOperation.service.DocumentAttachmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentAttachmentServiceImpl implements DocumentAttachmentService {

    private final DocumentAttachmentRepository repository;

    public DocumentAttachmentServiceImpl(DocumentAttachmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentAttachment save(DocumentAttachment attachment) {
        return repository.save(attachment);
    }

    @Override
    public DocumentAttachment update(Long id, DocumentAttachment attachment) {
        DocumentAttachment existing = findById(id);

        existing.setNameOfTheDocument(attachment.getNameOfTheDocument());
        existing.setReceveidBy(attachment.getReceveidBy());
        existing.setReleasedBy(attachment.getReleasedBy());
        existing.setCollectedBy(attachment.getCollectedBy());
        existing.setLocation(attachment.getLocation());
        existing.setShelf(attachment.getShelf());
        existing.setNo(attachment.getNo());
        existing.setFileType(attachment.getFileType());
        existing.setFileData(attachment.getFileData());
        existing.setDocument(attachment.getDocument());

        return repository.save(existing);
    }

    @Override
    public DocumentAttachment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentAttachment not found with id " + id));
    }

    @Override
    public List<DocumentAttachment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DocumentAttachment> findByDocumentId(Long documentId) {
        return repository.findByDocument_Id(documentId);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
