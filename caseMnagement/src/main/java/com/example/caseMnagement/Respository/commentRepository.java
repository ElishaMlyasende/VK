package com.example.caseMnagement.Respository;

import com.example.caseMnagement.model.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository  extends JpaRepository<comment, Long> {
}
