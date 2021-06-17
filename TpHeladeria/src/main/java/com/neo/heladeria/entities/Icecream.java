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
@Table(name = "icecream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Icecream.findAll", query = "SELECT i FROM Icecream i"),
    @NamedQuery(name = "Icecream.findByIdIcecream", query = "SELECT i FROM Icecream i WHERE i.idIcecream = :idIcecream"),
    @NamedQuery(name = "Icecream.findByIcecreamName", query = "SELECT i FROM Icecream i WHERE i.icecreamName = :icecreamName"),
    @NamedQuery(name = "Icecream.findByIcecreamDescription", query = "SELECT i FROM Icecream i WHERE i.icecreamDescription = :icecreamDescription")})
public class Icecream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_icecream")
    private Integer idIcecream;
    @Column(name = "icecream_name")
    private String icecreamName;
    @Column(name = "icecream_description")
    private String icecreamDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "icecreamIdIcecream")
    @JsonIgnore
    private List<OrderDetail> orderDetailList;

    public Icecream() {
    }

    public Icecream(Integer idIcecream) {
        this.idIcecream = idIcecream;
    }

    public Integer getIdIcecream() {
        return idIcecream;
    }

    public void setIdIcecream(Integer idIcecream) {
        this.idIcecream = idIcecream;
    }

    public String getIcecreamName() {
        return icecreamName;
    }

    public void setIcecreamName(String icecreamName) {
        this.icecreamName = icecreamName;
    }

    public String getIcecreamDescription() {
        return icecreamDescription;
    }

    public void setIcecreamDescription(String icecreamDescription) {
        this.icecreamDescription = icecreamDescription;
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
        hash += (idIcecream != null ? idIcecream.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Icecream)) {
            return false;
        }
        Icecream other = (Icecream) object;
        if ((this.idIcecream == null && other.idIcecream != null) || (this.idIcecream != null && !this.idIcecream.equals(other.idIcecream))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neo.heladeria.entities.Icecream[ idIcecream=" + idIcecream + " ]";
    }
    
}
