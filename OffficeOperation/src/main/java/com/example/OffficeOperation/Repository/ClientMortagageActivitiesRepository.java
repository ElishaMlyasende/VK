package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.ClientMortagageActivities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientMortagageActivitiesRepository extends JpaRepository<ClientMortagageActivities, Long> {
    List<ClientMortagageActivities> findByWorkFloorId(Long workFloorId);
}
