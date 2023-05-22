package com.example.domaine;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateDevis")
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LigneDevis> lignes;

    public Devis(LocalDate date, Client client, List<LigneDevis> lignes) {
        this.date = date;
        this.client = client;
        this.lignes = lignes;
    }

    public Devis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneDevis> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneDevis> lignes) {
        this.lignes = lignes;
    }
}
