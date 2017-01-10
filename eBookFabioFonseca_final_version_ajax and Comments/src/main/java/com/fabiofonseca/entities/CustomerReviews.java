/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiofonseca.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "customer_reviews", catalog = "ebook", schema = "")
@NamedQueries({
    @NamedQuery(name = "CustomerReviews.findAll", query = "SELECT c FROM CustomerReviews c"),
    @NamedQuery(name = "CustomerReviews.findById", query = "SELECT c FROM CustomerReviews c WHERE c.id = :id"),
    @NamedQuery(name = "CustomerReviews.findByDateOfReview", query = "SELECT c FROM CustomerReviews c WHERE c.dateOfReview = :dateOfReview"),
    @NamedQuery(name = "CustomerReviews.findByClientName", query = "SELECT c FROM CustomerReviews c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "CustomerReviews.findByRating", query = "SELECT c FROM CustomerReviews c WHERE c.rating = :rating"),
    @NamedQuery(name = "CustomerReviews.findByReviewText", query = "SELECT c FROM CustomerReviews c WHERE c.reviewText = :reviewText"),
    @NamedQuery(name = "CustomerReviews.findByApprovalStatus", query = "SELECT c FROM CustomerReviews c WHERE c.approvalStatus = :approvalStatus")})
public class CustomerReviews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE_OF_REVIEW")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReview;
    @Size(max = 60)
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "RATING")
    private Integer rating;
    @Size(max = 700)
    @Column(name = "REVIEW_TEXT")
    private String reviewText;
    @Column(name = "APPROVAL_STATUS")
    private Boolean approvalStatus;
    @JoinColumn(name = "ISBN_NUMBER", referencedColumnName = "ISBN_NUMBER")
    @ManyToOne
    private BookInventory isbnNumber;

    public CustomerReviews() {
    }

    public CustomerReviews(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Boolean getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public BookInventory getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(BookInventory isbnNumber) {
        this.isbnNumber = isbnNumber;
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
        if (!(object instanceof CustomerReviews)) {
            return false;
        }
        CustomerReviews other = (CustomerReviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabiofonseca.entities.CustomerReviews[ id=" + id + " ]";
    }
    
}
