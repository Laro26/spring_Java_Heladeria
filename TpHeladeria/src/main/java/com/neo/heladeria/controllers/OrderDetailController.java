/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.controllers;

import com.neo.heladeria.entities.Icecream;
import com.neo.heladeria.entities.ListOrder;
import com.neo.heladeria.entities.OrderDetail;
import com.neo.heladeria.repository.IcecreamRepository;
import com.neo.heladeria.repository.ListOrderRepository;
import com.neo.heladeria.repository.OrderDetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author laura.romerot
 */

@Controller
public class OrderDetailController {
    
    @Autowired
    OrderDetailRepository orderdetailRepository;
    @Autowired
    IcecreamRepository icecreamRepository;
    @Autowired
    ListOrderRepository listorderRepository;
    
    
    public OrderDetail createOrderDetail(String orderDescription, int idIceCream, int idListOrder) {
        Icecream icecream = icecreamRepository.findById(idIceCream).orElse(null);
        ListOrder listorder = listorderRepository.findById(idListOrder).orElse(null);
        if ( icecream != null && listorder != null) {
            OrderDetail detail = new OrderDetail();
           detail.setOrderDescription(orderDescription);
           detail.setIcecreamIdIcecream(icecream);
           detail.setListOrderIdListOrder(listorder);
           
            return orderdetailRepository.save(detail);
        }
        return null;
    }
    
    public List<OrderDetail> allOrderDetail(){
    return orderdetailRepository.findAll();
    }

    public OrderDetail filterOrderDetail (Integer idOrderDetail){
         return orderdetailRepository.findById(idOrderDetail).orElse(null);
      }
    public List<OrderDetail> filterOrderByIdClient (Integer idOrderClient){
    return orderdetailRepository.findOrder(idOrderClient);
    }
}
