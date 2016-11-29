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
        cat.setNom("Ordinateurs Bureau");
        cat.setDescription("Description");
        
        // Persisting the new Categorie
        CategorieDAO categorieDAO = new CategorieDAO();
        categorieDAO.create(cat);
    }
    
    
}
