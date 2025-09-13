package com.example.UserService.Jwt;

import com.example.UserService.Model.*;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {
    private  User user;
    private String username;
    private String password;
    private List<String>roles;
    private List<String>permissions;
    private Set<userMenu> menus;

    public CustomUserDetail(User user) {
        this.user=user;
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.roles=user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        this.permissions=user.getRoles().stream().flatMap(role->role.getPermissions().stream())
                .map(Permission::getName).collect(Collectors.toList());
        this.menus=user.getUserMenus();
    }

    public void CustomUserDetailService(User user){
       this.user=user;
   }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        roles.forEach(role->authorities.add(new SimpleGrantedAuthority("Role_ " +role)));
        permissions.forEach(perm->authorities.add(new SimpleGrantedAuthority("perm_ "+perm)));
        return  authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    public List<String> getPermissions(){
        return  permissions;
    }
    public List<String> getRoles(){
        return  roles;
    }
    public Set<userMenu> getMenus(){
        return  menus;
    }
}
