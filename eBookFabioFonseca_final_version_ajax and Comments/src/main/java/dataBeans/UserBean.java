/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBeans;


import com.fabiofonseca.entities.Invoice;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */


@Named("user")
@SessionScoped
public class UserBean implements Serializable {
    
    
    private static final long serialVersionUID = 1L;    
    
    private Integer clientNumber;   
    
    private String lastName;    
    private String firstName;    
    private String username;    
    private String password;    
    private String companyName;   
    private String address1;   
    private String address2;    
    private String city;    
    private String province;   
    private String postalCode;    
    private String homeTelephone;   
    private String cellPhone;    
    private String email;   
    private List<Invoice> invoiceList;

    public UserBean() {
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
    public String toString() {
        return "UserBean{" + "clientNumber=" + clientNumber + ", lastName=" + lastName + ", firstName=" + firstName + ", username=" + username + ", password=" + password + ", companyName=" + companyName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", homeTelephone=" + homeTelephone + ", cellPhone=" + cellPhone + ", email=" + email + ", invoiceList=" + invoiceList + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.clientNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserBean other = (UserBean) obj;
        if (!Objects.equals(this.clientNumber, other.clientNumber)) {
            return false;
        }
        return true;
    }
    
    
    
    
}

