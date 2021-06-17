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
@Table(name = "cashier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cashier.findAll", query = "SELECT c FROM Cashier c"),
    @NamedQuery(name = "Cashier.findByIdCashier", query = "SELECT c FROM Cashier c WHERE c.idCashier = :idCashier"),
    @NamedQuery(name = "Cashier.findByName", query = "SELECT c FROM Cashier c WHERE c.name = :name"),
    @NamedQuery(name = "Cashier.findByLastame", query = "SELECT c FROM Cashier c WHERE c.lastame = :lastame"),
    @NamedQuery(name = "Cashier.findByLimitCashier", query = "SELECT c FROM Cashier c WHERE c.limitCashier = :limitCashier")})
public class Cashier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cashier")
    private Integer idCashier;
    @Column(name = "name")
    private String name;
    @Column(name = "lastame")
    private String lastame;
    @Column(name = "limit_cashier")
    private String limitCashier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashierIdCashier")
    @JsonIgnore
    private List<ListOrder> listOrderList;

    public Cashier() {
    }

    public Cashier(Integer idCashier) {
        this.idCashier = idCashier;
    }

    public Integer getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(Integer idCashier) {
        this.idCashier = idCashier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastame() {
        return lastame;
    }

    public void setLastame(String lastame) {
        this.lastame = lastame;
    }

    public String getLimitCashier() {
        return limitCashier;
    }

    public void setLimitCashier(String limitCashier) {
        this.limitCashier = limitCashier;
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
        hash += (idCashier != null ? idCashier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cashier)) {
            return false;
        }
        Cashier other = (Cashier) object;
        if ((this.idCashier == null && other.idCashier != null) || (this.idCashier != null && !this.idCashier.equals(other.idCashier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.neo.heladeria.entities.Cashier[ idCashier=" + idCashier + " ]";
    }
    
}
