package com.example.OffficeOperation.model;

import jakarta.persistence.*;

@Entity
@Table(name="DocumentsRegistry")
public class DocumentsRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String NameOfTheParties;

    @Column(columnDefinition = "TEXT")
    private String CourtOrTribunalOrCma;

    @Column(columnDefinition = "TEXT")
    private String LocationOrLocker;

    @Column(columnDefinition = "TEXT")
    private String Shelf;

    @Column(columnDefinition = "TEXT")
    private String No;

    /* ================== NEW PART ================== */

    // Base64 string (file content)
    @Column(columnDefinition = "LONGTEXT")
    private String attachment;

    // Original file name (e.g case.pdf)
    @Column(columnDefinition = "TEXT")
    private String attachmentName;

    /* ============================================== */

    // Default constructor
    public DocumentsRegistry(){}

    // Constructor (optional – unaweza kuongeza attachment pia)
    public DocumentsRegistry(
            Long id,
            String NameOfTheParties,
            String CourtOrTribunalOrCma,
            String LocationOrLocker,
            String Shelf,
            String No,
            String attachment,
            String attachmentName
    ) {
        this.id = id;
        this.NameOfTheParties = NameOfTheParties;
        this.CourtOrTribunalOrCma = CourtOrTribunalOrCma;
        this.LocationOrLocker = LocationOrLocker;
        this.Shelf = Shelf;
        this.No = No;
        this.attachment = attachment;
        this.attachmentName = attachmentName;
    }

    /* ============== GETTERS ================= */

    public Long getId() {
        return id;
    }

    public String getNameOfTheParties() {
        return NameOfTheParties;
    }

    public String getCourtOrTribunalOrCma() {
        return CourtOrTribunalOrCma;
    }

    public String getLocationOrLocker() {
        return LocationOrLocker;
    }

    public String getShelf() {
        return Shelf;
    }

    public String getNo() {
        return No;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    /* ============== SETTERS ================= */

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameOfTheParties(String nameOfTheParties) {
        NameOfTheParties = nameOfTheParties;
    }

    public void setCourtOrTribunalOrCma(String courtOrTribunalOrCma) {
        CourtOrTribunalOrCma = courtOrTribunalOrCma;
    }

    public void setLocationOrLocker(String locationOrLocker) {
        LocationOrLocker = locationOrLocker;
    }

    public void setShelf(String shelf) {
        Shelf = shelf;
    }

    public void setNo(String no) {
        No = no;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }
}
