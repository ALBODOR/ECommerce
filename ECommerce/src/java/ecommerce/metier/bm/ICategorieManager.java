package ecommerce.metier.bm;

import ecommerce.metier.Categorie;
import java.util.List;

/**
 * @author ALBODOR
 */
public interface ICategorieManager {

    public boolean persistCategorie(Categorie cat);
    
    public boolean modifyCategorie(Categorie cat);
    
    public boolean removeCategorie(Categorie cat);
    
    public int categorieCount();
    
    public int categorieProduitsCount();
    
    public List<Categorie> allCategories();
    
    public Categorie findCategorie(long i);
    
}
