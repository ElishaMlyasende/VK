package com.example.UserService.Model;
import com.example.UserService.Model.permission;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menus")
public class menu {




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
        private Set<permission> permissions;

        @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
        private List<subMenu> subMenus;


        //default constructor
    public menu(){

    }
        // constructor
        public menu(Long id, String title, String path, String icon, String component,
                    Set<permission> permissions, List<subMenu> subMenus) {
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

        public Set<permission> getPermissions() {
            return permissions;
        }

        public void setPermissions(Set<permission> permissions) {
            this.permissions = permissions;
        }

        public List<subMenu> getSubMenus() {
            return subMenus;
        }

        public void setSubMenus(List<subMenu> subMenus) {
            this.subMenus = subMenus;
        }


}
