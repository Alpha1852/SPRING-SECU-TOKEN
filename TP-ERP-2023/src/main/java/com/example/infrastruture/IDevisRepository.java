package com.example.infrastruture;

import com.example.domaine.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDevisRepository extends JpaRepository<Devis,Long> { }
