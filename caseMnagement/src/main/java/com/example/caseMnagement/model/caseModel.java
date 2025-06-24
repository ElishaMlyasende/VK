package com.example.caseMnagement.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="caseRecord")
public class caseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate dateOfInstruction;
    private String caseNumber;
    private String jurisdiction;
    private String plaintiff;
    private String defendant;
    private BigDecimal totalExposure;
    private String natureOfClaim;
    private String briefFacts;
    private String caseStatus;
    private BigDecimal totalClaim;
    private Double remoteProbability;
    private Double reasonablyPossible;
    private Double probable;

    @Column(length = 2000)
    private String comments;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    //here is just constructor
    public caseModel(
            LocalDate dateOfInstruction,
            String caseNumber,
            String jurisdiction,
            String plaintiff,
            String defendant,
            BigDecimal totalExposure,
            String natureOfClaim,
            String briefFacts,
            String caseStatus,
            BigDecimal totalClaim,
            Double remoteProbability,
            Double reasonablyPossible,
            Double probable,
            String comments,
            LocalDate createdAt,
            LocalDate updatedAt
    ) {
        this.dateOfInstruction = dateOfInstruction;
        this.caseNumber = caseNumber;
        this.jurisdiction = jurisdiction;
        this.plaintiff = plaintiff;
        this.defendant = defendant;
        this.totalExposure = totalExposure;
        this.natureOfClaim = natureOfClaim;
        this.briefFacts = briefFacts;
        this.caseStatus = caseStatus;
        this.totalClaim = totalClaim;
        this.remoteProbability = remoteProbability;
        this.reasonablyPossible = reasonablyPossible;
        this.probable = probable;
        this.comments = comments;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
// creating getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public LocalDate getDateOfInstruction() {
        return dateOfInstruction;
    }

    public String getDefendant() {
        return defendant;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public String getPlaintiff() {
        return plaintiff;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public BigDecimal getTotalExposure() {
        return totalExposure;
    }

    public void setDateOfInstruction(LocalDate dateOfInstruction) {
        this.dateOfInstruction = dateOfInstruction;
    }

    public BigDecimal getTotalClaim() {
        return totalClaim;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void setPlaintiff(String plaintiff) {
        this.plaintiff = plaintiff;
    }

    public Double getProbable() {
        return probable;
    }

    public String getNatureOfClaim() {
        return natureOfClaim;
    }

    public Double getReasonablyPossible() {
        return reasonablyPossible;
    }

    public Double getRemoteProbability() {
        return remoteProbability;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public String getBriefFacts() {
        return briefFacts;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setBriefFacts(String briefFacts) {
        this.briefFacts = briefFacts;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public void setTotalExposure(BigDecimal totalExposure) {
        this.totalExposure = totalExposure;
    }

    public void setNatureOfClaim(String natureOfClaim) {
        this.natureOfClaim = natureOfClaim;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setProbable(Double probable) {
        this.probable = probable;
    }

    public void setReasonablyPossible(Double reasonablyPossible) {
        this.reasonablyPossible = reasonablyPossible;
    }

    public void setRemoteProbability(Double remoteProbability) {
        this.remoteProbability = remoteProbability;
    }

    public void setTotalClaim(BigDecimal totalClaim) {
        this.totalClaim = totalClaim;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
