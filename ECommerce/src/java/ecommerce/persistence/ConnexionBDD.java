package ecommerce.persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ALBODOR
 */
public class ConnexionBDD {
    
    // DB Connection Parameters
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "base_ecommerce";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    
    // DB Connection Object
    private static Connection connection = null;
    
    /**
     * Assert that one and only one connection is made to the Database.
     * @return Connection object to the Database.
     */
    public static Connection getInstance() {
        if(connection == null) {
            try {
                System.out.print("Connecting to database...");
                connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Success!");
            } catch (SQLException ex) {
                System.err.println("Failed!");
                System.err.println(ex);
            }
        }
        return connection;
    }

}
