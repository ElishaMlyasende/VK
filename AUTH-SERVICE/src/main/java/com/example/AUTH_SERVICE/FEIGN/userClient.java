package com.example.AUTH_SERVICE.FEIGN;


import com.example.shareDTO.commonDTO.userResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="UserService", url="http://localhost:8082")
public interface userClient {
    @GetMapping("api/v1/user/getUser/{username}")
    userResponse getUserByUsername(@PathVariable String username);
}

