/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.repository;

import com.neo.heladeria.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author laura.romerot
 */
public interface ClientRepository extends JpaRepository<Client,Integer>{
    
    @Query("Select c from Client c where c.phone = ?1")
    public Client findByPhoneClient(String phone);
    
}
