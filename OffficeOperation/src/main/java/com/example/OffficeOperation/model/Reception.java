package com.example.OffficeOperation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String visitorName;
    private String purpose;
    private String phoneNumber;
    private String departmentToVisit;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private Boolean attended;

    public Reception() {}

    public Reception(String visitorName, String purpose, String phoneNumber,
                     String departmentToVisit, LocalDateTime timeIn, Boolean attended) {
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.phoneNumber = phoneNumber;
        this.departmentToVisit = departmentToVisit;
        this.timeIn = timeIn;
        this.attended = attended;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentToVisit() {
        return departmentToVisit;
    }

    public void setDepartmentToVisit(String departmentToVisit) {
        this.departmentToVisit = departmentToVisit;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }
}
