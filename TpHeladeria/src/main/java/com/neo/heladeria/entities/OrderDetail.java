/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laura.romerot
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByIdOrderDetail", query = "SELECT o FROM OrderDetail o WHERE o.idOrderDetail = :idOrderDetail"),
    @NamedQuery(name = "OrderDetail.findByOrderDescription", query = "SELECT o FROM OrderDetail o WHERE o.orderDescription = :orderDescription")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_detail")
    private Integer idOrderDetail;
    @Column(name = "order_description")
    private String orderDescription;
    @JoinColumn(name = "icecream_id_icecream", referencedColumnName = "id_icecream")
    @ManyToOne(optional = false)
    private Icecream icecreamIdIcecream;
    @JoinColumn(name = "list_order_id_list_order", referencedColumnName = "id_list_order")
    @ManyToOne(optional = false)
    @JsonIgnore
    private ListOrder listOrderIdListOrder;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Icecream getIcecreamIdIcecream() {
        return icecreamIdIcecream;
    }

    public void setIcecreamIdIcecream(Icecream icecreamIdIcecream) {
        this.icecreamIdIcecream = icecreamIdIcecream;
    }

    public ListOrder getListOrderIdListOrder() {
        return listOrderIdListOrder;
    }

    public void setListOrderIdListOrder(ListOrder listOrderIdListOrder) {
        this.listOrderIdListOrder = listOrderIdListOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderDetail != null ? idOrderDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.idOrderDetail == null && other.idOrderDetail != null) || (this.idOrderDetail != null && !this.idOrderDetail.equals(other.idOrderDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neo.heladeria.entities.OrderDetail[ idOrderDetail=" + idOrderDetail + " ]";
    }
    
}
