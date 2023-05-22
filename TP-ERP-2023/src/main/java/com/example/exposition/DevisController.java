package com.example.exposition;

import com.example.application.IDevisService;
import com.example.converter.DevisConverter;
import com.example.domaine.Devis;
import com.example.dto.DevisDetailsDto;
import com.example.dto.DevisMinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DevisController {

    @Autowired
    IDevisService devisService;

    @Autowired
    DevisConverter converter;
    @PostMapping("/devis")
    public void create(@RequestBody  DevisDetailsDto dto){

        devisService.create(converter.convertDevisDetailsDtoToDevis(dto));
    }

    @GetMapping("/devis/{id}")
    public DevisDetailsDto findById(@PathVariable("id") Long id){
        Devis devis=devisService.findById(id);
        return converter.convertDevisToDevisDetailsDto(devis);
    }
}
