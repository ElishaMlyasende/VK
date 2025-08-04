package com.example.caseMnagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String Username;
    private String caseId;
    private LocalDateTime created_at;

    // Default constructor (required by JPA)
    public comment() {
    }

    // Constructor with all fields except id (id is generated)
    public comment( String message, LocalDateTime created_at, String Username, String caseId) {
        this.message = message;
        this.created_at = created_at;
        this.Username = Username;
        this.caseId=caseId;
    }

    // Getters and setters below

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getMessage(){
        return  message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreated_at(){
        return  created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setTimestamp(LocalDateTime now) {
    }
    public String getCaseId(){
        return caseId;
    }
    public  void setCaseId(String caseId){
        this.caseId=caseId;
    }
}
