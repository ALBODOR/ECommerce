package ecommerce.application;

import com.mysql.jdbc.Connection;
import ecommerce.persistence.ConnexionBDD;

/**
 * Application Main Class
 * @author ALBODOR
 */
public class MainApp {

    public static void main(String[] args) {
        
        // Testing DB Connection
        Connection connection = ConnexionBDD.getInstance();
    }
    
    
}
