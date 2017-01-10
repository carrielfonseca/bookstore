/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action.beans;


import com.fabiofonseca.entities.Clients;
import dataBeans.UserBean;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */

@Named
@RequestScoped
public class Login implements Serializable {
    
    @Inject
    private UserBean currentUser;
    
    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext
    EntityManager entityManager;   
    
       
    boolean showMessageOfFailedLogin = false ;    //defines if login has been successful
   
   // gets the information of the user by username and checks if the password is correct
   // In the case that either the username or the password do not exist, catches the excpetion and
   // sets variable showMessageOfFailedLogin to true 
    
    
   public String doLogin() throws SQLException {
      String nextPage = "";     
      Clients userEntity = new Clients();     
      
     try {  
        userEntity = (Clients) entityManager.createNamedQuery("Clients.findByUsername").setParameter("username",currentUser.getUsername()).getSingleResult();
      }
      catch (Exception ex) {
          nextPage = "login"; 
          setShowMessageOfFailedLogin(true);
      }     
      
      if (currentUser.getPassword().equals(userEntity.getPassword())) {
          currentUser.setClientNumber(userEntity.getClientNumber());
          nextPage = "menu";
      }
      else {
          nextPage = "login"; 
          setShowMessageOfFailedLogin(true);
      }     
      return nextPage;
   }  
   
   public boolean isShowMessageOfFailedLogin() {
        return showMessageOfFailedLogin;
    }

    public void setShowMessageOfFailedLogin(boolean showMessageOfFailedLogin) {
        this.showMessageOfFailedLogin = showMessageOfFailedLogin;
    }
    
}
