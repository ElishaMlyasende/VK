package com.example.OffficeOperation.model;

import jakarta.persistence.*;

@Entity
@Table(name="Attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private int fileId;
    private String url;
    private String description;




    // constructors
    public Attachment() {}

    public Attachment(String fileName, String url,int fileId,String description) {
        this.fileName = fileName;
        this.fileId = fileId;
        this.url=url;
        this.description=description;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public int getFileId() { return fileId; }
    public void setFileId(int fileId) { this.fileId = fileId; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
