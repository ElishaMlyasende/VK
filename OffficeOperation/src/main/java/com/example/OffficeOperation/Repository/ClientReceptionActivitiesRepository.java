package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.ClientctivitiesReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientReceptionActivitiesRepository extends JpaRepository<ClientctivitiesReception, Long> {
    List<ClientctivitiesReception>findByReceptionId(Long id);
}
