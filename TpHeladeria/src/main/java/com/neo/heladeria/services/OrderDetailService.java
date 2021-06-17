/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.services;

import com.neo.heladeria.controllers.OrderDetailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura.romerot
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("orderdetail/")
public class OrderDetailService {
    
    @Autowired
    OrderDetailController orderdetailController;
    
     @PostMapping("newlistorder/{orderDescription}/{idIceCream}/{idListOrder}")
    public ResponseEntity newListOrder(@PathVariable String orderDescription,@PathVariable int idIceCream,@PathVariable int idListOrder){
    return ResponseEntity.ok(orderdetailController.createOrderDetail(orderDescription, idIceCream, idListOrder));
    }
    
    @GetMapping("allorderdetail")
    public ResponseEntity getListOrder(){
    return ResponseEntity.ok(orderdetailController.allOrderDetail());
    }
    
     @GetMapping("orderclient/{idOrderClient}")
     public ResponseEntity<?> getClientByPhone(@PathVariable Integer idOrderClient){
        return ResponseEntity.ok(orderdetailController.filterOrderByIdClient(idOrderClient));
    }
    
}
