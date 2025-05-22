package com.example.UserService.Repository;

import com.example.UserService.Model.api_permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface apiRepository extends JpaRepository<api_permission, Long> {
}
