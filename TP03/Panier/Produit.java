/**
 * Classe produit permettant de représenter un produit
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class Produit {
    //Variables d'instance
    String nom;
    String marque;
    double prix;

    /**
     * Constructeur de la classe Produit
     * @param nom = nom du produit
     * @param marque = marque du produit
     * @param prix = prix du produit
     */
    public Produit(String nom, String marque, double prix) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    //Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Redéfinition de la méthode héritée toString()
     * @return un string représentant l'objet
     */
    @Override
    public String toString() {
        return nom + " fabriqué par " + marque + " pour " + prix + " CHF";
    }
}
