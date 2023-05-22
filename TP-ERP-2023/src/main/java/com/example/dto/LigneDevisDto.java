package com.example.dto;

import com.example.domaine.Produit;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class LigneDevisDto {

    private Long id;

    private Produit produit;

    private int qte;

    private BigDecimal remise;

    private BigDecimal montant;

    public LigneDevisDto(Long id, Produit produit, int qte, BigDecimal remise,BigDecimal montant) {
        this.id = id;
        this.produit = produit;
        this.qte = qte;
        this.remise = remise;
        this.montant = montant;
    }

    public LigneDevisDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
