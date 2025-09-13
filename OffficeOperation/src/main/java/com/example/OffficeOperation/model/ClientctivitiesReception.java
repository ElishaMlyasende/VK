package com.example.OffficeOperation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String Received;
    @ManyToOne()
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Reception reception;

    //creating default constructor
    public  ClientctivitiesReception(){}
    //creating usable constructor
    public ClientctivitiesReception(Long id, String Received,String Activity,int Amount,Reception reception){
        this.id=id;
        this.Amount=Amount;
        this.Activity=Activity;
        this.reception=reception;
        this.Received=Received;
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
        return reception;
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
        this.reception=Reception;
    }
    public String getReceived(){
        return  Received;
    }
    public  void  setReceived(String Received){
        this.Received=Received;
    }
}
