package com.example.OffficeOperation.model;

import jakarta.persistence.*;
@Entity
@Table(name="ClientActivityReception")
public class ClientctivitiesReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Amount;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String Activity;
    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Reception Reception;
    //creating default constructor
    public  ClientctivitiesReception(){}
    //creating usable constructor
    public ClientctivitiesReception(Long id, String Activity,int Amount,Reception Reception){
        this.id=id;
        this.Amount=Amount;
        this.Activity=Activity;
        this.Reception=Reception;
    }
    //creating getter method
    public Long getId(){
        return id;
    }
    public String getActivity(){
        return Activity;
    }
    public int getAmount(){
        return Amount;
    }
    public Reception getReception(){
        return Reception;
    }
    //creating setter
    public void setId(Long id){
        this.id=id;
    }
    public void setAmount(int Amount){
        this.Amount=Amount;
    }
    public void setActivity(String Activity){
        this.Activity=Activity;
    }
    public void setReception(Reception Reception){
        this.Reception=Reception;
    }
}
