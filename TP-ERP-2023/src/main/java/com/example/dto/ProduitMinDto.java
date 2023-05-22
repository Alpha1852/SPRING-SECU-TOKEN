package com.example.dto;

import java.math.BigDecimal;

public class ProduitMinDto {

    private Long id;
    private String nom;

    private String photoUrl;

    private BigDecimal prixHt;

    private BigDecimal prixTTC;

    public ProduitMinDto(Long id, String nom, String photoUrl, BigDecimal prixHt, BigDecimal prixTTC) {
        this.id = id;
        this.nom = nom;
        this.photoUrl = photoUrl;
        this.prixHt = prixHt;
        this.prixTTC = prixTTC;
    }

    public ProduitMinDto() {
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
}
