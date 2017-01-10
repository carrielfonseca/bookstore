/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action.beans;

import com.fabiofonseca.entities.BookInventory;

import dataBeans.UserBean;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class ShoppingCart implements Serializable {
    
    @Inject
    private Menu menu;
    private UserBean currentUser;
    
    
    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext
    EntityManager entityManager;     
    
    private List<BookInventory> shoppingCartItems = new ArrayList<BookInventory>(); 
    
   
    
    
   public List<BookInventory> getShoppingCart()  {        
      return shoppingCartItems; 
   }     
   
   public String removeBook(BookInventory bookToDelete) {
        shoppingCartItems.remove(bookToDelete);
        return null;
    }
        
        
    public String addBook() {         
        if (menu.getBookChosen() != 0) {
        menu.setBook(entityManager.find(BookInventory.class, menu.getBookChosen()));          
        shoppingCartItems.add(menu.getBook());
        JOptionPane.showMessageDialog(null, "This book has been added to your shopping cart");
        }        
        return null;
    }     
       
}
