package com.example.dto;

import java.util.List;

public class UtilisateurDto {

    private String username;
    private String password;

    List<RoleDto> roles;

    public UtilisateurDto(String username, String password, List<RoleDto> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UtilisateurDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
