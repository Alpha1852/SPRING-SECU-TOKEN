package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientMinDto {

    private Long id;
    private String nom;

    private String avatar;

    private String prenom;

    @JsonProperty("adresse")
    private AdresseDto adresseDto;

    public ClientMinDto(Long id, String nom, String avatar, String prenom, AdresseDto adresseDto) {
        this.id = id;
        this.nom = nom;
        this.avatar = avatar;
        this.prenom = prenom;
        this.adresseDto = adresseDto;
    }

    public ClientMinDto() {
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

    public AdresseDto getAdresseDto() {
        return adresseDto;
    }

    public void setAdresseDto(AdresseDto adresseDto) {
        this.adresseDto = adresseDto;
    }
}
