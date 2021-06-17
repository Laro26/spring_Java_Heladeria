/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.controllers;

import com.neo.heladeria.entities.Delivery;
import com.neo.heladeria.repository.DeliveryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laura.romerot
 */
@Controller
public class DeliveryController {
    
     @Autowired
     DeliveryRepository deliveryRepository;
     
     @Transactional(readOnly = true)
     public List<Delivery> getDelivery(){
     return deliveryRepository.findAll();
     }
     
     public String addDelivery(Delivery delivery1){
      try{
          deliveryRepository.save(delivery1);
          return "Add delivery succesfull";
      }  catch(Exception e){
      return("Error cant add delivery"+ e.getMessage());
      }
      
    }
}
