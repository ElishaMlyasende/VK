package com.example.caseMnagement.Contoller;

import com.example.caseMnagement.model.comment;
import com.example.caseMnagement.service.commentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
<<<<<<< HEAD
@CrossOrigin(origins = "http://192.168.100.100:5173")
=======
>>>>>>> 86c89b0 (just complited the two modules file module and documnt module)
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);
    private final commentService commentService;

    public CommentController(commentService commentService) {
        this.commentService = commentService;
    }

    // REST API — get all comments for a case
    @GetMapping("/{caseId}")
    public List<comment> getComments(@PathVariable String caseId) {
        log.debug("Fetching comments for caseId: {}", caseId);
        return commentService.getCommentsByCaseId(caseId);
    }
    @PostMapping("/add")
    public comment SaveComment(@RequestBody comment updatedComment){
        return  commentService.SaveComment(updatedComment);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?>editComment(@RequestBody comment updated, @PathVariable("id")Long id){
        return commentService.UpdateCommet(updated,id);
    }


}
