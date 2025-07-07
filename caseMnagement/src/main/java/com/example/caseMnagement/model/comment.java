package com.example.caseMnagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="comments")
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="case_id")
    @JsonBackReference
    private caseModel caseModel;

    private String message;
    private LocalDate created_at;
    private LocalDate updated_at;

    // Default constructor (required by JPA)
    public comment() {
    }

    // Constructor with all fields except id (id is generated)
    public comment(caseModel caseModel, String message, LocalDate created_at, LocalDate updated_at) {
        this.caseModel = caseModel;
        this.message = message;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getters and setters below

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public caseModel getCaseModel() {
        return caseModel;
    }

    public void setCaseModel(caseModel caseModel) {
        this.caseModel = caseModel;
    }

    public String getMessage(){
        return  message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreated_at(){
        return  created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at(){
        return  updated_at;
    }

    public void setUpdated_at(LocalDate updated_at){
        this.updated_at=updated_at;
    }
}
