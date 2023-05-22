package com.example.dto;

import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;

public class ProduitDetailsDto {

    private Long id;

    private String nom;

    private String photoUrl;

    private BigDecimal prixHt;

    private BigDecimal prixTTC;

    private String description;

    public ProduitDetailsDto(Long id, String nom, String photoUrl, BigDecimal prixHt, String description,BigDecimal prixTTC) {
        this.id = id;
        this.nom = nom;
        this.photoUrl = photoUrl;
        this.prixHt = prixHt;
        this.description = description;
        this.prixTTC=prixTTC;
    }

    public ProduitDetailsDto() {
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public BigDecimal getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(BigDecimal prixHt) {
        this.prixHt = prixHt;
    }

    public BigDecimal getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(BigDecimal prixTTC) {
        this.prixTTC = prixTTC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
