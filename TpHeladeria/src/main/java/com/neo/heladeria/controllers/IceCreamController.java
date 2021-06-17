/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.controllers;

import com.neo.heladeria.entities.Icecream;
import com.neo.heladeria.repository.IcecreamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laura.romerot
 */
@Controller
public class IceCreamController {
    @Autowired
    IcecreamRepository icecreamRepository;
    
    @Transactional(readOnly = true)    
    public List<Icecream> getIcecream(){
        return icecreamRepository.findAll();
    }
}
