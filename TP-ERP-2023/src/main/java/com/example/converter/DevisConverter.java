package com.example.converter;

import com.example.application.IComputeService;
import com.example.domaine.Client;
import com.example.domaine.Devis;
import com.example.domaine.LigneDevis;
import com.example.dto.DevisDetailsDto;
import com.example.dto.DevisMinDto;
import com.example.dto.LigneDevisDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevisConverter {

    @Autowired
    IComputeService computeService;
    
    @Autowired
    ClientConverter convertClient;

    public Devis convertDevisDetailsDtoToDevis(DevisDetailsDto dto){

        Devis devis=new Devis();
        devis.setDate(dto.getDate());
        Client client=convertClient.convertClientMinDtoToClient(dto.getClient());
        devis.setClient(client);
        List<LigneDevis> lignes=dto.getLignes()
                .stream()
                .map((ligneDto)-> convertLigneDtoToLigneDevis(ligneDto))
                .collect(Collectors.toList());
        devis.setLignes(lignes);
        return devis;
     }

    public DevisDetailsDto convertDevisToDevisDetailsDto(Devis devis){
        DevisDetailsDto devisDto=new DevisDetailsDto();
        devisDto.setDate(devis.getDate());
        devisDto.setClient(convertClient.convertClientMinDtoToClient(devis.getClient()));
        devisDto.setLignes(devis.getLignes()
                .stream()
                .map((ligne)->convertLigneDevisToLigneDto(ligne))
                .collect(Collectors.toList()));

        devisDto.setPrixTotalTTC(computeService.calculTotalDevis(devisDto.getLignes()));
        return devisDto;
    }

    public DevisMinDto convertDevisToDevisMinDto(Devis d){
       return null;
    }

    public LigneDevis convertLigneDtoToLigneDevis(LigneDevisDto ligneDto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(ligneDto,LigneDevis.class);
    }

    public LigneDevisDto convertLigneDevisToLigneDto(LigneDevis ligne){
        ModelMapper mapper=new ModelMapper();
        LigneDevisDto ldevisDto=mapper.map(ligne,LigneDevisDto.class);
        ldevisDto.setMontant(computeService.calculMontantLigne(ldevisDto));
        return ldevisDto;
    }

}
