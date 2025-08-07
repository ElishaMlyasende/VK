package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.ClientMortagageActivities;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface ClientMortagageActivitiesService {
    ResponseEntity<?>addClientActivity(ClientMortagageActivities clientMortagageActivities);
    ResponseEntity<?>EditClientActivity(ClientMortagageActivities ClientActivty, Long id );
    ResponseEntity<?>deleteClientActivity(Long id);
    List<ClientMortagageActivities> ClientActivities(Long id);
}
