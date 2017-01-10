/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action.beans;


import com.fabiofonseca.entities.Clients;

import dataBeans.UserBean;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
public class RegisterClient implements Serializable {
    
    @Inject
    private UserBean currentUser;
    
    @Resource
    private UserTransaction userTransaction;

    @PersistenceContext
    EntityManager entityManager;  
    
    
    // register a new clients. This method does not check if there is an existing user in the database
    // with the same username. Should add this functionality in a later version
    
     public String registerClient() {        
        try {            
            userTransaction.begin();            
            Clients newUser = new Clients();            
            recordUserBeanInUserEntity(currentUser, newUser);                       
            entityManager.persist(newUser);          
            userTransaction.commit();
            currentUser.setClientNumber(newUser.getClientNumber());
        } catch (Exception ex) {           
            try {
                userTransaction.rollback();
            } catch (Exception ex1) {              
            }
        }
        return "menu";
     }
        
       // transfers the information of the session scoped user bean to a user entity 
     
       public void recordUserBeanInUserEntity(UserBean userBean, Clients userEntity ) {
           userEntity.setUsername(userBean.getUsername());
           userEntity.setLastName(userBean.getLastName());
           userEntity.setFirstName(userBean.getFirstName());
           userEntity.setCompanyName(userBean.getCompanyName());
           userEntity.setAddress1(userBean.getAddress1());
           userEntity.setAddress2(userBean.getAddress2());
           userEntity.setCity(userBean.getCity());
           userEntity.setProvince(userBean.getProvince());
           userEntity.setPostalCode(userBean.getPostalCode());
           userEntity.setHomeTelephone(userBean.getHomeTelephone());
           userEntity.setCellPhone(userBean.getCellPhone());
           userEntity.setEmail(userBean.getEmail());    
           userEntity.setPassword(userBean.getPassword()); 
       }      
}
