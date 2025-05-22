package com.example.UserService.Repository;

import com.example.UserService.Model.permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface permissionRepository extends JpaRepository<permission, Long > {
}
