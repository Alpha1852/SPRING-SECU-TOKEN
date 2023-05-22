package com.example.application;

import com.example.domaine.Client;

import java.util.List;

public interface IClientService {

    void createClient(Client client);

    Client findById(Long id);

    Client findByEmail(String email);


    List<Client> findAllClient();
}
