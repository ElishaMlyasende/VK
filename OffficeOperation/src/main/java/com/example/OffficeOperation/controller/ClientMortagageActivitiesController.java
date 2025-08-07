package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.model.ClientMortagageActivities;
import com.example.OffficeOperation.service.ClientMortagageActivitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Client/Activities")
public class ClientMortagageActivitiesController {
    private final ClientMortagageActivitiesService ClientMortagageActivitiesService;
    public ClientMortagageActivitiesController(ClientMortagageActivitiesService ClientMortagageActivitiesService){
        this.ClientMortagageActivitiesService=ClientMortagageActivitiesService;
    }
    @PostMapping("/add")
    public ResponseEntity<?>AddActivitiesToClient(@RequestBody ClientMortagageActivities ClientMortagageActivities){
       return ClientMortagageActivitiesService.addClientActivity(ClientMortagageActivities);
    }
    @PutMapping("/EDIT/{id}")
    public ResponseEntity<?>EditActivitiesToClient(@RequestBody ClientMortagageActivities Clent,
                                                   @PathVariable("id") Long id){
        return ClientMortagageActivitiesService.EditClientActivity(Clent,id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteClientMortagageActivities(@PathVariable("id") Long id){
        return ClientMortagageActivitiesService.deleteClientActivity(id);
    }
    @GetMapping("/all/{id}")
    public List<ClientMortagageActivities> getALLClientActivitiesById(@PathVariable("id") Long id){
        return ClientMortagageActivitiesService.ClientActivities(id);
    }
}
