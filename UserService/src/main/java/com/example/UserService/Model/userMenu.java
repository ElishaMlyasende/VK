package com.example.UserService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "user_menu")
public class userMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private user user;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private menu menu;

    // Default constructor
    public userMenu() {}

    // Constructor
    public userMenu(user user, menu menu, Long id) {
        this.menu = menu;
        this.user = user;
        this.id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public menu getMenu() {
        return menu;
    }

    public void setMenu(menu menu) {
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
