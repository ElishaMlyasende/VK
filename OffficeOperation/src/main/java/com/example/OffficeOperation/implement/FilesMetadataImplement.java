package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.FilesMetadataRepository;
import com.example.OffficeOperation.dto.FilesMetadataDTO;
import com.example.OffficeOperation.model.FIlesMetadata;
import com.example.OffficeOperation.service.FileMetadataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FilesMetadataImplement implements FileMetadataService {

    @Value("${file.upload-dir}")
    private String uploadDir; // <-- Spring will inject the folder path

    private Path uploadPath;

    private final FilesMetadataRepository filesMetadataRepository;

    public FilesMetadataImplement(FilesMetadataRepository filesMetadataRepository) {
        this.filesMetadataRepository = filesMetadataRepository;
    }

    // Initialize the Path after Spring injects the value
    @PostConstruct
    public void init() {
        this.uploadPath = Paths.get(uploadDir);
        try {
            Files.createDirectories(uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

    @Override
    public ResponseEntity<?> AddFileDetails(FilesMetadataDTO request) throws IOException {
        MultipartFile file = request.getFile();

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("File must be selected");
        }

        String contentType = file.getContentType();
        if (!List.of("application/pdf", "image/jpg", "image/jpeg", "image/png").contains(contentType)) {
            return ResponseEntity.badRequest().body("File type not allowed");
        }

        long maxSize = 50 * 1024 * 1024; // 50MB
        if (file.getSize() > maxSize) {
            return ResponseEntity.badRequest().body("File size must not exceed 50MB");
        }

        String cleanName = Paths.get(file.getOriginalFilename()).getFileName().toString();
        String storedName = UUID.randomUUID() + "_" + cleanName;

        Path target = uploadPath.resolve(storedName);
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        FIlesMetadata entity = new FIlesMetadata();
        entity.setDoc_id(request.getDoc_id());
        entity.setNameOfTheDocument(request.getNameOfTheDocument());
        entity.setCollectedBy(request.getCollectedBy());
        entity.setReceveidBy(request.getReceveidBy());
        entity.setReleasedBy(request.getReleasedBy());
        entity.setLocation(request.getLocation());
        entity.setShelf(request.getShelf());
        entity.setNo(request.getNo());
        entity.setOriginalFileName(cleanName);
        entity.setReceivedAttDate(request.getReceivedAttDate());
        entity.setReleasedAttDate(request.getReleasedAttDate());
        entity.setStoredFileName(storedName);

        filesMetadataRepository.save(entity);
        return ResponseEntity.ok("Document File added successfully");
    }

    @Override
    public ResponseEntity<?> updateFileMetadataDetails(FilesMetadataDTO request, Long id) {
        Optional<FIlesMetadata> existingOpt = filesMetadataRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Record not found with ID: " + id);
        }

        FIlesMetadata entity = existingOpt.get();

        // Update file if provided
        MultipartFile file = request.getFile();
        if (file != null && !file.isEmpty()) {
            String cleanName = Paths.get(file.getOriginalFilename()).getFileName().toString();
            String storedName = UUID.randomUUID() + "_" + cleanName;
            Path target = uploadPath.resolve(storedName);

            try {
                Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Failed to upload file");
            }

            entity.setOriginalFileName(cleanName);
            entity.setStoredFileName(storedName);
        }

        // Update metadata safely
        entity.setDoc_id(request.getDoc_id());
        entity.setNameOfTheDocument(request.getNameOfTheDocument());
        entity.setCollectedBy(request.getCollectedBy());
        entity.setReceveidBy(request.getReceveidBy());
        entity.setReleasedBy(request.getReleasedBy());
        entity.setLocation(request.getLocation());
        entity.setShelf(request.getShelf());
        entity.setNo(request.getNo());
        entity.setReceivedAttDate(request.getReceivedAttDate());
        entity.setReleasedAttDate(request.getReleasedAttDate());

        filesMetadataRepository.save(entity);
        return ResponseEntity.ok("Document metadata updated successfully");
    }

    @Override
    public ResponseEntity<?> deleteFileMetadataDetails(Long doc_id) {
        Optional<FIlesMetadata> existing = filesMetadataRepository.findById(doc_id);
        if (existing.isEmpty()) {
            return ResponseEntity.status(404).body("Record not found");
        }

        FIlesMetadata entity = existing.get();

        // Delete file from storage
        if (entity.getStoredFileName() != null) {
            Path filePath = uploadPath.resolve(entity.getStoredFileName());
            try {
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Failed to delete file from storage");
            }
        }

        filesMetadataRepository.delete(entity);
        return ResponseEntity.ok("Record deleted su" +
                "ccessfully");
    }

    @Override
    public ResponseEntity<List<FilesMetadataDTO>> getAllFilesBYyId(Long doc_id) {
        List<FIlesMetadata> list = filesMetadataRepository.findAll()
                .stream()
                .filter(f -> Objects.equals(f.getDoc_id(), doc_id))
                .collect(Collectors.toList());

        List<FilesMetadataDTO> dtoList = list.stream().map(f -> {
            FilesMetadataDTO dto = new FilesMetadataDTO();
            dto.setDoc_id(f.getDoc_id());
            dto.setNameOfTheDocument(f.getNameOfTheDocument());
            dto.setCollectedBy(f.getCollectedBy());
            dto.setReceveidBy(f.getReceveidBy());
            dto.setReleasedBy(f.getReleasedBy());
            dto.setLocation(f.getLocation());
            dto.setShelf(f.getShelf());
            dto.setNo(f.getNo());
            dto.setOriginalFileName(f.getOriginalFileName());
            dto.setStoredFileName(f.getStoredFileName());
            dto.setReceivedAttDate(f.getReceivedAttDate());
            dto.setReleasedAttDate(f.getReleasedAttDate());
            dto.setId(f.getId());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<?> DownloadDocumentById(Long id) {
        Optional<FIlesMetadata> existing = filesMetadataRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.status(404).body("Record not found");
        }

        FIlesMetadata entity = existing.get();
        Path filePath = uploadPath.resolve(entity.getStoredFileName());

        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
            if (!resource.exists()) {
                return ResponseEntity.status(404).body("File not found on server");
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(500).body("Error reading file");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + entity.getOriginalFileName() + "\"")
                .body(resource);
    }
}
