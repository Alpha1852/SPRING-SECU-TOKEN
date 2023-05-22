package com.example.exposition;

import com.example.application.IClientService;
import com.example.converter.ClientConverter;
import com.example.domaine.Client;
import com.example.dto.ClientDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    IClientService service;
    
    @Autowired
    ClientConverter convert;
    
    @PostMapping("/client")
    public void createClient(@RequestBody ClientDetailDto dto){
          Client client= convert.convertClientDetailsDtoToClientEntity(dto);
          System.out.println(client.getAdresse().getRue()+", "+client.getNom());
          service.createClient(client);
         //Client clientNoModelMapper=ClientConverter.convertNoModelMapperClientDetailsDtoToClientEntity(dto);
         //System.out.println(clientNoModelMapper.getAdresse().getRue()+", "+clientNoModelMapper.getNom());
    }

   @GetMapping("/client/{id}")
    public ClientDetailDto findById(@PathVariable("id") Long id){
        Client client=service.findById(id);
        return convert.convertClientEntityToClientDetailsDto(client);
   }

   @GetMapping("/client/clients")
    public List<ClientDetailDto> findAllClient(){
        List<Client> listclient = service.findAllClient();
        List<ClientDetailDto> listDetailDto = new ArrayList<>();
       for(Client client:listclient){

           listDetailDto.add(convert.convertClientEntityToClientDetailsDto(client));

       }
        return listDetailDto;
   }



}
