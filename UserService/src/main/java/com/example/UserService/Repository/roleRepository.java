package com.example.UserService.Repository;

import com.example.UserService.Model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {
}
