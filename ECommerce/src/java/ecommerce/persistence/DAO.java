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
     * @return Database ID of the added item.
     */
    public abstract void create(Object o) ;
    
    /**
     * Modify item in Database table.
     * @param o Item to be modified.
     */
    public abstract void modify(Object o) ;
    
    /**
     * Delete item from Database table.
     * @param o Item to be deleted.
     */
    public abstract void delete(Object o) ;
    
    /**
     * Return an item from Database Table using an identifier.
     * @param id Item identifier
     * @return Found item, null otherwise.
     */
    public abstract Object find(Object id) ;
    
    /**
     * Return All Items from Database Table
     * @return 
     */
    public abstract List findAll() ;
    
}
