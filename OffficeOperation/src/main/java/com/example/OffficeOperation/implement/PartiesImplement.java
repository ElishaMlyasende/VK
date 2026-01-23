package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.FilesMetadataRepository;
import com.example.OffficeOperation.Repository.PartiesRepository;
import com.example.OffficeOperation.model.FIlesMetadata;
import com.example.OffficeOperation.model.Parties;
import com.example.OffficeOperation.service.PartiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartiesImplement implements PartiesService {
    private final PartiesRepository partiesRepository;
    private final FilesMetadataRepository filesMetadataRepository;
    public PartiesImplement(PartiesRepository partiesRepository,FilesMetadataRepository filesMetadataRepository){
        this.partiesRepository=partiesRepository;
        this.filesMetadataRepository=filesMetadataRepository;
    }
    @Override
    public ResponseEntity<List<Parties>> getAllPartiesById(Long id) {
      return  null;
    }

    @Override
    public ResponseEntity<List<Parties>> AddPartiesById() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateParties(Parties updatedParties, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deletePartById(Long id) {
        return null;
    }
}
