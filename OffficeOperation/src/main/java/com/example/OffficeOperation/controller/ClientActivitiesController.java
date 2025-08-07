package com.example.OffficeOperation.controller;

import com.example.OffficeOperation.Repository.ClientReceptionActivitiesRepository;
import com.example.OffficeOperation.model.ClientMortagageActivities;
import com.example.OffficeOperation.model.ClientctivitiesReception;
import com.example.OffficeOperation.service.ClientReceptionActivitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reception/Client/Activity")
public class ClientActivitiesController {
    private final ClientReceptionActivitiesService ClientReceptionActivitiesService;
    public ClientActivitiesController(ClientReceptionActivitiesService ClientReceptionActivitiesService){
        this.ClientReceptionActivitiesService=ClientReceptionActivitiesService;
    }
    @PostMapping("/add")
    public ResponseEntity<?>addReceptionActivity(@RequestBody ClientctivitiesReception Client){
        return ClientReceptionActivitiesService.addClientReceptionActivity(Client);
    }
    @PutMapping("/edit/{id}")
    ResponseEntity<?>EditReceptionActivityForClient(@RequestBody ClientctivitiesReception UPDATED,
                                                    @PathVariable("id")Long id){
        return ClientReceptionActivitiesService.UpdateRecptionActivity(UPDATED, id);

    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?>DeleteById(@PathVariable("id") Long id){
        return ClientReceptionActivitiesService.DeleteClientActivity(id);
    }
    @GetMapping("/ById/{id}")
    public List<ClientctivitiesReception>getAllById(List<Long> id){
        return ClientReceptionActivitiesService.GetListOfActivityById(id);
    }

}
