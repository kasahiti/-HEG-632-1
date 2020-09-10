/**
 * Classe Livre permettant de représenter un livre
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class Livre {
    //Variables d'instances
    String isbn;
    String nom;
    String auteur;

    /**
     * Constructeur de la classe Livre
     * @param isbn = numéro ISBN du livre
     * @param nom = nom du livre
     * @param auteur = nom de l'auteur
     */
    public Livre(String isbn, String nom, String auteur) {
        this.isbn = isbn;
        this.nom = nom;
        this.auteur = auteur;
    }

    //Gettes et Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Redéfinition de la méthode héritée toString()
     * @return un string présentant l'objet
     */
    @Override
    public String toString() {
        return "(" + isbn + ") " + "\"" + nom + "\" de " + auteur;
    }

    /**
     * Redéfinition de la méthode héritée equals()
     * @param livre = une instance de livre à comparer
     * @return true si le livre reçu en paramètre est le même que celui-ci
     */
    public boolean equals(Livre livre){
        return livre.getIsbn().equalsIgnoreCase(this.isbn);
    }
}
