/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spirit.login.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zizo
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a")
    , @NamedQuery(name = "Area.findById", query = "SELECT a FROM Area a WHERE a.id = :id")
    , @NamedQuery(name = "Area.findByNameEn", query = "SELECT a FROM Area a WHERE a.nameEn = :nameEn")
    , @NamedQuery(name = "Area.findByNameAr", query = "SELECT a FROM Area a WHERE a.nameAr = :nameAr")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name_en")
    private String nameEn;
    @Size(max = 45)
    @Column(name = "name_ar")
    private String nameAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public Area() {
    }

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, String nameEn) {
        this.id = id;
        this.nameEn = nameEn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ist.Entities.Area[ id=" + id + " ]";
    }
    
}
