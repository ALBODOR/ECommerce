package ecommerce.persistence;

import ecommerce.metier.Categorie;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Persistence manager class for entity "Categorie".
 * @author ALBODOR
 */
public class CategorieDAO extends DAO {
    
    private static final String TABLENAME = "Categorie";

    @Override
    public void create(Object o) {
        Categorie cat = (Categorie) o;
        String query = 
                "INSERT INTO "+TABLENAME+" VALUES(null, '"+cat.getNom()+"','"+cat.getDescription()+"')";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            int result = ps.executeUpdate();
            System.out.println(getClass().getSimpleName()+".create() : Successful!");
        } catch(SQLException e){
            System.err.println(getClass().getSimpleName() + " : "+e);
        }
    }

    @Override
    public void modify(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
