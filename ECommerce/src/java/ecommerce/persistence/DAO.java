package ecommerce.persistence;

import com.mysql.jdbc.Connection;
import java.util.List;

/**
 * @author ALBODOR
 */
public abstract class DAO {
    
    protected Connection connection;

    /**
     * Connection to Database.
     */
    public DAO() {
        connection = ConnexionBDD.getInstance();
    }

    /**
     * Add a new item to a Database table.
     * @param o Item to be added.
     * @throws java.lang.Exception
     */
    public abstract void create(Object o) throws Exception;
    
    /**
     * Modify item in Database table.
     * @param o Item to be modified.
     * @throws java.lang.Exception
     */
    public abstract void modify(Object o)  throws Exception;
    
    /**
     * Delete item from Database table.
     * @param o Item to be deleted.
     * @throws java.lang.Exception
     */
    public abstract void delete(Object o)  throws Exception;
    
    /**
     * Return an item from Database Table using an identifier.
     * @param id Item identifier
     * @return Found item, null otherwise.
     * @throws java.lang.Exception
     */
    public abstract Object find(Object id)  throws Exception;
    
    /**
     * Return All Items from Database Table
     * @return 
     * @throws java.lang.Exception 
     */
    public abstract List findAll()  throws Exception;
    
}
