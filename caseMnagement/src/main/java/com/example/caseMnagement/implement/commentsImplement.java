package com.example.caseMnagement.implement;

import com.example.caseMnagement.model.comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.caseMnagement.service.commentService;
import  com.example.caseMnagement.Respository.caseRepository;
import com.example.caseMnagement.Respository.commentRepository;
import  com.example.caseMnagement.model.caseModel;

import java.util.List;
import java.util.Optional;

@Service
public class commentsImplement  implements commentService {
    private final commentRepository commentRepository;
    private final caseRepository caseRepository;
    //constructor
    public commentsImplement(caseRepository caseRepository,commentRepository commentRepository){
        this.caseRepository=caseRepository;
        this.commentRepository=commentRepository;
    }
    @Override
    public ResponseEntity<String> addComment(Long id, comment comment) {
        Optional<caseModel> checkCase=caseRepository.findById(id);
        if (checkCase.isEmpty()){
            return ResponseEntity.badRequest().body("case not found");
        }
        caseModel caseModel=checkCase.get();
        comment.setCaseModel(caseModel);
        commentRepository.save(comment);
        return ResponseEntity.ok("record added successfully");
    }

    @Override
    public ResponseEntity<?> editComment(comment comment, Long id) {
        Optional<comment> checkComment= commentRepository.findById(id);
        if (checkComment.isEmpty()){
            return ResponseEntity.badRequest().body("comment not found");
        }
        comment comment1=checkComment.get();
        comment1.setMessage(comment.getMessage());
        comment1.setUpdated_at(comment.getUpdated_at());
        commentRepository.save(comment);
        return  ResponseEntity.ok("record updated successfully");
    }

    @Override
    public ResponseEntity<?> deleteComment(Long id) {
        Optional<comment> checkComment= commentRepository.findById(id);
        if (checkComment.isEmpty()){
            return ResponseEntity.badRequest().body("comment not found");
        }
        commentRepository.deleteById(id);
        return ResponseEntity.ok("message deleted successfuly");
    }

    @Override
    public List<comment> listAllComment() {
        List<comment> allComment=commentRepository.findAll();
        return allComment;
    }

    @Override
    public ResponseEntity<?> getCommentById(Long id) {
        Optional<comment> checkComment = commentRepository.findById(id);
        if (checkComment.isEmpty()) {
            return ResponseEntity.badRequest().body("comment not found");
        }

        return ResponseEntity.ok(checkComment);
    }
}
