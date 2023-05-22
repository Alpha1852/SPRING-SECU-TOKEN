package com.example.converter;

import com.example.application.IComputeService;
import com.example.domaine.Produit;
import com.example.dto.ProduitDetailsDto;
import com.example.dto.ProduitMinDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitConverter {

    @Autowired
    IComputeService computeService;
    public  ProduitMinDto convertProduitEntityToProduitMinDto(Produit p){
        ProduitMinDto dto=new ProduitMinDto();
        dto.setId(p.getId());
        dto.setNom(p.getNom());
        dto.setPhotoUrl(p.getPhotoUrl());
        dto.setPrixHt(p.getPrixHt());
        dto.setPrixTTC(computeService.calculPrixTTC(p.getPrixHt()));

        //OU
       // ModelMapper mapper=new ModelMapper();
       // ProduitMinDto pDtoMapper=mapper.map(p,ProduitMinDto.class);
       // pDtoMapper.setPrixTTC();

      return dto;
    }

    public Produit convertProduitDetailsDtoToProduit(ProduitDetailsDto dto){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto,Produit.class);
    }
}
