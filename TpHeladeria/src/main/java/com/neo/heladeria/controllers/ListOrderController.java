/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.controllers;

import com.neo.heladeria.entities.Cashier;
import com.neo.heladeria.entities.Client;
import com.neo.heladeria.entities.Delivery;
import com.neo.heladeria.entities.ListOrder;
import com.neo.heladeria.repository.CashierRepository;
import com.neo.heladeria.repository.ClientRepository;
import com.neo.heladeria.repository.DeliveryRepository;
import com.neo.heladeria.repository.ListOrderRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author laura.romerot
 */
@Controller
public class ListOrderController {

    @Autowired
    ListOrderRepository listorderRepository;
    
    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    DeliveryRepository deliveryRepository;
    
    @Autowired
    CashierRepository cashierRepository;

    public ListOrder createListOrder(int idClient, int idDelivery, int idCashier) {
        Client client = clientRepository.findById(idClient).orElse(null);
        Delivery delivery = deliveryRepository.findById(idDelivery).orElse(null);
        Cashier cashier = cashierRepository.findById(idCashier).orElse(null);
        if (client != null && delivery != null && cashier != null) {
            ListOrder list = new ListOrder();
            list.setDeliveryIdDelivery(delivery);
            list.setCashierIdCashier(cashier);
            list.setClientIdClient(client);
            return listorderRepository.save(list);
        }
        return null;
    }
    
    public List<ListOrder> allListOrder(){
    return listorderRepository.findAll();
    }

}
