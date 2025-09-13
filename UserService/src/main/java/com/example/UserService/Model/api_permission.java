package com.example.UserService.Model;

import jakarta.persistence.*;

@Entity
@Table(name="api")
public class api_permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="method")
    private String method;

    @Column(name = "path")
    private String path;
    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "api")
    private Permission permission;

    //create constructor
    public api_permission(){

    }
    public api_permission(Long id, String method, String path){
        this.id=id;
        this.method=method;
        this.path=path;
    }
    // creating getter and setter


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getDescription(){
        return  description;
    }
    public void setDescription(String description){
        this.description=description;
    }

}
