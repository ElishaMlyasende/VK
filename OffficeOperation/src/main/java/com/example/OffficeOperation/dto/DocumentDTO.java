package com.example.OffficeOperation.dto;

import com.example.OffficeOperation.model.Documents;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentDTO {
    private Long id;
    private LocalDate receivedDate;
    private List<PartyDTO> parties;
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public void setReceivedDate(LocalDate receivedDate) {this.receivedDate = receivedDate;}
    public LocalDate getReceivedDate() {return receivedDate;}
    public void setParties(List<PartyDTO> parties) {this.parties = parties;}
    public List<PartyDTO> getParties() {return parties;}
}
