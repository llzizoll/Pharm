/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spirit.login.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByNameEn", query = "SELECT p FROM Product p WHERE p.nameEn = :nameEn")
    , @NamedQuery(name = "Product.findByNameAr", query = "SELECT p FROM Product p WHERE p.nameAr = :nameAr")
    , @NamedQuery(name = "Product.findByPercentage", query = "SELECT p FROM Product p WHERE p.percentage = :percentage")
    , @NamedQuery(name = "Product.findByMainCompanyName", query = "SELECT p FROM Product p WHERE p.mainCompanyName = :mainCompanyName")
    , @NamedQuery(name = "Product.findByQAndQComp", query = "SELECT p FROM Product p WHERE p.qAndQComp = :qAndQComp")
    , @NamedQuery(name = "Product.findByDosageAndAdministration", query = "SELECT p FROM Product p WHERE p.dosageAndAdministration = :dosageAndAdministration")
    , @NamedQuery(name = "Product.findByForm", query = "SELECT p FROM Product p WHERE p.form = :form")
    , @NamedQuery(name = "Product.findByMedicalPrecautions", query = "SELECT p FROM Product p WHERE p.medicalPrecautions = :medicalPrecautions")
    , @NamedQuery(name = "Product.findByIndications", query = "SELECT p FROM Product p WHERE p.indications = :indications")
    , @NamedQuery(name = "Product.findByRemarks", query = "SELECT p FROM Product p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product.findByMainPrice", query = "SELECT p FROM Product p WHERE p.mainPrice = :mainPrice")
    , @NamedQuery(name = "Product.findByDiscountPrice", query = "SELECT p FROM Product p WHERE p.discountPrice = :discountPrice")
    , @NamedQuery(name = "Product.findByMethodOfPayment", query = "SELECT p FROM Product p WHERE p.methodOfPayment = :methodOfPayment")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name_en")
    private String nameEn;
    @Size(max = 200)
    @Column(name = "name_ar")
    private String nameAr;
    @Column(name = "percentage")
    private Short percentage;
    @Size(max = 255)
    @Column(name = "main_company_name")
    private String mainCompanyName;
    @Size(max = 255)
    @Column(name = "q_and_q_comp")
    private String qAndQComp;
    @Size(max = 255)
    @Column(name = "dosage_and_administration")
    private String dosageAndAdministration;
    @Size(max = 255)
    @Column(name = "form")
    private String form;
    @Size(max = 255)
    @Column(name = "medical_precautions")
    private String medicalPrecautions;
    @Size(max = 255)
    @Column(name = "indications")
    private String indications;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "main_price")
    private Long mainPrice;
    @Column(name = "discount_price")
    private Long discountPrice;
    @Size(max = 45)
    @Column(name = "method_of_payment")
    private String methodOfPayment;
    @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY)
    private List<Order1> order1List;
    @JoinTable(name = "stock_has_product", joinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "stock_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Stock> stockList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
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

    public Short getPercentage() {
        return percentage;
    }

    public void setPercentage(Short percentage) {
        this.percentage = percentage;
    }

    public String getMainCompanyName() {
        return mainCompanyName;
    }

    public void setMainCompanyName(String mainCompanyName) {
        this.mainCompanyName = mainCompanyName;
    }

    public String getQAndQComp() {
        return qAndQComp;
    }

    public void setQAndQComp(String qAndQComp) {
        this.qAndQComp = qAndQComp;
    }

    public String getDosageAndAdministration() {
        return dosageAndAdministration;
    }

    public void setDosageAndAdministration(String dosageAndAdministration) {
        this.dosageAndAdministration = dosageAndAdministration;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMedicalPrecautions() {
        return medicalPrecautions;
    }

    public void setMedicalPrecautions(String medicalPrecautions) {
        this.medicalPrecautions = medicalPrecautions;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getMainPrice() {
        return mainPrice;
    }

    public void setMainPrice(Long mainPrice) {
        this.mainPrice = mainPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    @XmlTransient
    public List<Order1> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order1> order1List) {
        this.order1List = order1List;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ist.Entities.Product[ id=" + id + " ]";
    }
    
}
