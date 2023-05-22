package com.example.infrastruture;

import com.example.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {

    @Query("SELECT c FROM Client c JOIN FETCH c.roles where c.email=:email")
    Optional<Client> findByEmail(String email);
}
