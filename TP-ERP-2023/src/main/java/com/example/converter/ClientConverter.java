package com.example.converter;

import com.example.domaine.Adresse;
import com.example.domaine.Client;
import com.example.dto.AdresseDto;
import com.example.dto.ClientDetailDto;
import com.example.dto.ClientMinDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientConverter {
	
	@Autowired
    BCryptPasswordEncoder passwordEncoder;

    //Avec ModelMapper
    public  Client convertClientDetailsDtoToClientEntity(ClientDetailDto dto){
    	
    	String encryptedPassword=passwordEncoder.encode(dto.getPassword());
    	dto.setPassword(encryptedPassword);
        ModelMapper mapper=new ModelMapper();

       // TypeMap<ClientDetailDto, Client> propertyMapper = mapper.createTypeMap(ClientDetailDto.class, Client.class);
        //propertyMapper.addMapping(ClientDetailDto::getAdresseDto,Client::setAdresse);
        
        return mapper.map(dto,Client.class);
    }

   // public static ClientDetailDto convertClientEntityToClientDetailsDto(Client entity){
     //   ModelMapper mapper=new ModelMapper();
      //  return mapper.map(entity,ClientDetailDto.class);
   // }

    public  ClientDetailDto convertClientEntityToClientDetailsDto(Client client){

        ClientDetailDto dto=new ClientDetailDto();
        AdresseDto adrDto=new AdresseDto();

        //La partie client
        Optional.ofNullable(client).ifPresent((c)-> {
                    dto.setId(c.getId());
                    dto.setAvatar(c.getAvatar());
                    dto.setPrenom(c.getPrenom());
                    dto.setNom(c.getNom());
                    dto.setDateNaissance(c.getDateNaissance());
                }

            );

        //Partie adresse
        Optional.ofNullable(client.getAdresse()).ifPresent( (adr) -> {
            adrDto.setId(adr.getId());
            adrDto.setRue(adr.getRue());
            adrDto.setCodePostal(adr.getCodePostal());
            adrDto.setVille(adr.getVille());
            dto.setAdresseDto(adrDto);
          }
        );

        return dto;
    }

    //Sans ModelMapper
    public  Client convertNoModelMapperClientDetailsDtoToClientEntity(ClientDetailDto dto){
        Client client=new Client();
        client.setAvatar(dto.getAvatar());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setDateNaissance(dto.getDateNaissance());
        client.setAdresse(convertAdressDtoToAdressEntity(dto.getAdresseDto()));
        return client;
    }

    public  Client convertClientMinDtoToClient(ClientMinDto dto){
        Client client=new Client();
        client.setAvatar(dto.getAvatar());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setAdresse(convertAdressDtoToAdressEntity(dto.getAdresseDto()));

        return client;
    }

    public  ClientMinDto convertClientMinDtoToClient(Client client){
        ClientMinDto clientMinDto=new ClientMinDto();
        clientMinDto.setAvatar(client.getAvatar());
        clientMinDto.setNom(client.getNom());
        clientMinDto.setPrenom(client.getPrenom());
        clientMinDto.setAdresseDto(convertAdressEntityToAdressDto(client.getAdresse()));

        return clientMinDto;
    }

    public  Adresse convertAdressDtoToAdressEntity(AdresseDto adresseDto){
        Adresse adresse=new Adresse();
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setRue(adresseDto.getRue());
        adresse.setVille(adresseDto.getVille());
        return adresse;
    }

    public  AdresseDto convertAdressEntityToAdressDto(Adresse adresse){
        ModelMapper mapper=new ModelMapper();
        return mapper.map(adresse,AdresseDto.class);
    }
}
