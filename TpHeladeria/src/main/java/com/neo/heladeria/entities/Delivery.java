/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo.heladeria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author laura.romerot
 */
@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByIdDelivery", query = "SELECT d FROM Delivery d WHERE d.idDelivery = :idDelivery"),
    @NamedQuery(name = "Delivery.findByName", query = "SELECT d FROM Delivery d WHERE d.name = :name"),
    @NamedQuery(name = "Delivery.findByLastname", query = "SELECT d FROM Delivery d WHERE d.lastname = :lastname"),
    @NamedQuery(name = "Delivery.findByPhone", query = "SELECT d FROM Delivery d WHERE d.phone = :phone")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_delivery")
    private Integer idDelivery;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryIdDelivery")
    @JsonIgnore
    private List<ListOrder> listOrderList;

    public Delivery() {
    }

    public Delivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Integer getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public List<ListOrder> getListOrderList() {
        return listOrderList;
    }

    public void setListOrderList(List<ListOrder> listOrderList) {
        this.listOrderList = listOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelivery != null ? idDelivery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.idDelivery == null && other.idDelivery != null) || (this.idDelivery != null && !this.idDelivery.equals(other.idDelivery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neo.heladeria.entities.Delivery[ idDelivery=" + idDelivery + " ]";
    }
    
}
