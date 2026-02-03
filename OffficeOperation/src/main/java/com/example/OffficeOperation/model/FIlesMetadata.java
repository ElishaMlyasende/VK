package com.example.OffficeOperation.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name="Files_Metadata")
@Entity
public class FIlesMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doc_id;
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
    private String storedFileName;
    private String originalFileName;
    private LocalDate receivedAttDate;
    private LocalDate releasedAttDate;
    public FIlesMetadata() {}
    public Long getId() { return id; }
    public String getNameOfTheDocument() { return nameOfTheDocument; }
    public String getReceveidBy() { return receveidBy; }
    public String getReleasedBy() { return releasedBy; }
    public String getCollectedBy() { return collectedBy; }
    public String getLocation() { return location; }
    public String getShelf() { return shelf; }
    public String getNo() { return no; }
    public String getOriginalFileName() {return originalFileName;}
    public String getStoredFileName() {return storedFileName;}
    public void setOriginalFileName(String originalFuleName) {this.originalFileName = originalFuleName;}
    public void setStoreFileName(String storeFileName) {this.storedFileName = storeFileName;}
    public long getDoc_id(){return doc_id;}
    public LocalDate getReceivedAttDate() {return receivedAttDate;}
    public LocalDate getReleasedAttDate() {return releasedAttDate;}
    public void setId(Long id) { this.id = id; }
    public void setNameOfTheDocument(String nameOfTheDocument) { this.nameOfTheDocument = nameOfTheDocument; }
    public void setReceveidBy(String receveidBy) { this.receveidBy = receveidBy; }
    public void setReleasedBy(String releasedBy) { this.releasedBy = releasedBy; }
    public void setCollectedBy(String collectedBy) { this.collectedBy = collectedBy; }
    public void setLocation(String location) { this.location = location; }
    public void setShelf(String shelf) { this.shelf = shelf; }
    public void setNo(String no) { this.no = no; }
    public void setDoc_id(Long doc_id){this.doc_id=doc_id;}
    public void setStoredFileName(String storedFileName){this.storedFileName=storedFileName;}
    public void setReceivedAttDate(LocalDate receivedAttDate) {this.receivedAttDate = receivedAttDate;}
    public void setReleasedAttDate(LocalDate releasedAttDate) {this.releasedAttDate = releasedAttDate;}

}
