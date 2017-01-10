/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action.beans;

import com.fabiofonseca.entities.BookInventory;
import com.fabiofonseca.entities.Clients;
import com.fabiofonseca.entities.Invoice;
import com.fabiofonseca.entities.InvoiceDetails;

import dataBeans.UserBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.inject.Inject;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */

@Named
@RequestScoped
public class MakePurchase implements Serializable {
    
    @Inject
    private ShoppingCart currentShoppingCart;  
    
    @Inject
    private UserBean currentUser;   
    
    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext
    EntityManager entityManager;    
       
        
     // gets the shopping cart of the client and makes the purchases of its items,
    //  persisting the items in the invoice and invoice_details databases.
    //  After purchase is over, it empties the shopping cart
    
     public String makePurchase() throws SQLException {
        double totalInvoiceNet = 0;
        double invoiceGST;
        double totalInvoiceGross; 
        Date dateOfPurchase = new Date();
        Clients userEntity = new Clients(); 
        userEntity = entityManager.find(Clients.class, currentUser.getClientNumber());        
                
        List<BookInventory> shoppingCart = currentShoppingCart.getShoppingCart();       
        Iterator<BookInventory> iterator = shoppingCart.iterator();         
        
        // calculates the total of the invoice
        while (iterator.hasNext()) {
            BookInventory bookInTheShoppingCart = iterator.next(); 
            totalInvoiceNet = totalInvoiceNet + bookInTheShoppingCart.getListPrice();                      
        }            
        invoiceGST = totalInvoiceNet*0.15;
        totalInvoiceGross = totalInvoiceNet + invoiceGST;       
        
        
        try {            
            userTransaction.begin();            
            Invoice invoice = new Invoice();   
            invoice.setClientNumber(userEntity);
            invoice.setDateOfSale(dateOfPurchase); 
            invoice.setTotalNetValue(totalInvoiceNet);
            invoice.setGst(invoiceGST);
            invoice.setTotalGrossValue(totalInvoiceGross); 
            
            
            // records the invoice in the invoice database
            entityManager.persist(invoice);                   
            
           Iterator<BookInventory> iterator2 = shoppingCart.iterator();  
           // records the invoice details
           while (iterator2.hasNext()) {                
           BookInventory bookInTheShoppingCart = iterator2.next();
           
           InvoiceDetails invoiceDetails = new InvoiceDetails();
           invoiceDetails.setPrice(bookInTheShoppingCart.getListPrice());
           invoiceDetails.setSaleNumber(invoice);
           invoiceDetails.setIsbnNumber(bookInTheShoppingCart.getIsbnNumber());
           
           entityManager.persist(invoiceDetails); 
           BookInventory bookBought = new BookInventory();
           bookBought = entityManager.find(BookInventory.class, bookInTheShoppingCart.getIsbnNumber());
           bookBought.setNumberOfUnits(bookBought.getNumberOfUnits()-1);
           entityManager.persist(bookBought);                     
        }               
            userTransaction.commit(); 
            
            JOptionPane.showMessageDialog(null, "Thank you for buying in Fabio's book store!");
            
            currentShoppingCart.getShoppingCart().clear(); // empties the shopping cart
            
        } catch (Exception ex) {           
            try {
                userTransaction.rollback();
            } catch (Exception ex1) {              
            }
        }     
        return "menu"; 
    }         
}
