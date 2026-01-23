package com.example.OffficeOperation.model;
import jakarta.persistence.*;
@Entity
@Table(name="Parties")
public class Parties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    @ManyToOne
    @JoinColumn(name="doc_id")
    private FIlesMetadata FilesMetadata;
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public FIlesMetadata getfIlesMetadata() {return FilesMetadata;}
    public String getPosition() {return position;}
    public void setfIlesMetadata(FIlesMetadata FilesMetadata) {this.FilesMetadata =FilesMetadata;}
    public void setPosition(String position) {this.position = position;}
}
