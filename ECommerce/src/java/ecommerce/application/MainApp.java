package ecommerce.application;

import com.mysql.jdbc.Connection;
import ecommerce.metier.Categorie;
import ecommerce.persistence.CategorieDAO;
import ecommerce.persistence.ConnexionBDD;

/**
 * Application Main Class
 * @author ALBODOR
 */
public class MainApp {

    public static void main(String[] args) {
        
        // Testing DB Connection
        Connection connection = ConnexionBDD.getInstance();
        
        // Creating a new Categorie object
        Categorie cat = new Categorie();
        cat.setNom("Magazines");
        cat.setDescription("Hebdo, Quotidiennes, Mensuelles");
        
        // Persisting the new Categorie
//        CategorieDAO categorieDAO = new CategorieDAO();
//        System.out.println("Creating...");
//        categorieDAO.create(cat);
        
        // Modifyin the new Categorie
//        System.out.println("Modifying...");
//        cat.setDescription("NewDescription");
//        categorieDAO.modify(cat);

        // Deleting the new Categorie
//        System.out.println("Deleting...");
//        categorieDAO.delete(cat);
    }
    
    
}
