package ecommerce.metier.bm;

import ecommerce.metier.Categorie;
import ecommerce.persistence.CategorieDAO;
import java.util.List;

/**
 * @author ALBODOR
 */
public class CategorieManagerImpl implements ICategorieManager {

    CategorieDAO dao;

    public CategorieManagerImpl() {
        this.dao = new CategorieDAO();
    }
    
    @Override
    public boolean persistCategorie(Categorie cat) {
        try {
            dao.create(cat);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean modifyCategorie(Categorie cat) {
        try {
            dao.modify(cat);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean removeCategorie(Categorie cat) {
        try {
            dao.delete(cat);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public int categorieCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int categorieProduitsCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> allCategories() {        
        try {
            return dao.findAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Categorie findCategorie(long i) {
        try {
            return (Categorie) dao.find(i);
        } catch (Exception ex) {
            return null;
        }
    }
}
