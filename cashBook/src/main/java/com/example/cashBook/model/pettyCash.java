package com.example.cashBook.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="dail_Expense")
public class pettyCash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Date of the transaction
    private LocalDate date;

    // Description of the transaction
    private String description;

    // Amount of money that came in
    private Double amountIn;

    // Amount of money that went out
    private Double amountOut;

    // Comments from the advocate/lawyer
    private String advocateComment;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(Double amountIn) {
        this.amountIn = amountIn;
    }

    public Double getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(Double amountOut) {
        this.amountOut = amountOut;
    }

    public String getAdvocateComment() {
        return advocateComment;
    }

    public void setAdvocateComment(String advocateComment) {
        this.advocateComment = advocateComment;
    }
}
