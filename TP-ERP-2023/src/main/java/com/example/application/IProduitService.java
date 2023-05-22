package com.example.application;

import com.example.domaine.Produit;
import com.example.dto.ProduitDetailsDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProduitService {

    void create(Produit p);
    Produit findById(Long id);

    List<Produit> findAll();

    List<Produit> findAll(Sort sort);
}
