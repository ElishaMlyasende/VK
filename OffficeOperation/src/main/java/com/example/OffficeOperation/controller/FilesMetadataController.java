package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.dto.FilesMetadataDTO;
import com.example.OffficeOperation.service.FileMetadataService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FilesMetadataController {

    private final FileMetadataService fileMetadataService;

    public FilesMetadataController(FileMetadataService fileMetadataService) {
        this.fileMetadataService = fileMetadataService;
    }

    // Add a new file
    @PostMapping("/add")
    public ResponseEntity<?> addFile(
            @RequestParam("doc_id") int doc_id,
            @RequestParam("nameOfTheDocument") String nameOfTheDocument,
            @RequestParam(value = "collectedBy", required = false) String collectedBy,
            @RequestParam(value = "receveidBy", required = false) String receveidBy,
            @RequestParam(value = "releasedBy", required = false) String releasedBy,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "shelf", required = false) String shelf,
            @RequestParam(value = "no", required = false) String no,
            @RequestParam(value = "receivedAttDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate receivedAttDate,
            @RequestParam(value = "releasedAttDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releasedAttDate,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        FilesMetadataDTO dto = new FilesMetadataDTO();
        dto.setDoc_id((long) doc_id);
        dto.setNameOfTheDocument(nameOfTheDocument);
        dto.setCollectedBy(collectedBy);
        dto.setReceveidBy(receveidBy);
        dto.setReleasedBy(releasedBy);
        dto.setLocation(location);
        dto.setShelf(shelf);
        dto.setNo(no);
        dto.setReceivedAttDate(receivedAttDate);
        dto.setReleasedAttDate(releasedAttDate);
        dto.setFile(file);

        return fileMetadataService.AddFileDetails(dto);
    }

    // Update a file metadata
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFile(
            @PathVariable("id") Long id,
            @RequestParam("doc_id") int doc_id,
            @RequestParam("nameOfTheDocument") String nameOfTheDocument,
            @RequestParam("collectedBy") String collectedBy,
            @RequestParam("receveidBy") String receveidBy,
            @RequestParam(value = "releasedBy", required = false) String releasedBy,
            @RequestParam("location") String location,
            @RequestParam("shelf") String shelf,
            @RequestParam("no") String no,
            @RequestParam("receivedAttDate") LocalDate receivedAttDate,
            @RequestParam("releasedAttDate") LocalDate releasedAttDate,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) {

        FilesMetadataDTO dto = new FilesMetadataDTO();
        dto.setDoc_id((long) doc_id);
        dto.setNameOfTheDocument(nameOfTheDocument);
        dto.setCollectedBy(collectedBy);
        dto.setReceveidBy(receveidBy);
        dto.setReleasedBy(releasedBy);
        dto.setLocation(location);
        dto.setShelf(shelf);
        dto.setNo(no);
        dto.setReleasedAttDate(releasedAttDate);
        dto.setReceivedAttDate(receivedAttDate);
        dto.setFile(file);

        return fileMetadataService.updateFileMetadataDetails(dto, id);
    }

    // Delete a file by doc_id
    @DeleteMapping("/delete/{doc_id}")
    public ResponseEntity<?> deleteFile(@PathVariable("doc_id") Long doc_id) {
        return fileMetadataService.deleteFileMetadataDetails(doc_id);
    }

    // Get all files by doc_id
    @GetMapping("/list/{doc_id}")
    public ResponseEntity<List<FilesMetadataDTO>> getFiles(@PathVariable("doc_id") Long doc_id) {
        return fileMetadataService.getAllFilesBYyId(doc_id);
    }

    // Download file by id
    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable("id") Long id) {
        return fileMetadataService.DownloadDocumentById(id);
    }
}
