/**
 * Classe Moto représentant une moto, et qui hérite de la classe Vehicule
 */
public class Moto extends Vehicule {
    // Variable d'instance
    int cylindree;

    /**
     * Constructeur de la classe Moto
     * @param marque    Marque de la moto
     * @param modele    Modèle de la moto
     * @param annee     Année de la moto
     * @param plaqueImmatriculation Plaque d'immatriculation de la moto
     * @param anneeRevision Année de révision de la moto
     * @param cylindree     Cylindree de la moto
     */
    public Moto(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int cylindree) {
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.cylindree = cylindree;
    }

    // Getters et Setters de la classe Moto
    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    /**
     * Redéfinition de la méthode héritée toString()
     * @return une String représentant la moto
     */
    @Override
    public String toString()
    {
        return "Moto : " +  marque + " " + modele + " de " + annee + " - " + plaqueImmatriculation + " Année de révision : " + anneeRevision + " " + cylindree + "cm3";
    }
}
