package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.DocumentsRegistryRepository;
import com.example.OffficeOperation.model.DocumentsRegistry;
import com.example.OffficeOperation.service.DocumentsRegistryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.registry.Registry;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentsRegistryImplments implements DocumentsRegistryService {
    //creating default constructor
    private  final DocumentsRegistryRepository documentsRegistryRepository;
    public  DocumentsRegistryImplments(DocumentsRegistryRepository documentsRegistryRepository){
        this.documentsRegistryRepository=documentsRegistryRepository;
    }
    @Override
    public ResponseEntity<?> registerDocuments(DocumentsRegistry SavedFile) {
        documentsRegistryRepository.save(SavedFile);
        return ResponseEntity.ok().body("File Details Added Successfully");
    }

    @Override
    public ResponseEntity<?> updateDocumentRegistry(DocumentsRegistry DocumentsRegistry, Long id) {
        Optional<DocumentsRegistry> ID=documentsRegistryRepository.findById(id);
        if (ID.isEmpty()){
            return ResponseEntity.badRequest().body("File Not Found So cant be deleted");
        }
        else {
            DocumentsRegistry Existing=ID.get();
            Existing.setLocationOrLocker(DocumentsRegistry.getLocationOrLocker());
            Existing.setCourtOrTribunalOrCma(DocumentsRegistry.getCourtOrTribunalOrCma());
            Existing.setShelf(DocumentsRegistry.getShelf());
            Existing.setNo(DocumentsRegistry.getNo());
            Existing.setNameOfTheParties(DocumentsRegistry.getNameOfTheParties());
            documentsRegistryRepository.save(Existing);
            return ResponseEntity.ok().body("File Record Updated Successfully");
        }
    }
    @Override
    public ResponseEntity<?> DeleteDocumentsRegistry(Long id) {
        Optional<DocumentsRegistry> ID=documentsRegistryRepository.findById(id);
        if (ID.isEmpty()){
            return ResponseEntity.badRequest().body("File Not Found So cant be deleted");
        }
        else{
            documentsRegistryRepository.deleteById(id);
            return ResponseEntity.ok().body("File Record Has Been Removed Successfully");
        }
    }

    @Override
    public ResponseEntity<List<DocumentsRegistry>> GetAllRegistry() {
        List<DocumentsRegistry> AllFiles=documentsRegistryRepository.findAll();
        return ResponseEntity.ok().body(AllFiles);
    }

    @Override
    public ResponseEntity<?> addBulkFiles(List<DocumentsRegistry> registryDocuments) {
        documentsRegistryRepository.saveAll(registryDocuments);
        return ResponseEntity.ok().body("ALL RECORD IMPORTED SUCCESSFULLY");
    }
}
