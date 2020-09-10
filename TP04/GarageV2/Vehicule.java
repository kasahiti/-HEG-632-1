/**
 * Classe Vehicule permettant de représenter un véhicule
 */
public class Vehicule {
    // Variables d'instance
    String marque;
    String modele;
    int annee;
    String plaqueImmatriculation;
    int anneeRevision;

    /**
     * Constructeur public de la classe Vehicule
     * @param marque    marque du véhicule
     * @param modele    modèle du véhicule
     * @param annee     annee du véhicule
     * @param plaqueImmatriculation plaque d'immatriculation du véhicule
     * @param anneeRevision année de révision du véhicule
     */
    public Vehicule(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.anneeRevision = anneeRevision;
    }

    /**
     * Constructeur avec un seul paramètre de la classe Vehicule
     * @param plaqueImmatriculation plaque d'immatriculation du véhicule
     */
    public Vehicule(String plaqueImmatriculation){
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    /**
     * Méthode permettant de faire la révision du véhicule
     */
    public void faireRevision(){
        anneeRevision = 2020;
    }

    // Getters et Setters de la classe Vehicule
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public int getAnneeRevision() {
        return anneeRevision;
    }

    public void setAnneeRevision(int anneeRevision) {
        this.anneeRevision = anneeRevision;
    }
}
