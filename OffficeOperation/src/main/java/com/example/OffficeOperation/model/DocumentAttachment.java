package com.example.OffficeOperation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "document_attachments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DocumentAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String nameOfTheDocument;

    @Column(columnDefinition = "TEXT")
    private String receveidBy;

    @Column(columnDefinition = "TEXT")
    private String releasedBy;

    @Column(columnDefinition = "TEXT")
    private String collectedBy;

    @Column(columnDefinition = "TEXT")
    private String location;

    @Column(columnDefinition = "TEXT")
    private String shelf;

    @Column(columnDefinition = "TEXT")
    private String no;

    @Column(columnDefinition = "TEXT")
    private String fileType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Documents document;

    // Transient field for JSON base64
    @Transient
    private String fileBase64;

    /* ================= CONSTRUCTOR ================= */
    public DocumentAttachment() {}

    /* ================= GETTERS ================= */
    public Long getId() { return id; }
    public String getNameOfTheDocument() { return nameOfTheDocument; }
    public String getReceveidBy() { return receveidBy; }
    public String getReleasedBy() { return releasedBy; }
    public String getCollectedBy() { return collectedBy; }
    public String getLocation() { return location; }
    public String getShelf() { return shelf; }
    public String getNo() { return no; }
    public String getFileType() { return fileType; }
    public byte[] getFileData() { return fileData; }
    public Documents getDocument() { return document; }

    // Transient getter/setter for JSON base64
    public String getFileBase64() {
        if (fileData != null) {
            return Base64.getEncoder().encodeToString(fileData);
        }
        return fileBase64;
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
        if (fileBase64 != null && !fileBase64.isEmpty()) {
            this.fileData = Base64.getDecoder().decode(fileBase64);
        }
    }

    /* ================= SETTERS ================= */
    public void setId(Long id) { this.id = id; }
    public void setNameOfTheDocument(String nameOfTheDocument) { this.nameOfTheDocument = nameOfTheDocument; }
    public void setReceveidBy(String receveidBy) { this.receveidBy = receveidBy; }
    public void setReleasedBy(String releasedBy) { this.releasedBy = releasedBy; }
    public void setCollectedBy(String collectedBy) { this.collectedBy = collectedBy; }
    public void setLocation(String location) { this.location = location; }
    public void setShelf(String shelf) { this.shelf = shelf; }
    public void setNo(String no) { this.no = no; }
    public void setFileType(String fileType) { this.fileType = fileType; }
    public void setFileData(byte[] fileData) { this.fileData = fileData; }
    public void setDocument(Documents document) { this.document = document; }
}
