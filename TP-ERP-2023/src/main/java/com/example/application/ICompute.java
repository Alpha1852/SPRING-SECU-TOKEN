package com.example.application;

import com.example.dto.LigneDevisDto;

import java.math.BigDecimal;
import java.util.List;

public interface ICompute {

    BigDecimal calculPrixTTC(BigDecimal prixHT);

    BigDecimal calculTotalDevis(List<LigneDevisDto> ligneDto);

    BigDecimal calculMontantLigne(LigneDevisDto ligne);
}
