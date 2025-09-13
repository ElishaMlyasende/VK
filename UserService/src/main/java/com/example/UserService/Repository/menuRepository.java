package com.example.UserService.Repository;

import com.example.UserService.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface menuRepository extends JpaRepository<Menu, Long> {
}
