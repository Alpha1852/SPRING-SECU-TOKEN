package com.example.dto;

import com.example.domaine.Client;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DevisMinDto {
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private ClientMinDto client;

    private BigDecimal prixTotalTTC;

    public DevisMinDto(Long id, LocalDate date, ClientMinDto client,BigDecimal prixTotalTTC) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.prixTotalTTC = prixTotalTTC;
    }

    public DevisMinDto() {
        date=LocalDate.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClientMinDto getClient() {
        return client;
    }

    public void setClient(ClientMinDto client) {
        this.client = client;
    }

    public BigDecimal getPrixTotalTTC() {
        return prixTotalTTC;
    }

    public void setPrixTotalTTC(BigDecimal prixTotalTTC) {
        this.prixTotalTTC = prixTotalTTC;
    }
}
