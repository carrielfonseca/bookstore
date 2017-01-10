/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiofonseca.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "invoice", catalog = "ebook", schema = "")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findBySaleNumber", query = "SELECT i FROM Invoice i WHERE i.saleNumber = :saleNumber"),
    @NamedQuery(name = "Invoice.findByDateOfSale", query = "SELECT i FROM Invoice i WHERE i.dateOfSale = :dateOfSale"),
    @NamedQuery(name = "Invoice.findByTotalNetValue", query = "SELECT i FROM Invoice i WHERE i.totalNetValue = :totalNetValue"),
    @NamedQuery(name = "Invoice.findByGst", query = "SELECT i FROM Invoice i WHERE i.gst = :gst"),
    @NamedQuery(name = "Invoice.findByTotalGrossValue", query = "SELECT i FROM Invoice i WHERE i.totalGrossValue = :totalGrossValue")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SALE_NUMBER")
    private Integer saleNumber;
    @Column(name = "DATE_OF_SALE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSale;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_NET_VALUE")
    private Double totalNetValue;
    @Column(name = "GST")
    private Double gst;
    @Column(name = "TOTAL_GROSS_VALUE")
    private Double totalGrossValue;
    @OneToMany(mappedBy = "saleNumber")
    private List<InvoiceDetails> invoiceDetailsList;
    @JoinColumn(name = "CLIENT_NUMBER", referencedColumnName = "CLIENT_NUMBER")
    @ManyToOne
    private Clients clientNumber;

    public Invoice() {
    }

    public Invoice(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Double getTotalNetValue() {
        return totalNetValue;
    }

    public void setTotalNetValue(Double totalNetValue) {
        this.totalNetValue = totalNetValue;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getTotalGrossValue() {
        return totalGrossValue;
    }

    public void setTotalGrossValue(Double totalGrossValue) {
        this.totalGrossValue = totalGrossValue;
    }

    public List<InvoiceDetails> getInvoiceDetailsList() {
        return invoiceDetailsList;
    }

    public void setInvoiceDetailsList(List<InvoiceDetails> invoiceDetailsList) {
        this.invoiceDetailsList = invoiceDetailsList;
    }

    public Clients getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(Clients clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleNumber != null ? saleNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.saleNumber == null && other.saleNumber != null) || (this.saleNumber != null && !this.saleNumber.equals(other.saleNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabiofonseca.entities.Invoice[ saleNumber=" + saleNumber + " ]";
    }
    
}
