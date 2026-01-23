package com.example.OffficeOperation.Repository;

import com.example.OffficeOperation.model.Attachment; // hakikisha hii package ni sahihi
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findByFileId(int fileId);
}
