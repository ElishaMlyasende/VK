package com.example.OffficeOperation.implement;

import com.example.OffficeOperation.Repository.ClientReceptionActivitiesRepository;
import com.example.OffficeOperation.Repository.ReceptionRepository;
import com.example.OffficeOperation.model.ClientctivitiesReception;
import com.example.OffficeOperation.service.ClientReceptionActivitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientReceptionActivitiesImplement implements ClientReceptionActivitiesService {
    private final ClientReceptionActivitiesRepository clientReceptionActivitiesRepository;
    private final ReceptionRepository receptionRepository;
    // creating constructor
    public ClientReceptionActivitiesImplement(ClientReceptionActivitiesRepository clientReceptionActivitiesRepository,
                                              ReceptionRepository receptionRepository){
        this.clientReceptionActivitiesRepository=clientReceptionActivitiesRepository;
        this.receptionRepository=receptionRepository;
    }
    @Override
    public ResponseEntity<?> addClientReceptionActivity(ClientctivitiesReception savedActivity) {
        clientReceptionActivitiesRepository.save(savedActivity);
        return ResponseEntity.ok("Client Activities Added Successfully");
    }

    @Override
    public ResponseEntity<?> UpdateRecptionActivity(ClientctivitiesReception UpdatedActivity, Long id) {
        Optional<ClientctivitiesReception> ID=clientReceptionActivitiesRepository.findById(id);
        if (!ID.isPresent()){
            return ResponseEntity.badRequest().body("Client With This Id Not Exist");
        }
        clientReceptionActivitiesRepository.save(UpdatedActivity);
        return ResponseEntity.ok("Client Detail Updatd Successfully");
    }

    @Override
    public ResponseEntity<?> DeleteClientActivity(Long id) {
        Optional<ClientctivitiesReception>IDs=clientReceptionActivitiesRepository.findById(id);
        if(!IDs.isPresent()){
            return ResponseEntity.badRequest().body("Client with This Id Does not EXist");
        }
        clientReceptionActivitiesRepository.deleteById(id);
        return ResponseEntity.ok("Client Activity Has Ben Deleted Successfully");
    }

    @Override
    public List<ClientctivitiesReception> GetListOfActivityById(List<Long> id) {
        List<ClientctivitiesReception>ActivityList=clientReceptionActivitiesRepository.findAllById(id);
         return  ActivityList;
        }
    }

