package com.example.application;

import com.example.domaine.Devis;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IDevisService {

    void create(Devis d);

    List<Devis> findAll();

    List<Devis> findAll(Sort s);

    Devis findById(Long id);
}
