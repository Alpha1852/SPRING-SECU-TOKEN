package com.example.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class ClientDetailDto {


    private Long id;

    private String nom;

    private String avatar;

    private String prenom;
    
    private String password;
    
    private String email;
    
    private List<RoleDto> roles;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateNaissance;

    @JsonProperty("adresse")
    private AdresseDto adresseDto;

    

    public ClientDetailDto(Long id, String nom, String avatar, String prenom, String password, String email,
			List<RoleDto> roles, LocalDate dateNaissance, AdresseDto adresseDto) {
		this.id = id;
		this.nom = nom;
		this.avatar = avatar;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.dateNaissance = dateNaissance;
		this.adresseDto = adresseDto;
	}

	public ClientDetailDto() {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public AdresseDto getAdresseDto() {
        return adresseDto;
    }

    public void setAdresseDto(AdresseDto adresseDto) {
        this.adresseDto = adresseDto;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
    
    
}
