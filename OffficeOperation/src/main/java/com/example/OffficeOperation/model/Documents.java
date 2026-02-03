package com.example.OffficeOperation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate receivedDate;
    @OneToMany(mappedBy = "Documents", cascade = CascadeType.ALL, orphanRemoval = true, fetch =FetchType.EAGER)
    @JsonManagedReference
    private List<Parties> Parties;
    /* ===== getters & setters ===== */
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public LocalDate getReceivedDate() {return receivedDate;}
    public void setReceivedDate(LocalDate receivedDate) {this.receivedDate = receivedDate;}
    public List<Parties> getParties() {return Parties;}
    public void setParties(List<Parties> parties) {Parties = parties;}

}
