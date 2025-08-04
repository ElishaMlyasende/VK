package com.example.caseMnagement.Respository;

import com.example.caseMnagement.model.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentRepository  extends JpaRepository<comment, Long> {
    List<comment> findByCaseId(String caseId);
}
