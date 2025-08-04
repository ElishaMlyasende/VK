package com.example.caseMnagement.Contoller;

import com.example.caseMnagement.model.comment;
import com.example.caseMnagement.service.commentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:5173")
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

    // WebSocket — send a comment for a specific case
    @MessageMapping("/chat.message/{caseId}")
    @SendTo("/topic/comments/{caseId}")
    public comment sendMessage(
            @DestinationVariable String caseId,
            comment message12
    ) {
        log.info("📩 Received WebSocket message for caseId: {}", caseId);
        log.info("➡ Payload received: {}", message12);

        // Debug fields individually
        log.debug("message12.caseId = {}", message12.getCaseId());
        log.debug("message12.text/message = {}", message12.getMessage());
        log.debug("message12.username = {}", message12.getUsername());

        // Set values
        message12.setTimestamp(LocalDateTime.now());
        message12.setCaseId(caseId);

        try {
            comment saved = commentService.SaveComment(message12);
            log.info("✅ Comment saved successfully: {}", saved);
            return saved;
        } catch (Exception e) {
            log.error("❌ Failed to save comment to DB", e);
            throw e; // rethrow to see error in console
        }
    }
}
