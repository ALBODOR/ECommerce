package ecommerce.persistence;

import java.util.List;

/**
 * @author ALBODOR
 */
public interface DAO {

    /**
     * Add a new item to a Database table.
     * @param o Item to be added.
     */
    public void create(Object o) ;
    
    /**
     * Modify item in Database table.
     * @param o Item to be modified.
     */
    public void modify(Object o) ;
    
    /**
     * Delete item from Database table.
     * @param o Item to be deleted.
     */
    public void delete(Object o) ;
    
    /**
     * Return an item from Database Table using an identifier.
     * @param id Item identifier
     * @return Found item, null otherwise.
     */
    public Object find(Object id) ;
    
    /**
     * Return All Items from Database Table
     * @return 
     */
    public List findAll() ;
    
}
