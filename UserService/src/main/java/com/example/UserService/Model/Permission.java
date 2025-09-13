package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference
    private Set<User> user=new HashSet<>();
    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference
    private Set<Role> Roles=new HashSet<>();

    @OneToOne
    @JoinColumn(name = "api_id", referencedColumnName = "id", unique = true)
    private api_permission api ;


    //constructor
    public Permission(){

    }
    public Permission(Long id, String name, String description){
        this.id=id;
        this.description=description;
        this.name=name;
    }

    // creating getter and setter


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
