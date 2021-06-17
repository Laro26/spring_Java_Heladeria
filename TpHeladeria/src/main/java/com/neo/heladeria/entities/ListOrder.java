/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author laura.romerot
 */
@Entity
@Table(name = "list_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListOrder.findAll", query = "SELECT l FROM ListOrder l"),
    @NamedQuery(name = "ListOrder.findByIdListOrder", query = "SELECT l FROM ListOrder l WHERE l.idListOrder = :idListOrder"),
    @NamedQuery(name = "ListOrder.findByNewDateListOrder", query = "SELECT l FROM ListOrder l WHERE l.newDateListOrder = :newDateListOrder")})
public class ListOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_list_order")
    private Integer idListOrder;
    @Column(name = "new_date_list_order")
    @Temporal(TemporalType.DATE)
    private Date newDateListOrder;
    @JoinColumn(name = "cashier_id_cashier", referencedColumnName = "id_cashier")
    @ManyToOne(optional = false)
    private Cashier cashierIdCashier;
    @JoinColumn(name = "client_id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client clientIdClient;
    @JoinColumn(name = "delivery_id_delivery", referencedColumnName = "id_delivery")
    @ManyToOne(optional = false)
    private Delivery deliveryIdDelivery;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listOrderIdListOrder")
    private List<OrderDetail> orderDetailList;

    public ListOrder() {
    }

    public ListOrder(Integer idListOrder) {
        this.idListOrder = idListOrder;
    }

    public Integer getIdListOrder() {
        return idListOrder;
    }

    public void setIdListOrder(Integer idListOrder) {
        this.idListOrder = idListOrder;
    }

    public Date getNewDateListOrder() {
        return newDateListOrder;
    }

    public void setNewDateListOrder(Date newDateListOrder) {
        this.newDateListOrder = newDateListOrder;
    }

    public Cashier getCashierIdCashier() {
        return cashierIdCashier;
    }

    public void setCashierIdCashier(Cashier cashierIdCashier) {
        this.cashierIdCashier = cashierIdCashier;
    }

    public Client getClientIdClient() {
        return clientIdClient;
    }

    public void setClientIdClient(Client clientIdClient) {
        this.clientIdClient = clientIdClient;
    }

    public Delivery getDeliveryIdDelivery() {
        return deliveryIdDelivery;
    }

    public void setDeliveryIdDelivery(Delivery deliveryIdDelivery) {
        this.deliveryIdDelivery = deliveryIdDelivery;
    }

    @XmlTransient
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListOrder != null ? idListOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListOrder)) {
            return false;
        }
        ListOrder other = (ListOrder) object;
        if ((this.idListOrder == null && other.idListOrder != null) || (this.idListOrder != null && !this.idListOrder.equals(other.idListOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neo.heladeria.entities.ListOrder[ idListOrder=" + idListOrder + " ]";
    }
    
}
