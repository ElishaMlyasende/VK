package com.example.OffficeOperation.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class FilesMetadataDTO {
    private Long id;
    private Long doc_id;
    private String nameOfTheDocument;
    private String receveidBy;
    private String releasedBy;
    private String collectedBy;
    private String location;
    private String shelf;
    private String no;
    private MultipartFile file;
    private  String storedFileName;
    private  String originalFileName;
    private LocalDate receivedAttDate;
    private LocalDate releasedAttDate;

    // default constructor
    public  FilesMetadataDTO(){}
    public FilesMetadataDTO(Long doc_id,Long id,LocalDate receivedAttDate,LocalDate releasedAttDate,String nameOfTheDocument,String receveidBy,String releasedBy,
                            String collectedBy,String location,String shelf,String no,
                            MultipartFile file,String originalFileName,String storedFileName){
        this.collectedBy=collectedBy;
        this.doc_id=doc_id;
        this.location=location;
        this.receveidBy=receveidBy;
        this.no=no;
        this.shelf=shelf;
        this.nameOfTheDocument=nameOfTheDocument;
        this.releasedBy=releasedBy;
        this.file=file;
        this.storedFileName=storedFileName;
        this.originalFileName=originalFileName;
        this.id=id;
        this.receivedAttDate=receivedAttDate;
        this.releasedAttDate=releasedAttDate;
    }
    public String getStoredFileName(){
        return  storedFileName;
    }
    public  String getOriginalFileName(){
        return  originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setStoredFileName(String storedFileName) {
        this.storedFileName = storedFileName;
    }

    public String getReceveidBy() {
        return receveidBy;
    }

    public void setReceveidBy(String receveidBy) {
        this.receveidBy = receveidBy;
    }

    public String getNameOfTheDocument() {
        return nameOfTheDocument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReleasedBy() {
        return releasedBy;
    }

    public void setReleasedBy(String releasedBy) {
        this.releasedBy = releasedBy;
    }

    public String getCollectedBy() {
        return collectedBy;
    }

    public void setNameOfTheDocument(String nameOfTheDocument) {
        this.nameOfTheDocument = nameOfTheDocument;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public String getLocation() {
        return location;
    }

    public Long getDoc_id() {
        return doc_id;
    }

    public String getShelf() {
        return shelf;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setDoc_id(Long doc_id) {
        this.doc_id = doc_id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public LocalDate getReleasedAttDate() {
        return releasedAttDate;
    }

    public LocalDate getReceivedAttDate() {
        return receivedAttDate;
    }

    public void setReceivedAttDate(LocalDate receivedAttDate) {
        this.receivedAttDate = receivedAttDate;
    }

    public void setReleasedAttDate(LocalDate releasedAttDate) {
        this.releasedAttDate = releasedAttDate;
    }
}
