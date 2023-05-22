package com.example.infrastruture;

import com.example.domaine.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitRepository extends JpaRepository<Produit,Long> { }
