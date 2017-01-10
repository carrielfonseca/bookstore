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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "book_inventory", catalog = "ebook", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookInventory.findAll", query = "SELECT b FROM BookInventory b"),
    @NamedQuery(name = "BookInventory.findByIsbnNumber", query = "SELECT b FROM BookInventory b WHERE b.isbnNumber = :isbnNumber"),
    @NamedQuery(name = "BookInventory.findByTitle", query = "SELECT b FROM BookInventory b WHERE b.title = :title"),
    @NamedQuery(name = "BookInventory.findByAuthor", query = "SELECT b FROM BookInventory b WHERE b.author = :author"),
    @NamedQuery(name = "BookInventory.findByPublisher", query = "SELECT b FROM BookInventory b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "BookInventory.findByNumberOfPages", query = "SELECT b FROM BookInventory b WHERE b.numberOfPages = :numberOfPages"),
    @NamedQuery(name = "BookInventory.findByGenre", query = "SELECT b FROM BookInventory b WHERE b.genre = :genre"),
    @NamedQuery(name = "BookInventory.findByImage", query = "SELECT b FROM BookInventory b WHERE b.image = :image"),
    @NamedQuery(name = "BookInventory.findByWholeSalePrice", query = "SELECT b FROM BookInventory b WHERE b.wholeSalePrice = :wholeSalePrice"),
    @NamedQuery(name = "BookInventory.findByListPrice", query = "SELECT b FROM BookInventory b WHERE b.listPrice = :listPrice"),
    @NamedQuery(name = "BookInventory.findByDateEnteredIntoInventory", query = "SELECT b FROM BookInventory b WHERE b.dateEnteredIntoInventory = :dateEnteredIntoInventory"),
    @NamedQuery(name = "BookInventory.findByRemovalStatus", query = "SELECT b FROM BookInventory b WHERE b.removalStatus = :removalStatus"),
    @NamedQuery(name = "BookInventory.findByNumberOfUnits", query = "SELECT b FROM BookInventory b WHERE b.numberOfUnits = :numberOfUnits")})
public class BookInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ISBN_NUMBER")
    private Integer isbnNumber;
    @Size(max = 30)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 30)
    @Column(name = "AUTHOR")
    private String author;
    @Size(max = 60)
    @Column(name = "PUBLISHER")
    private String publisher;
    @Column(name = "NUMBER_OF_PAGES")
    private Integer numberOfPages;
    @Size(max = 20)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 20)
    @Column(name = "IMAGE")
    private String image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "WHOLE_SALE_PRICE")
    private Double wholeSalePrice;
    @Column(name = "LIST_PRICE")
    private Double listPrice;
    @Column(name = "DATE_ENTERED_INTO_INVENTORY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnteredIntoInventory;
    @Column(name = "REMOVAL_STATUS")
    private Boolean removalStatus;
    @Column(name = "NUMBER_OF_UNITS")
    private Integer numberOfUnits;
    @OneToMany(mappedBy = "isbnNumber")
    private List<CustomerReviews> customerReviewsList;

    public BookInventory() {
    }

    public BookInventory(Integer isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Integer getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(Integer isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getWholeSalePrice() {
        return wholeSalePrice;
    }

    public void setWholeSalePrice(Double wholeSalePrice) {
        this.wholeSalePrice = wholeSalePrice;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Date getDateEnteredIntoInventory() {
        return dateEnteredIntoInventory;
    }

    public void setDateEnteredIntoInventory(Date dateEnteredIntoInventory) {
        this.dateEnteredIntoInventory = dateEnteredIntoInventory;
    }

    public Boolean getRemovalStatus() {
        return removalStatus;
    }

    public void setRemovalStatus(Boolean removalStatus) {
        this.removalStatus = removalStatus;
    }

    public Integer getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(Integer numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public List<CustomerReviews> getCustomerReviewsList() {
        return customerReviewsList;
    }

    public void setCustomerReviewsList(List<CustomerReviews> customerReviewsList) {
        this.customerReviewsList = customerReviewsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbnNumber != null ? isbnNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookInventory)) {
            return false;
        }
        BookInventory other = (BookInventory) object;
        if ((this.isbnNumber == null && other.isbnNumber != null) || (this.isbnNumber != null && !this.isbnNumber.equals(other.isbnNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabiofonseca.entities.BookInventory[ isbnNumber=" + isbnNumber + " ]";
    }
    
}
