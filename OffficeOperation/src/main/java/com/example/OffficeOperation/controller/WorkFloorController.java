package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.workFloor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.OffficeOperation.service.workFloorService;

import java.util.List;

@RestController
@RequestMapping("/Client/api")
public class WorkFloorController {
  private final workFloorService workFloorService;
  public WorkFloorController(workFloorService workFloorService){
    this.workFloorService=workFloorService;
  }
  @PostMapping("/add")
  public ResponseEntity<?>addClient(@RequestBody workFloor workFloor){
    return workFloorService.addWorkFlow(workFloor);
  }
  @PutMapping("/edit")
  public  ResponseEntity<?> editClient(@RequestParam Long id, @RequestBody workFloor workFloor){
    return workFloorService.editWorkFlow(workFloor,id);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteClient(@PathVariable("id")Long id, @RequestBody workFloor workFloor){
    return workFloorService.deleteWorkFlow(workFloor,id);
  }
  @GetMapping("/allClient")
  public List<workFloor> readAllClient(){
    return workFloorService.getAllClientWithworks();
  }
  @GetMapping("/allClient/{id}")
  public ResponseEntity<?> getClientById(@PathVariable("id") Long id){
    return workFloorService.getClientById(id);
  }
}
