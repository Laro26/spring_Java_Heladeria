/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.services;

import com.neo.heladeria.controllers.DeliveryController;
import com.neo.heladeria.entities.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("delivery/")
public class DeliveryService {
    @Autowired
    DeliveryController deliveryController;
    
    //trae 
    @GetMapping("getdelivery")
    public ResponseEntity getDelivery(){
    return ResponseEntity.ok(deliveryController.getDelivery());
    }
    
    //crear 
    @PostMapping("createdelivery")
    public ResponseEntity postClient(@RequestBody  Delivery delivery1){
    return ResponseEntity.ok(deliveryController.addDelivery(delivery1));
    }
    
}
