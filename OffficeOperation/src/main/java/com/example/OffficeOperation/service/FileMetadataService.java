package com.example.OffficeOperation.service;

import com.example.OffficeOperation.dto.FilesMetadataDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface FileMetadataService {
    ResponseEntity<?> AddFileDetails(FilesMetadataDTO request) throws IOException;
    ResponseEntity<?> updateFileMetadataDetails(FilesMetadataDTO request, Long id);
    ResponseEntity<?>deleteFileMetadataDetails(Long id);
    ResponseEntity<List<FilesMetadataDTO>>getAllFilesBYyId(Long doc_id);
    ResponseEntity<?>DownloadDocumentById(Long id);
}
