package com.example.cashBook.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class mobilePettyCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "control_number")
    private String controlNumber;

    @Column(name = "amount_in")
    private BigDecimal amountIn;

    @Column(name = "amount_out")
    private BigDecimal amountOut;

    @Column(name = "mpesa_fee")
    private BigDecimal mpesaFee;

    @Column(name = "advocate_comment")
    private String advocateComment;

    // Constructors
    public mobilePettyCash() {
    }

    public mobilePettyCash(LocalDate date, String clientName, String controlNumber,
                       BigDecimal amountIn, BigDecimal amountOut, BigDecimal mpesaFee, String advocateComment) {
        this.date = date;
        this.clientName = clientName;
        this.controlNumber = controlNumber;
        this.amountIn = amountIn;
        this.amountOut = amountOut;
        this.mpesaFee = mpesaFee;
        this.advocateComment = advocateComment;
    }

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public BigDecimal getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(BigDecimal amountIn) {
        this.amountIn = amountIn;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    public BigDecimal getMpesaFee() {
        return mpesaFee;
    }

    public void setMpesaFee(BigDecimal mpesaFee) {
        this.mpesaFee = mpesaFee;
    }

    public String getAdvocateComment() {
        return advocateComment;
    }

    public void setAdvocateComment(String advocateComment) {
        this.advocateComment = advocateComment;
    }
}
