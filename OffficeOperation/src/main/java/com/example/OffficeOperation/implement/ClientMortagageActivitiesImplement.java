package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.ClientReceptionActivitiesRepository;
import com.example.OffficeOperation.model.ClientMortagageActivities;
import com.example.OffficeOperation.model.Reception;
import com.example.OffficeOperation.model.workFloor;
import com.example.OffficeOperation.service.ClientMortagageActivitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.OffficeOperation.Repository.ClientMortagageActivitiesRepository;
import com.example.OffficeOperation.Repository.workFlowRepository;
import com.example.OffficeOperation.Repository.ReceptionRepository;
import java.util.List;
import java.util.Optional;
import com.example.OffficeOperation.model.ClientMortagageActivities;

@Service
public class ClientMortagageActivitiesImplement implements ClientMortagageActivitiesService {
 private final ClientMortagageActivitiesRepository ClientMortagageActivitiesRepository;
 private final workFlowRepository workFlowRepository;

    public ClientMortagageActivitiesImplement(ClientMortagageActivitiesRepository ClientMortagageActivitieseRepository,
                                              workFlowRepository workFlowRepository) {
        this.ClientMortagageActivitiesRepository =ClientMortagageActivitieseRepository;
        this.workFlowRepository=workFlowRepository;
    }
    @Override
    public ResponseEntity<?> addClientActivity(ClientMortagageActivities saved) {
        ClientMortagageActivitiesRepository.save(saved);
        return ResponseEntity.ok("Client Activity Added Successfully");
    }

    @Override
    public ResponseEntity<?> EditClientActivity(ClientMortagageActivities ClientActivty, Long id) {
        Optional<workFloor> OptionCheck=workFlowRepository.findById(id);
        if (!OptionCheck.isPresent()){
            return ResponseEntity.badRequest().body("Client with Such ID  Not Found");
        }
        ClientMortagageActivitiesRepository.save(ClientActivty);
        return ResponseEntity.ok("Client Activities Record Updated Successfully");

    }

    @Override
    public ResponseEntity<?> deleteClientActivity(Long id) {
        Optional<ClientMortagageActivities> OptionCheck=ClientMortagageActivitiesRepository.findById(id);
        if (!OptionCheck.isPresent()){
            return ResponseEntity.badRequest().body("Client with Such ID  Not Found");
        }
        ClientMortagageActivitiesRepository.deleteById(id);
        return ResponseEntity.ok("Client Record  Deleted Successfully");
    }

    @Override
    public List<ClientMortagageActivities> ClientActivities(Long id) {
        List<ClientMortagageActivities> listOfActivities=ClientMortagageActivitiesRepository.findByWorkFloorId(id);
        return  listOfActivities;
    }
}
