package com.example.caseMnagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.caseMnagement.model.comment;

import java.util.List;

@Service
public interface commentService {
    ResponseEntity<String> addComment(Long id,comment comment);
    ResponseEntity<?> editComment(comment comment, Long id);
    ResponseEntity<?> deleteComment(Long id);
    List<comment> listAllComment();
    ResponseEntity<?>getCommentById(Long id);
}
