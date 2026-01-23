package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.DocumentAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentAttachmentRepository extends JpaRepository<DocumentAttachment, Long> {

    // Correct way to query by the id of the related entity
    List<DocumentAttachment> findByDocument_Id(Long documentId);
}
