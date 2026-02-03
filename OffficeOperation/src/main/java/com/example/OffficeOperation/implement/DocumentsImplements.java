package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.DocumentsRepository;
import com.example.OffficeOperation.dto.DocumentDTO;
import com.example.OffficeOperation.dto.PartyDTO;
import com.example.OffficeOperation.model.Documents;
import com.example.OffficeOperation.model.Parties;
import com.example.OffficeOperation.service.DocumentsService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentsImplements implements DocumentsService {
    private final DocumentsRepository documentsRepository;
    public  DocumentsImplements(DocumentsRepository documentsRepository){
        this.documentsRepository=documentsRepository;
    }

    @Override
    public ResponseEntity<?> register(Documents document) {
        // Link parties to document
        if (document.getParties() != null) {
            document.getParties().forEach(p -> p.setDocuments(document));}
        documentsRepository.save(document);
        return ResponseEntity.ok().body("Document with parties added successfully");
    }


    @Override
    @Transactional
    public Documents updateDocument(Long id, DocumentDTO dto) {

        Documents document = documentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        document.setReceivedDate(dto.getReceivedDate());

        // 🔥 USIREPLACE LIST
        document.getParties().clear();

        for (PartyDTO p : dto.getParties()) {
            Parties party = new Parties();
            party.setNameOfTheParties(p.getNameOfTheParties());
            party.setPosition(p.getPosition());
            party.setDocuments(document); // muhimu sana
            document.getParties().add(party);
        }

        return documentsRepository.save(document);
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
    public List<DocumentDTO> getAllDocuments() {
        List<Documents> allDocuments = documentsRepository.findAll();

        // convert entities to DTOs
        return allDocuments.stream()
                .map(this::convertToDto)
                .toList();
    }
    public DocumentDTO convertToDto(Documents document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(document.getId());
        dto.setReceivedDate(document.getReceivedDate());

        List<PartyDTO> partyDTOs = document.getParties().stream().map(p -> {
            PartyDTO pdto = new PartyDTO();
            pdto.setId(p.getId());
            pdto.setNameOfTheParties(p.getNameOfTheParties());
            pdto.setPosition(p.getPosition());
            return pdto;
        }).collect(Collectors.toList());
        dto.setParties(partyDTOs);
        return dto;
    }

    @Override
    public ResponseEntity<?> addBulkFiles(List<Documents> documents) {
      documentsRepository.saveAll(documents);
      return ResponseEntity.ok().body("Excel imported successfully");
    }
}
