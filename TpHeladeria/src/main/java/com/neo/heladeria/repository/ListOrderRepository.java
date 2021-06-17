/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.repository;

import com.neo.heladeria.entities.ListOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author laura.romerot
 */
public interface ListOrderRepository extends JpaRepository<ListOrder,Integer> {
    
   
}
