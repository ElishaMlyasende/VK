package com.example.OffficeOperation.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="workflow")
public class workFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String typeOfWork;
    private String activities;

    private LocalDate dateReceivedFromBank;
    private LocalDate dateSubmittedToRegistrar;
    private String registryName;
    private LocalDate dateCollected;

    private String submissionToBankAndOfficer;
    private String agreedFee;
    private String controlNumber;

    private BigDecimal amount;
    private BigDecimal facilitationFee;
    private String contactPerson;
    private String remarks;
    private BigDecimal profit;
    //constructor
    public workFloor(){}

    public workFloor(
            Long id,
            String firstName,
            String middleName,
            String lastName,
            String typeOfWork,
            String activities,
            LocalDate dateReceivedFromBank,
            LocalDate dateSubmittedToRegistrar,
            String registryName,
            LocalDate dateCollected,
            String submissionToBankAndOfficer,
            String agreedFee,
            String controlNumber,
            BigDecimal amount,
            BigDecimal facilitationFee,
            String contactPerson,
            String remarks,
            BigDecimal profit) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.typeOfWork = typeOfWork;
        this.activities = activities;
        this.dateReceivedFromBank = dateReceivedFromBank;
        this.dateSubmittedToRegistrar = dateSubmittedToRegistrar;
        this.registryName = registryName;
        this.dateCollected = dateCollected;
        this.submissionToBankAndOfficer = submissionToBankAndOfficer;
        this.agreedFee = agreedFee;
        this.controlNumber = controlNumber;
        this.amount = amount;
        this.facilitationFee = facilitationFee;
        this.contactPerson = contactPerson;
        this.remarks = remarks;
        this.profit = profit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getActivities() {
        return activities;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public BigDecimal getFacilitationFee() {
        return facilitationFee;
    }

    public LocalDate getDateReceivedFromBank() {
        return dateReceivedFromBank;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setDateReceivedFromBank(LocalDate dateReceivedFromBank) {
        this.dateReceivedFromBank = dateReceivedFromBank;
    }

    public LocalDate getDateSubmittedToRegistrar() {
        return dateSubmittedToRegistrar;
    }

    public LocalDate getDateCollected() {
        return dateCollected;
    }

    public String getAgreedFee() {
        return agreedFee;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public String getRegistryName() {
        return registryName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setDateSubmittedToRegistrar(LocalDate dateSubmittedToRegistrar) {
        this.dateSubmittedToRegistrar = dateSubmittedToRegistrar;
    }

    public String getSubmissionToBankAndOfficer() {
        return submissionToBankAndOfficer;
    }

    public void setAgreedFee(String agreedFee) {
        this.agreedFee = agreedFee;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public void setDateCollected(LocalDate dateCollected) {
        this.dateCollected = dateCollected;
    }

    public void setFacilitationFee(BigDecimal facilitationFee) {
        this.facilitationFee = facilitationFee;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setSubmissionToBankAndOfficer(String submissionToBankAndOfficer) {
        this.submissionToBankAndOfficer = submissionToBankAndOfficer;
    }
}
