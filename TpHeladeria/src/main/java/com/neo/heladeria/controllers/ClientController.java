/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.controllers;

import com.neo.heladeria.entities.Client;
import com.neo.heladeria.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laura.romerot
 */
@Controller
public class ClientController {
    
    
    @Autowired
    ClientRepository clientRepository;
    
    @Transactional(readOnly = true)
    public List<Client> getClients(){
        return clientRepository.findAll();
}
      public String addClient(Client client1){
      try{
          clientRepository.save(client1);
          return "Add client succesfull";
      }  catch(Exception e){
      return("Error cant add client"+ e.getMessage());
      }
      
    }
      public Client filterClient (Integer idClient){
         return clientRepository.findById(idClient).orElse(null);
      }
    public Client filterClientPhone(String phoneClient){
         return clientRepository.findByPhoneClient(phoneClient);
      }
}
