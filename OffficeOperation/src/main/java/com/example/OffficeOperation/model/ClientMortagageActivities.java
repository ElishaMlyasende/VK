package com.example.OffficeOperation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="ClientMortagageActivities")
public class ClientMortagageActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition="TEXT")
    private String Activity;
    private int Amount;
    @ManyToOne()
    @JoinColumn(name = "Client_Id")
    @JsonBackReference
    private workFloor workFloor;
    private BigDecimal facilitationFee;

    //create default constructor
    public ClientMortagageActivities(){}
    //creating the constructors
    public ClientMortagageActivities(Long id,BigDecimal facilitationFee, String Activity,int Amount,workFloor workFloor){
        this.Activity=Activity;
        this.id=id;
        this.Amount=Amount;
        this.workFloor=workFloor;
        this.facilitationFee=facilitationFee;
    }
    public Long getId(){
        return id;
    }
    public int getAmount(){
        return  Amount;
    }
    public String getActivity(){
        return Activity;
    }

    public workFloor getWorkFloor() {
        return workFloor;
    }
    public void setActivity(String Activity){
        this.Activity=Activity;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setWorkFloor(workFloor workFloor){
        this.workFloor=workFloor;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setFacilitationFee(BigDecimal facilitationFee) {
        this.facilitationFee = facilitationFee;
    }

    public BigDecimal getFacilitationFee() {
        return facilitationFee;
    }
}
