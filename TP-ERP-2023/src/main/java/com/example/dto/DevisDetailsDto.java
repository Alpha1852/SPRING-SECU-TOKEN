package com.example.dto;

import com.example.domaine.Client;
import com.example.domaine.LigneDevis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class DevisDetailsDto extends DevisMinDto{

    private List<LigneDevisDto> lignes;

    public DevisDetailsDto(List<LigneDevisDto> lignes) {
        super();
        this.lignes = lignes;
    }

    public DevisDetailsDto() {
        super();
    }

    public List<LigneDevisDto> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneDevisDto> lignes) {
        this.lignes = lignes;
    }
}
