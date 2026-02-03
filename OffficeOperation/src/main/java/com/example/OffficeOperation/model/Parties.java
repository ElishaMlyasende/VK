package com.example.OffficeOperation.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name="Parties")
public class Parties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String nameOfTheParties;
    @ManyToOne
    @JoinColumn(name="doc_id")
   @JsonBackReference
    private Documents Documents;
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
    public Documents getDocuments() {return Documents;}
    public void setDocuments(Documents documents) {Documents = documents;}
    public String getNameOfTheParties() {return nameOfTheParties;}
    public void setNameOfTheParties(String nameOfTheParties) {this.nameOfTheParties = nameOfTheParties;}
}
