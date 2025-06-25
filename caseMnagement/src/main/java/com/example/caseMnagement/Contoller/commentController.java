package com.example.caseMnagement.Contoller;

import com.example.caseMnagement.model.comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.caseMnagement.service.commentService;

import java.util.List;

@RestController
@RequestMapping("/coomment")
public class commentController {
    private final commentService commentService;
    public  commentController(commentService commentService){
        this.commentService=commentService;
    }
    @PostMapping("/add/{id}")
    public ResponseEntity<?>addComment(@PathVariable("id")Long id, comment comment){
        return  commentService.addComment(id, comment);
    }
    @PutMapping("/add/{id}")
    public  ResponseEntity<?> editComment(@PathVariable("id")Long id,comment comment){
        return  commentService.editComment(comment,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteComment(@PathVariable("id")Long id){
        return commentService.deleteComment(id);
    }
    @GetMapping("/all")
    public List<comment> getAllComment(){
        return commentService.listAllComment();
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> getCommentById(@PathVariable("id")Long id){
        return commentService.getCommentById(id);
    }
}
