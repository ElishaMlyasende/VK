package com.example.caseMnagement.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.caseMnagement.service.caseService;
import com.example.caseMnagement.model.caseModel;

import java.util.List;

@RestController
@RequestMapping("/case")
public class caseController {
    private  caseService caseService;
    //constructor
    public  caseController(caseService caseService){
        this.caseService=caseService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveCase(@RequestBody caseModel savedCase){
        return  caseService.addCase(savedCase);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editCase(@PathVariable("id") Long id, @RequestBody caseModel caseModel){
         return caseService.updateCase(caseModel,id);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return  caseService.deleteCase(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return caseService.getCaseById(id);
    }
    @GetMapping("/all")
    public List<caseModel>getAllCases(){
        return caseService.getListOfAllCase();
    }
}
