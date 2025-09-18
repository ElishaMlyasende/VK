package com.example.caseMnagement.model;

import jakarta.persistence.*;



import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "LONGTEXT")
    private String message;

    @Column(name = "case_id")
    private String caseId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public comment() {}

    public comment(String message, String caseId) {
        this.message = message;
        this.caseId = caseId;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
