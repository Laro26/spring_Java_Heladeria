/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.repository;


import com.neo.heladeria.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author laura.romerot
 */
public interface DeliveryRepository extends JpaRepository<Delivery,Integer>{
    
}
