package com.example.UserService.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<user> user=new HashSet<>();
    @ManyToMany(mappedBy = "permissions")
    private Set<role> Roles=new HashSet<>();

    @OneToOne
    @JoinColumn(name = "api_id", referencedColumnName = "id", unique = true)
    private api_permission api ;


    //constructor
    public permission(){

    }
    public permission(Long id, String name, String description){
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
