/**
 * Classe Service permettant de représenter un abonnement
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class Service {
    //Variables d'instance
    String nom;
    Double prix;
    String validite;

    /**
     * Constructeur de la classe Service
     * @param nom = nom du service
     * @param prix = prix du service (double)
     * @param validite = date de validité
     */
    public Service(String nom, Double prix, String validite) {
        this.nom = nom;
        this.prix = prix;
        this.validite = validite;
    }

    /**
     * Constructeur surchargé de la classe Service
     * @param nom = nom du service
     * @param prix = prix du service (int)
     * @param validite = date de validité
     */
    public Service(String nom, int prix, String validite) {
        this.nom = nom;
        this.prix = (double)prix;
        this.validite = validite;
    }


    //Getters et Setters
    public Service(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getValidite() {
        return validite;
    }

    public void setValidite(String validite) {
        this.validite = validite;
    }

    /**
     * Redéfinition de la méthode héritée toString()
     * @return un string présentant l'objet
     */
    @Override
    public String toString() {
        return nom + " (" + prix + ") valable jusqu'au " + validite;
    }
}
