package com.example.caseMnagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.caseMnagement.model.comment;

import java.util.List;

@Service
public interface commentService {
    comment SaveComment(comment comment);
    List<comment> getCommentsByCaseId(String caseId);
}
