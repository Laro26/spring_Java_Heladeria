/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.services;

import com.neo.heladeria.controllers.ClientController;
import com.neo.heladeria.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura.romerot
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("client/")
public class ClientService {
    
    @Autowired
    ClientController clientController;
    
    //trae clientes
    @GetMapping("getclients")
    public ResponseEntity getClient(){
    return ResponseEntity.ok(clientController.getClients());
    }
    
    //crear un cliente
    @PostMapping("createclient")
    public ResponseEntity postClient(@RequestBody  Client client1){
    return ResponseEntity.ok(clientController.addClient(client1));
    }
    
    @GetMapping("{id}")
     public ResponseEntity<?> getClientByid(@PathVariable int id){
        return ResponseEntity.ok(clientController.filterClient(id));
    }
       @GetMapping("phone/{phone}")
     public ResponseEntity<?> getClientByPhone(@PathVariable String phone){
        return ResponseEntity.ok(clientController.filterClientPhone(phone));
    }
    //para buscar es con requestparam
}
