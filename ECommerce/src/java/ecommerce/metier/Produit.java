package ecommerce.metier;

/**
 * Class representing
 * @author ALBODOR
 */
public class Produit {

    private long id;
    private String nom;
    private String description;
    private float prix;
    private int quantite;

    private Categorie categorie;

    public Produit() {
    }

    public Produit(String nom, String description, float prix, int quantite, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
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

    public float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    @Override
    public String toString() {
        return "Produit{" + "nom=" + nom + ", description=" + description + '}';
    }
    
}
