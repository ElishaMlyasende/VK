package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Long> {
}
