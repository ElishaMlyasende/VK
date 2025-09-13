package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User> users=new HashSet<>();
    @ManyToMany
    @JoinTable(name="role_permission",
     joinColumns = @JoinColumn(name="role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonManagedReference
     private  Set<Permission> permissions=new HashSet<>();

    // constructor
    public Role(){

    }
    public Role(Long id, String name, String description){
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

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
