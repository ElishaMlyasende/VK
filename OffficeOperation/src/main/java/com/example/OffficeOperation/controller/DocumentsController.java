package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.Documents;
import com.example.OffficeOperation.model.DocumentsRegistry;
import com.example.OffficeOperation.service.DocumentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Documents")
public class DocumentsController {
    private final DocumentsService documentsService;
    public DocumentsController(DocumentsService documentsService){
        this.documentsService=documentsService;
    }
    @PostMapping("/add")
    ResponseEntity<?> registerDocuments(@RequestBody Documents SavedFile){
        return documentsService.register(SavedFile);
    }
    @PutMapping("/update/{id}")
    ResponseEntity<?>updateDocument(@RequestBody Documents Documents,@PathVariable("id") Long id){
        return documentsService.updateDocument(Documents,id);
    }
    @DeleteMapping("delete/{id}")
    ResponseEntity<?>DeleteDocuments(@PathVariable("id") Long id){
        return documentsService.DeleteDocuments(id);
    }
    @GetMapping("/all")
    ResponseEntity<List<Documents>>GetAllDocuments(){
        return documentsService.GetAllDocuments();
    }
    @PostMapping("/bulk")
    ResponseEntity<?>addBulkFiles(List<Documents> documents){
        return documentsService.addBulkFiles(documents);
    }
}
