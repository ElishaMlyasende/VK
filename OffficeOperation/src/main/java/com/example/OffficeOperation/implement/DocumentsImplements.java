package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.DocumentsRepository;
import com.example.OffficeOperation.model.Documents;
import com.example.OffficeOperation.service.DocumentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentsImplements implements DocumentsService {
    private final DocumentsRepository documentsRepository;
    public  DocumentsImplements(DocumentsRepository documentsRepository){
        this.documentsRepository=documentsRepository;
    }

    @Override
    public ResponseEntity<?> register(Documents SavedFile) {
        documentsRepository.save(SavedFile);
        return ResponseEntity.ok().body("document added successfully");
    }

    @Override
    public ResponseEntity<?> updateDocument(Documents Documents, Long id) {
        Optional<Documents> ID=documentsRepository.findById(id);
        if (ID.isEmpty()){
            return ResponseEntity.badRequest().body("Document not found");
        }
        else {
            Documents existing= ID.get();
            existing.setNameOfTheParties(Documents.getNameOfTheParties());
            existing.setReceivedDate(Documents.getReceivedDate());

            documentsRepository.save(existing);
            return ResponseEntity.ok().body("Documents record updated successfully");
        }
    }

    @Override
    public ResponseEntity<?> DeleteDocuments(Long id) {
        Optional<Documents> ID=documentsRepository.findById(id);
        if (ID.isEmpty()){
            return ResponseEntity.badRequest().body("Document not found");
        }
        else{
            documentsRepository.deleteById(id);
            return ResponseEntity.ok().body("Document record deleted successfully");
        }
    }

    @Override
    public ResponseEntity<List<Documents>> GetAllDocuments() {
        List<Documents>AllDocuments=documentsRepository.findAll();
        return ResponseEntity.ok().body(AllDocuments);
    }

    @Override
    public ResponseEntity<?> addBulkFiles(List<Documents> documents) {
      documentsRepository.saveAll(documents);
      return ResponseEntity.ok().body("Excel imported successfully");
    }
}
