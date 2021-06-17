/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.neo.heladeria.services;

import com.neo.heladeria.controllers.CashierController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura.romerot
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cashier/")
public class CashierService {
    
     @Autowired
     CashierController cashierController;
     
     @GetMapping("getcashier")
     public ResponseEntity getCashier(){
     return ResponseEntity.ok(cashierController.getCashier());
     }
     
     
     
     
}
