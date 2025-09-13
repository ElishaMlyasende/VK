package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="middle_name")
    private String middle_name;

    @Column(name="Last_name")
    private  String last_name;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phone_number;
    @Column(name="password")
    private  String password;

    @ManyToMany
    @JoinTable(name="user_permission",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")

    )
    @JsonManagedReference
    private Set<Permission> permissions=new HashSet<>();



    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id")
    )
    @JsonManagedReference
    private Set<Role> roles=new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<userMenu> userMenus = new HashSet<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<subMenu> userSubMenus = new HashSet<>();

    //creating constructor

    public User(){

    }
    public User(Long id, String first_name, String last_name, String middle_name, String phone_number,
                String email, String password, String username){

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public Set<userMenu> getUserMenus() {
        return userMenus;
    }

    public Set<subMenu> getUserSubMenus() {
        return userSubMenus;
    }


    public void setUserMenus(Set<userMenu> userMenus) {
        this.userMenus = userMenus;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<subMenu> getSubMenus() {
        return userSubMenus;
    }

    public void setUserSubMenus(Set<subMenu> userSubMenus) {
        this.userSubMenus = userSubMenus;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
