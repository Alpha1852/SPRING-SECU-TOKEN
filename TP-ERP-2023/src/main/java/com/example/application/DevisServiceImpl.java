package com.example.application;

import com.example.domaine.Devis;
import com.example.infrastruture.IDevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevisServiceImpl implements IDevisService {

    @Autowired
    IDevisRepository repository;
    @Override
    public void create(Devis d) {repository.save(d);}

    @Override
    public List<Devis> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Devis> findAll(Sort s) {
        return repository.findAll(s);
    }

    @Override
    public Devis findById(Long id) {
        return repository.findById(id).get();
    }
}
