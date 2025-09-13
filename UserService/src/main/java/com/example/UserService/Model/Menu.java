package com.example.UserService.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu {




    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String path;
        private String icon;
        private String component;

        @ManyToMany
        @JoinTable(
                name = "menu_permissions",
                joinColumns = @JoinColumn(name = "menu_id"),
                inverseJoinColumns = @JoinColumn(name = "permission_id")
        )
        private Set<Permission> permissions;

        @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
        private List<subMenu> subMenus;


        //default constructor
    public Menu(){

    }
        // constructor
        public Menu(Long id, String title, String path, String icon, String component,
                    Set<Permission> permissions, List<subMenu> subMenus) {
            this.id = id;
            this.title = title;
            this.path = path;
            this.icon = icon;
            this.component = component;
            this.permissions = permissions;
            this.subMenus = subMenus;
        }

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public Set<Permission> getPermissions() {
            return permissions;
        }

        public void setPermissions(Set<Permission> permissions) {
            this.permissions = permissions;
        }

        public List<subMenu> getSubMenus() {
            return subMenus;
        }

        public void setSubMenus(List<subMenu> subMenus) {
            this.subMenus = subMenus;
        }


}
