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
        private Menu menu;

        @ManyToMany
        @JoinTable(
                name = "submenu_permissions",
                joinColumns = @JoinColumn(name = "submenu_id"),
                inverseJoinColumns = @JoinColumn(name = "permission_id")
        )
        private Set<Permission> permissions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


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

        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        public Set<Permission> getPermissions() {
            return permissions;
        }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setPermissions(Set<Permission> permissions) {
            this.permissions = permissions;
        }
    }


