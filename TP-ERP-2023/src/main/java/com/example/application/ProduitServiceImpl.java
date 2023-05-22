package com.example.application;

import com.example.domaine.Produit;
import com.example.infrastruture.IProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    IProduitRepository repository;
    @Override
    public void create(Produit p) {repository.save(p);}

    @Override
    public Produit findById(Long id) {return repository.findById(id).get();}

    @Override
    public List<Produit> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Produit> findAll(Sort sort) {
        return repository.findAll(sort);
    }
}
