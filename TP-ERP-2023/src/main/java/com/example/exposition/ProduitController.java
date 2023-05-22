package com.example.exposition;

import com.example.application.IProduitService;
import com.example.converter.ProduitConverter;
import com.example.domaine.Produit;
import com.example.dto.ProduitDetailsDto;
import com.example.dto.ProduitMinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProduitController {

    @Autowired
    IProduitService service;

    @Autowired
    ProduitConverter converter;

    @PostMapping("/produit")
    void create(@RequestBody  ProduitDetailsDto p){
        service.create(converter.convertProduitDetailsDtoToProduit(p));
    }
    ProduitDetailsDto findById(Long id){
             return null;
    }

    List<ProduitMinDto> findAll(){
          return null;
    }

    @GetMapping("/produit/all/{property}/{order}")
    List<ProduitMinDto> findAllSort(@PathVariable("property") String property, @PathVariable("order") String order){
        Sort s=null;
        if(order.equals("D")){
            s=Sort.by(property).descending();
        } else if (order.equals("A")) {
            s=Sort.by(property).ascending();
        }

     List<Produit> sortedList= service.findAll(s);
         // ou (la même chose)
        // List<Produit> sortedList=service.findAll(order.equals("D") ? Sort.by(property).descending() :Sort.by(property).ascending());


      List<ProduitMinDto>  listDto=sortedList
                .stream()
                .map((produit -> converter.convertProduitEntityToProduitMinDto(produit)))
                .collect(Collectors.toList());

        // ou (la même chose)
        //List<ProduitMinDto>  listDto2=new ArrayList<>();
        //for(Produit pr:sortedList){
        //   ProduitMinDto pmdto= converter.convertProduitEntityToProduitMinDto(pr);
        //    listDto2.add(pmdto);
        //}

        return listDto;
    }
}
