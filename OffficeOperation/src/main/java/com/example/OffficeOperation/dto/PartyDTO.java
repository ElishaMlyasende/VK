package com.example.OffficeOperation.dto;

public class PartyDTO {
    private Long id;
    private String nameOfTheParties;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNameOfTheParties(String nameOfTheParties) {
        this.nameOfTheParties = nameOfTheParties;
    }

    public String getNameOfTheParties() {
        return nameOfTheParties;
    }

    public String getPosition() {
        return position;
    }
}
