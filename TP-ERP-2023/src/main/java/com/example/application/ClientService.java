package com.example.application;

import com.example.domaine.Client;
import com.example.infrastruture.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{

    @Autowired
    IClientRepository repository;
    
    
    
    @Override
    public void createClient(Client client) {
    		
    	if(client.getRoles().isEmpty()) {
    		throw new IllegalArgumentException("utilsateur sans role");
    	}
        repository.save(client);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> clientOptional=repository.findById(id);

        Client c = null;
        if(clientOptional.isPresent()){
            c=clientOptional.get();
            return c;
        }

        return null;

        //Ternaire
        //return clientOptional.isPresent() ? clientOptional.get() : null ;
    }

    @Override
    public Client findByEmail(String email) {

        return repository.findByEmail(email).get();
    }

    @Override
    public List<Client> findAllClient() {

        return repository.findAll();
    }
}
