package com.example.application;

import com.example.domaine.Client;
import com.example.domaine.RoleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    //Injection par constructeur
    IClientService clientService;
    public UserDetailServiceImpl(IClientService clientService){
        this.clientService=clientService;
    }

    //OU (Par attribut)
    //@Autowired
    //IClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client=clientService.findByEmail(username);

        List<GrantedAuthority> authorities=new ArrayList<>();
        client.getRoles().forEach((role) -> {
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getNom());
                    authorities.add(authority);
                   }
                );
        //OU
        /*List<GrantedAuthority> authorities=new ArrayList<>();
        for(RoleClient role:client.getRoles()){
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getNom());
            authorities.add(authority);
        }*/
        //OU
        /*List<GrantedAuthority> authorities=client.getRoles()
                .stream()
                .map(role ->  role.getNom())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());*/
        return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getPassword(), authorities);
    }
}
