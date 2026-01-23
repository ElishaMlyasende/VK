package com.example.OffficeOperation.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String nameOfTheParties;

    private LocalDate receivedDate;

    /* ===== getters & setters ===== */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate; // <<< corrected
    }

    public String getNameOfTheParties() {
        return nameOfTheParties;
    }

    public void setNameOfTheParties(String nameOfTheParties) {
        this.nameOfTheParties = nameOfTheParties;
    }
}
