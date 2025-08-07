package com.example.OffficeOperation.service;

import com.example.OffficeOperation.model.ClientctivitiesReception;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ClientReceptionActivitiesService {
    ResponseEntity<?>addClientReceptionActivity(ClientctivitiesReception savedActivity);
    ResponseEntity<?>UpdateRecptionActivity(ClientctivitiesReception UpdatedActivity, Long id);
    ResponseEntity<?>DeleteClientActivity(Long id);
    List<ClientctivitiesReception> GetListOfActivityById(List<Long>id);

}
