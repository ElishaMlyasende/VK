package com.example.OffficeOperation.dto;

import com.example.OffficeOperation.model.FIlesMetadata;
import jakarta.persistence.*;

public class PartiesDto {
    private Long id;
    private String position;
    @ManyToOne
    @JoinColumn(name="doc_id")
    private FIlesMetadata FilesMetadata;
    public PartiesDto(Long id,FIlesMetadata FilesMetadata,String position){
        this.FilesMetadata=FilesMetadata;
        this.position=position;
        this.id=id;
    }
    public PartiesDto(){}
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public FIlesMetadata getfIlesMetadata() {return FilesMetadata;}
    public String getPosition() {return position;}
    public void setfIlesMetadata(FIlesMetadata FilesMetadata) {this.FilesMetadata =FilesMetadata;}
    public void setPosition(String position) {this.position = position;}

}
