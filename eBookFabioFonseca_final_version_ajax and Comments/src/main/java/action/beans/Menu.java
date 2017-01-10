/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action.beans;

import com.fabiofonseca.entities.BookInventory;
import com.fabiofonseca.entities.Clients;
import com.fabiofonseca.entities.CustomerReviews;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
/**
 *
 * @author Admin
 */

@Named
@SessionScoped
public class Menu implements Serializable {

    @PersistenceContext
    EntityManager entityManager;    
    
    @Resource
    private UserTransaction userTransaction;

   
       
    private String genreChosen;  // genre of the dropdown menu chosen by the user  
    private int bookChosen;   // book of the dropdown menu chosen by the user
    private BookInventory book;    
    private String comment = "";
    private List<CustomerReviews> listOfComments = new ArrayList<CustomerReviews>(); 

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getGenreChosen() {
        return genreChosen;
    }

    public void setGenreChosen(String genreChosen) {
        this.genreChosen = genreChosen;
    }
    
    public int getBookChosen() {
        return bookChosen;
    }

    public void setBook(BookInventory book) {
        this.book = book;
    }

    public void setBookChosen(int bookChosen) {
        this.bookChosen = bookChosen;
    }
    
    public BookInventory getBook() {
        return book;
    }    
    
    /*
     public List<CustomerReviews> getListOfComments() throws SQLException {
         List<CustomerReviews> customerReviews;
         if (bookChosen == 0) {
       CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<CustomerReviews> cq = cb.createQuery(CustomerReviews.class);
       Root<CustomerReviews> commentary = cq.from(CustomerReviews.class);    
       cq.select(commentary);
       cq.where(cb.equal(commentary.get("isbnNumber"),entityManager.find(BookInventory.class, 12)));
       TypedQuery<CustomerReviews> query = entityManager.createQuery(cq);       
       customerReviews = query.getResultList(); 
         }
         else {
             CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<CustomerReviews> cq = cb.createQuery(CustomerReviews.class);
       Root<CustomerReviews> commentary = cq.from(CustomerReviews.class);    
       cq.select(commentary);
       cq.where(cb.equal(commentary.get("isbnNumber"),entityManager.find(BookInventory.class, bookChosen)));
       TypedQuery<CustomerReviews> query = entityManager.createQuery(cq);       
       customerReviews = query.getResultList(); 
         }
   return customerReviews ;
    }   
     */
     
     public List<CustomerReviews> getListOfComments() throws SQLException {
         List<CustomerReviews> customerReviews;
         
             CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<CustomerReviews> cq = cb.createQuery(CustomerReviews.class);
       Root<CustomerReviews> commentary = cq.from(CustomerReviews.class);    
       cq.select(commentary);
       cq.where(cb.equal(commentary.get("isbnNumber"),entityManager.find(BookInventory.class, bookChosen)));
       TypedQuery<CustomerReviews> query = entityManager.createQuery(cq);       
       customerReviews = query.getResultList();          
   return customerReviews ;
    }   
    
    
    // fills out the genre Items available in the database in the dropdown box
    
    public List<SelectItem> getGenreItems() throws SQLException {
        List<SelectItem> genreItems;    
        genreItems = new ArrayList<SelectItem>(); 
        List<String> genres = entityManager.createNativeQuery("select distinct(genre) from book_inventory").getResultList();  
        genreItems.add(new SelectItem("Select genre")); 
        Iterator<String> iterator = genres.iterator();       
        while (iterator.hasNext()) {
            String genre = iterator.next();            
            genreItems.add(new SelectItem(genre));            
        }       
   return genreItems;      
    }
    
    //fills out the books  available in the database of the genre chosen by the user in the drop down box 
    public List<SelectItem> getBookItems() throws SQLException {
       List<SelectItem> bookItems;
       String temp;       
       if (getGenreChosen() == null) {
           temp = "";
       }
       else {
           temp = getGenreChosen().toLowerCase();
       }      
    
       bookItems = new ArrayList<SelectItem>();
       bookItems.add(new SelectItem(0,"Select a Book"));     
           
       CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<BookInventory> cq = cb.createQuery(BookInventory.class);
       Root<BookInventory> book = cq.from(BookInventory.class);    
       cq.select(book);
       cq.where(cb.equal(book.get("genre"),temp));
       TypedQuery<BookInventory> query = entityManager.createQuery(cq);       
       List<BookInventory> bookInventory = query.getResultList();
       
        
        Iterator<BookInventory> iterator = bookInventory.iterator();
        while (iterator.hasNext()) {
            BookInventory bookies = iterator.next();            
            bookItems.add(new SelectItem(bookies.getIsbnNumber(),  bookies.getTitle()));
        }           
   return bookItems;
    }   
    
    
   // gets the image of the book chosen by the user 
   public String getImageOfTheBook() {
       String image = "";   
       if (bookChosen == 0) {
          image = "";    
       }
       else {
           book = entityManager.find(BookInventory.class, bookChosen);
           image = book.getImage();
       }              
        return image;
    }    
   
   public String getTitleOfTheBook() {
       String title = "";   
       if (bookChosen == 0) {
          title = "";    
       }
       else {
           book = entityManager.find(BookInventory.class, bookChosen);
          title = book.getTitle();
       }              
       return title; 
   }  
   
   public String getAuthorOfTheBook() {
       String author = "";   
       if (bookChosen == 0) {
          author = "";    
       }
       else {
           book = entityManager.find(BookInventory.class, bookChosen);
          author = book.getAuthor();
       }              
       return author; 
   }
   
   public double getPriceOfTheBook() {
       double price = 0;  
       if (bookChosen == 0) {
          price = 0;    
       }
       else {
           book = entityManager.find(BookInventory.class, bookChosen);
          price = book.getListPrice();
       }              
       return price; 
   }
   
   
   public String addComment() {        
        try {            
            userTransaction.begin();            
            CustomerReviews review = new CustomerReviews();    
            book = entityManager.find(BookInventory.class, bookChosen);
            review.setIsbnNumber(book);
            review.setDateOfReview(new Date());
            review.setReviewText(comment);           
            entityManager.persist(review);          
            userTransaction.commit();
            
        } catch (Exception ex) {           
            try {
                userTransaction.rollback();
            } catch (Exception ex1) {              
            }
        }
        return "menu";
     }
   
}
