package com.example.dto;

public class RoleDto {
	
	private Long id;

    private String nom;

    public RoleDto(String nom) {
        this.nom = nom;
    }
    
    public RoleDto() {
    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
