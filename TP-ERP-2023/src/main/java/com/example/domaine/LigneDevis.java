package com.example.domaine;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="lignedevis")
public class LigneDevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade =CascadeType.MERGE )
    private Produit produit;

    private int qte;

    private BigDecimal remise;

    public LigneDevis(Produit produit, int qte, BigDecimal remise) {
        this.produit = produit;
        this.qte = qte;
        this.remise = remise;
    }

    public LigneDevis() {

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
}
