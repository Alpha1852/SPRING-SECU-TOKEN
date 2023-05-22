package com.example.domaine;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String avatar;

    private String prenom;

    private String password;

    @ManyToMany
    private List<RoleClient> roles;

    private LocalDate dateNaissance;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    private String email;

    public Client(String nom, String avatar, String prenom, String password, List<RoleClient> roles, LocalDate dateNaissance, Adresse adresse, String email) {
        this.nom = nom;
        this.avatar = avatar;
        this.prenom = prenom;
        this.password = password;
        this.roles = roles;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.email = email;
    }

    public Client() {
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleClient> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleClient> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
