package com.example.UserService.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "sub_menus")
public class subMenu {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String path;
        private String component;

        @ManyToOne
        @JoinColumn(name = "menu_id")
        private menu menu;

        @ManyToMany
        @JoinTable(
                name = "submenu_permissions",
                joinColumns = @JoinColumn(name = "submenu_id"),
                inverseJoinColumns = @JoinColumn(name = "permission_id")
        )
        private Set<permission> permissions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private user user;


        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public menu getMenu() {
            return menu;
        }

        public void setMenu(menu menu) {
            this.menu = menu;
        }

        public Set<permission> getPermissions() {
            return permissions;
        }

    public void setUser(user user) {
        this.user = user;
    }

    public user getUser() {
        return user;
    }

    public void setPermissions(Set<permission> permissions) {
            this.permissions = permissions;
        }
    }


