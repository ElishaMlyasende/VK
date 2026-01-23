package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.Parties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiesRepository extends JpaRepository<Parties,Long> {
}
