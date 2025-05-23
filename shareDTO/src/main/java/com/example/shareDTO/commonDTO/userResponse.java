package com.example.shareDTO.commonDTO;

import java.util.List;
import java.util.Optional;

public class userResponse {

    private Long id;
    private String username;
    private List<String> roles;
    private List<String> permissions;
    private List<MenuResponse> menus;

    // Default constructor
    public userResponse() {
    }

    // Constructor to initialize all fields
    public userResponse(Long id, String username, List<String> roles, List<String> permissions, List<MenuResponse> menus) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.permissions = permissions;
        this.menus = menus;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<MenuResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuResponse> menus) {
        this.menus = menus;
    }

    // --- Nested Class for Menu ---
    public static class MenuResponse {
        private String title;
        private String component;
        private String path;
        private List<SubMenuResponse> subMenus;

        public MenuResponse(String title, String component, String path, List<SubMenuResponse> subMenus) {
            this.title = title;
            this.component = component;
            this.path = path;
            this.subMenus = subMenus;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<SubMenuResponse> getSubMenus() {
            return subMenus;
        }

        public void setSubMenus(List<SubMenuResponse> subMenus) {
            this.subMenus = subMenus;
        }
    }

    // --- Nested Class for SubMenu ---
    public static class SubMenuResponse {
        private String title;
        private String component;
        private String path;

        public SubMenuResponse(String title, String component, String path) {
            this.title = title;
            this.component = component;
            this.path = path;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}

