package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.DocumentsRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRegistryRepository extends JpaRepository<DocumentsRegistry, Long> {
}
