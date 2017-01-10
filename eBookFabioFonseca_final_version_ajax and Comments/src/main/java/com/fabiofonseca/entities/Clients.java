/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiofonseca.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "clients", catalog = "ebook", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientNumber", query = "SELECT c FROM Clients c WHERE c.clientNumber = :clientNumber"),
    @NamedQuery(name = "Clients.findByLastName", query = "SELECT c FROM Clients c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Clients.findByFirstName", query = "SELECT c FROM Clients c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Clients.findByUsername", query = "SELECT c FROM Clients c WHERE c.username = :username"),
    @NamedQuery(name = "Clients.findByPassword", query = "SELECT c FROM Clients c WHERE c.password = :password"),
    @NamedQuery(name = "Clients.findByCompanyName", query = "SELECT c FROM Clients c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Clients.findByAddress1", query = "SELECT c FROM Clients c WHERE c.address1 = :address1"),
    @NamedQuery(name = "Clients.findByAddress2", query = "SELECT c FROM Clients c WHERE c.address2 = :address2"),
    @NamedQuery(name = "Clients.findByCity", query = "SELECT c FROM Clients c WHERE c.city = :city"),
    @NamedQuery(name = "Clients.findByProvince", query = "SELECT c FROM Clients c WHERE c.province = :province"),
    @NamedQuery(name = "Clients.findByPostalCode", query = "SELECT c FROM Clients c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "Clients.findByHomeTelephone", query = "SELECT c FROM Clients c WHERE c.homeTelephone = :homeTelephone"),
    @NamedQuery(name = "Clients.findByCellPhone", query = "SELECT c FROM Clients c WHERE c.cellPhone = :cellPhone"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIENT_NUMBER")
    private Integer clientNumber;
    @Size(max = 60)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 60)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 60)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 60)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 60)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Size(max = 60)
    @Column(name = "ADDRESS_1")
    private String address1;
    @Size(max = 60)
    @Column(name = "ADDRESS_2")
    private String address2;
    @Size(max = 60)
    @Column(name = "CITY")
    private String city;
    @Size(max = 60)
    @Column(name = "PROVINCE")
    private String province;
    @Size(max = 60)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Size(max = 60)
    @Column(name = "HOME_TELEPHONE")
    private String homeTelephone;
    @Size(max = 60)
    @Column(name = "CELL_PHONE")
    private String cellPhone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "clientNumber")
    private List<Invoice> invoiceList;

    public Clients() {
    }

    public Clients(Integer clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Integer getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(Integer clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientNumber != null ? clientNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientNumber == null && other.clientNumber != null) || (this.clientNumber != null && !this.clientNumber.equals(other.clientNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabiofonseca.entities.Clients[ clientNumber=" + clientNumber + " ]";
    }
    
}
