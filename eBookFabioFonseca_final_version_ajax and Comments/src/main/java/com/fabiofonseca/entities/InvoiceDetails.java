/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiofonseca.entities;

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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "invoice_details", catalog = "ebook", schema = "")
@NamedQueries({
    @NamedQuery(name = "InvoiceDetails.findAll", query = "SELECT i FROM InvoiceDetails i"),
    @NamedQuery(name = "InvoiceDetails.findById", query = "SELECT i FROM InvoiceDetails i WHERE i.id = :id"),
    @NamedQuery(name = "InvoiceDetails.findByIsbnNumber", query = "SELECT i FROM InvoiceDetails i WHERE i.isbnNumber = :isbnNumber"),
    @NamedQuery(name = "InvoiceDetails.findByPrice", query = "SELECT i FROM InvoiceDetails i WHERE i.price = :price")})
public class InvoiceDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ISBN_NUMBER")
    private Integer isbnNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @JoinColumn(name = "SALE_NUMBER", referencedColumnName = "SALE_NUMBER")
    @ManyToOne
    private Invoice saleNumber;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Integer isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Invoice saleNumber) {
        this.saleNumber = saleNumber;
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
        if (!(object instanceof InvoiceDetails)) {
            return false;
        }
        InvoiceDetails other = (InvoiceDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabiofonseca.entities.InvoiceDetails[ id=" + id + " ]";
    }
    
}
