/**
 * Classe abstraite Produit, représentant un produit
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public abstract class Produit {
    // Variables de produits
    String nom;
    double prix;
    int promotion;

    /**
     * Constructeur
     * @param nom       nom du produit
     * @param prix      prix du produit
     * @param promotion promotion à appliquer au produit
     */
    public Produit(String nom, int prix, int promotion) {
        this.nom = nom;
        this.prix = prix;
        this.promotion = promotion;
    }

    /**
     * Méthode abstraite descriptionUsage permettant de décrire l'usage du produit
     * @return  une String représentant la description
     */
    abstract String descriptionUsage();
}
