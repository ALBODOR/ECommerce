package ecommerce.persistence;

import ecommerce.metier.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Persistence manager class for entity "Categorie".
 * @author ALBODOR
 */
public class CategorieDAO extends DAO {
    
    private static final String TABLENAME = "Categorie";

    @Override
    public void create(Object o) {
        System.out.print(getClass().getSimpleName()+".create() : ");
        Categorie cat = (Categorie) o;
        ResultSet result;
        PreparedStatement ps;        
        String query = 
                "INSERT INTO "+TABLENAME+" VALUES(null, '"+cat.getNom()+"','"+cat.getDescription()+"')";
        try {
            ps = connection.clientPrepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            System.out.println("Successful!");
            result = ps.getGeneratedKeys();
            result.next();
            cat.setId(result.getObject(1, Long.class));
            System.out.println("Generated Key ==> "+cat.getId());
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
    }

    @Override
    public void modify(Object o) {     
        System.out.print(getClass().getSimpleName()+".modify() : ");
        Categorie cat = (Categorie) o;
        String query = 
                " UPDATE "+TABLENAME
                +" SET nom='"+cat.getNom()+"', description='"+cat.getDescription()+"'"
                +" WHERE id"+TABLENAME+"='"+cat.getId()+"';";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            int result = ps.executeUpdate();
            System.out.println("Successful!");
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
    }

    @Override
    public void delete(Object o) {    
        System.out.print(getClass().getSimpleName()+".delete() : ");
        Categorie cat = (Categorie) o;
        String query = 
                " DELETE FROM "+TABLENAME
                +" WHERE id"+TABLENAME+"='"+cat.getId()+"';";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            ps.executeUpdate();
            System.out.println("Successful!");
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }        
    }

    @Override
    public Object find(Object id) {
        System.out.print(getClass().getSimpleName()+".find() : ");
        ResultSet results;
        String query = 
                " SELECT * FROM "+TABLENAME
                +" WHERE id"+TABLENAME+"='"+id+"';";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            results = ps.executeQuery();
            while(results.next()) {
                return new Categorie(results.getLong(1), results.getString(2), results.getString(3));
            }
            System.out.println("Successful!");
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
        return null;
    }

    @Override
    public List findAll() {
        System.out.print(getClass().getSimpleName()+".find() : ");
        List<Categorie> categories = new ArrayList<>();
        ResultSet results;
        String query = 
                " SELECT * FROM "+TABLENAME+" ;";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            results = ps.executeQuery();
            while(results.next()) {
                categories.add(new Categorie(results.getLong(1), results.getString(2), results.getString(3)));
            }
            System.out.println("Successful!");
            return categories;
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
        return null;
    }

}
