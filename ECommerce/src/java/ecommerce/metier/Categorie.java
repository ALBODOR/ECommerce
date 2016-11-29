package ecommerce.metier;

import java.util.List;

/**
 * Class to represent a category entity in Database.
 * @author ALBODOR
 */
public class Categorie {

    private long id;
    private String nom;
    private String description;
    private List<Produit> products;

    public Categorie() {
    }

    public Categorie(long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public Categorie(String name, String description, List<Produit> products) {
        this.nom = name;
        this.description = description;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public List<Produit> getProducts() {
        return products;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categorie{" + "nom=" + nom + ", description=" + description + '}';
    }
        
}
