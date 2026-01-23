package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.Attachment;
import com.example.OffficeOperation.Repository.AttachmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/Client/Attachments")
public class AttachmentController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private AttachmentRepository attachmentRepository;

    // Fetch all attachments for a workflow
    @GetMapping("/all/{fileId}")
    public List<Attachment> getAllAttachments(@PathVariable int fileId) {
        return attachmentRepository.findByFileId(fileId);
    }

    // Serve file for viewing in browser
    @GetMapping("/view/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> viewFile(@PathVariable String filename) {
        try {
            // 1. Build file path using uploadDir property
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            // 2. Check if file exists
            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 3. Determine content type dynamically
            String contentType = Files.probeContentType(filePath);
            if (contentType == null) {
                contentType = "application/octet-stream"; // default binary type
            }

            // 4. Return response with inline to view in browser
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Add attachment
    @PostMapping("/add")
    public ResponseEntity<?> addAttachment(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fileId") int fileId,
            @RequestParam(value = "description", required = false) String description
    ) throws IOException {

        File folder = new File(uploadDir);
        if (!folder.exists()) folder.mkdirs();

        String filePath = uploadDir + "/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        Attachment attachment = new Attachment();
        attachment.setFileName(file.getOriginalFilename());
        attachment.setUrl(file.getOriginalFilename()); // store just filename
        attachment.setFileId(fileId);
        attachment.setDescription(description);

        attachmentRepository.save(attachment);

        return ResponseEntity.ok("Attachment added");
    }

    // Delete attachment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAttachment(@PathVariable Long id) {
        Attachment attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attachment not found"));

        File file = new File(uploadDir + "/" + attachment.getUrl());
        if (file.exists()) file.delete();

        attachmentRepository.delete(attachment);
        return ResponseEntity.ok("Attachment deleted");
    }
}
