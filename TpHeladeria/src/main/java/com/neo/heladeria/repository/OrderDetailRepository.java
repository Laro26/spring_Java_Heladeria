/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.repository;

import com.neo.heladeria.entities.OrderDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author laura.romerot
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer>{
    
     @Query("Select od from OrderDetail od where od.listOrderIdListOrder.idListOrder in"
             + " (Select lo.idListOrder from ListOrder lo where lo.clientIdClient.idClient = ?1)")
    public List<OrderDetail> findOrder(Integer idClient);
}
