/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.services;

import com.neo.heladeria.controllers.IceCreamController;
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
@RequestMapping("icecream/")
public class IceCreamService {
    
    @Autowired
    IceCreamController icecreamController;
    
    @GetMapping("geticecream")
    public ResponseEntity allIcecream(){
    return ResponseEntity.ok(icecreamController.getIcecream());
    }
    
}
