/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.services;

import com.neo.heladeria.controllers.ListOrderController;
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
@RequestMapping("listorder/")
public class ListOrderService {
    
    @Autowired
    ListOrderController listorderController;
    
    @PostMapping("neworderdetail/{idCashier}/{idDelivery}/{idClient}")
    public ResponseEntity newOrderDetail(@PathVariable int idCashier,@PathVariable int idDelivery,@PathVariable int idClient){
    return ResponseEntity.ok(listorderController.createListOrder( idClient, idDelivery, idCashier));
    }
    
    @GetMapping("alllistorder/")
    public ResponseEntity getOrderDetail(){
    return ResponseEntity.ok(listorderController.allListOrder());
    }
    
    
}
