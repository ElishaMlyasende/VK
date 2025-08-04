package com.example.caseMnagement.implement;

import com.example.caseMnagement.model.comment;
import org.springframework.stereotype.Service;
import com.example.caseMnagement.service.commentService;
import  com.example.caseMnagement.Respository.caseRepository;
import com.example.caseMnagement.Respository.commentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class commentsImplement  implements commentService {
    private final commentRepository commentRepository;
    //constructor
    public commentsImplement(commentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    @Override
    public comment SaveComment(comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<comment> getCommentsByCaseId(String caseId) {
       return commentRepository.findByCaseId(caseId);
    }
}
