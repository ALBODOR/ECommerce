package ecommerce.persistence;

import ecommerce.metier.Categorie;
import ecommerce.metier.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Persistence manager class for entity "Produit".
 * @author ALBODOR
 */
public class ProduitDAO extends DAO {

    private static final String TABLENAME = "Produit";
    private CategorieDAO categorieDAO;

    public ProduitDAO() {
        super();
        categorieDAO = new CategorieDAO();
    }
    
    

    @Override
    public void create(Object o) {
        System.out.print(getClass().getSimpleName()+".create() : ");
        Produit prod = (Produit) o;
        ResultSet result;
        PreparedStatement ps;        
        String query = 
                "INSERT INTO "+TABLENAME+" VALUES(null, '"+prod.getNom()+"','"+prod.getDescription()+"', '"+
                prod.getPrix()+"', '"+prod.getQuantite()+"', '"+prod.getCategorie().getId()+"')";
        try {
            ps = connection.clientPrepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            System.out.println("Successful!");
            result = ps.getGeneratedKeys();
            result.next();
            prod.setId(result.getObject(1, Long.class));
            System.out.println("Generated Key ==> "+prod.getId());
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
    }

    @Override
    public void modify(Object o) {     
        System.out.print(getClass().getSimpleName()+".modify() : ");
        Produit prod = (Produit) o;
        String query = 
                " UPDATE "+TABLENAME
                +" SET nom='"+prod.getNom()+"', description='"+prod.getDescription()
                +"', prix='"+prod.getPrix()+"', quantite='"+prod.getQuantite()
                +"', idCATEGORIE='"+prod.getCategorie().getId()+"' "
                +" WHERE id"+TABLENAME+"='"+prod.getId()+"';";
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
        Produit prod = (Produit) o;
        String query = 
                " DELETE FROM "+TABLENAME
                +" WHERE id"+TABLENAME+"='"+prod.getId()+"';";
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
        Categorie cat;
        String query = 
                " SELECT * FROM "+TABLENAME
                +" WHERE id"+TABLENAME+"='"+id+"';";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            results = ps.executeQuery();
            while(results.next()) {
                cat = (Categorie) categorieDAO.find(results.getInt(6));
                return new Produit(results.getLong(1), results.getString(2), results.getString(3),
                                    results.getFloat(4), results.getInt(5), cat);
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
        List<Produit> produits = new ArrayList<>();
        Categorie cat;
        ResultSet results;
        String query = 
                " SELECT * FROM "+TABLENAME+" ;";
        PreparedStatement ps;
        try {
            ps = connection.clientPrepareStatement(query);
            results = ps.executeQuery();
            while(results.next()) {
                cat = (Categorie) categorieDAO.find(results.getInt(6));
                produits.add(new Produit(results.getLong(1), results.getString(2), results.getString(3),
                                        results.getFloat(4), results.getInt(5), cat));
            }
            System.out.println("Successful!");
            return produits;
        } catch(SQLException e){
            System.out.println("Failure!");
            System.err.println(e);
        }
        return null;
    }
}
