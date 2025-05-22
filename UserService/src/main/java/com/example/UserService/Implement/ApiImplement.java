package com.example.UserService.Implement;


import com.example.UserService.Model.api_permission;
import com.example.UserService.Service.apiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.UserService.Repository.apiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApiImplement implements apiService {
    private final apiRepository apiRepository;
    public ApiImplement(apiRepository apiRepository){
        this.apiRepository=apiRepository;
    }
    @Override
    public ResponseEntity<?> addApi(api_permission savedApi) {
        apiRepository.save(savedApi);
        return ResponseEntity.ok("api saved successfully");
    }

    @Override
    public List<api_permission> getAllApi() {
        List<api_permission> allApi=apiRepository.findAll();
        return allApi;
    }

    @Override
    public ResponseEntity<?> getApiById(Long id) {
        Optional<api_permission> checkId=apiRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("Api Not Found");
        }
        return ResponseEntity.ok(checkId);

    }

    @Override
    public ResponseEntity<?> deleteApi(Long id) {
        Optional<api_permission> checkId=apiRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("api not found so can not be deleted");
        }
        apiRepository.deleteById(id);
        return ResponseEntity.ok("api deleted successfully");
    }

    @Override
    public ResponseEntity<?> updateApi(api_permission updatedApi, Long id) {
        Optional<api_permission> checkId=apiRepository.findById(id);
        if (checkId.isEmpty()){
            return ResponseEntity.badRequest().body("api not found so can not be updated");
        }
        apiRepository.save(updatedApi);
        return ResponseEntity.ok("api updated successfully");
    }
}
