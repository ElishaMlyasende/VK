package com.example.UserService.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<user> users=new HashSet<>();
    @ManyToMany
    @JoinTable(name="role_permission",
     joinColumns = @JoinColumn(name="role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id"))
     private  Set<permission> permissions=new HashSet<>();

    // constructor
    public role(){

    }
    public role(Long id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }
    // creating getter and setter


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPermissions(Set<permission> permissions) {
        this.permissions = permissions;
    }

    public Set<permission> getPermissions() {
        return permissions;
    }
}
