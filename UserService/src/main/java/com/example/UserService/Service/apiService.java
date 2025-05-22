package com.example.UserService.Service;

import com.example.UserService.Model.api_permission;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface apiService {
    ResponseEntity<?>addApi(api_permission savedApi);
    List<api_permission>getAllApi();
    ResponseEntity<?>getApiById(Long id);
    ResponseEntity<?>deleteApi(Long id);
    ResponseEntity<?>updateApi(api_permission updatedApi, Long id);
}
