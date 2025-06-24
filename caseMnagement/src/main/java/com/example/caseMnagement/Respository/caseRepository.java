package com.example.caseMnagement.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caseMnagement.model.caseModel;
import org.springframework.stereotype.Repository;

@Repository
public interface caseRepository extends JpaRepository<caseModel, Long > {
}
