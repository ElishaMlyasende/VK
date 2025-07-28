package com.example.caseMnagement.implement;

import com.example.caseMnagement.model.caseModel;
import com.example.caseMnagement.service.caseService;
import com.example.caseMnagement.Respository.caseRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class caseImplement implements caseService {
    private final caseRepository caseRepository;

    // You can externalize this path in application.properties later
    private final String uploadDir = "uploads/";

    public caseImplement(caseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public ResponseEntity<?> addCase(caseModel caseModel, MultipartFile document) {
        try {
            if (document != null && !document.isEmpty()) {
                String filename = saveFile(document);
                caseModel.setFileName(filename);
            }
            caseRepository.save(caseModel);
            return ResponseEntity.ok("Record added successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateCase(caseModel caseModel, Long id, MultipartFile document) {
        Optional<caseModel> existingCaseOpt = caseRepository.findById(id);
        if (existingCaseOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Case not found");
        }

        caseModel existingCase = existingCaseOpt.get();

        try {
            if (document != null && !document.isEmpty()) {
                // Save new file and update fileName
                String filename = saveFile(document);
                caseModel.setFileName(filename);
            } else {
                // Keep the existing file name
                caseModel.setFileName(existingCase.getFileName());
            }

            // Ensure same ID for updating existing record
            caseModel.setId(id);

            caseRepository.save(caseModel);
            return ResponseEntity.ok("Record updated successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }

    private String saveFile(MultipartFile file) throws IOException {
        // Create upload dir if not exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique file name
        String originalFilename = file.getOriginalFilename();
        String ext = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            ext = originalFilename.substring(originalFilename.lastIndexOf('.'));
        }

        String filename = UUID.randomUUID().toString() + ext;

        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    @Override
    public ResponseEntity<?> deleteCase(Long id) {
        Optional<caseModel> checkId = caseRepository.findById(id);
        if (checkId.isEmpty()) {
            return ResponseEntity.badRequest().body("Case not found");
        }

        // Optional: delete file from disk if needed

        caseRepository.deleteById(id);
        return ResponseEntity.ok("Record removed successfully");
    }

    @Override
    public ResponseEntity<?> getCaseById(Long id) {
        Optional<caseModel> checkId = caseRepository.findById(id);
        if (checkId.isEmpty()) {
            return ResponseEntity.badRequest().body("Case not found");
        }
        return ResponseEntity.ok(checkId.get());
    }

    @Override
    public List<caseModel> getListOfAllCase() {
        return caseRepository.findAll();
    }
    @Override
    public ResponseEntity<Resource> downloadCaseFile(Long id) {
        try {
            // 1. Fetch the case
            caseModel caseData = caseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Case not found"));

            // 2. Get the filename
            String fileName = caseData.getFileName(); // use your actual field

            // 3. Build the file path
            Path filePath = Paths.get("uploads").resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 4. Determine content type
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            // 5. Return the response
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
