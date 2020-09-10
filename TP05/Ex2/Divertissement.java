/**
 * Classe abstraite Divertissement héritant de Prestation, et représentant un divertissement
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public abstract class Divertissement extends Prestation {
    // Variables
    String nomDivertissement;
    int prix;
    int ageMin;
    int participants;

    /**
     * Constructeur de Divertissement
     *
     * @param nomDivertissement     nom du divertissement
     * @param prix                  prix du divertissement
     * @param ageMin                age minimum pour le divertissement
     * @param participants          nombre de participants maximum
     */
    public Divertissement(String nomDivertissement, int prix, int ageMin, int participants){
        this.nomDivertissement = nomDivertissement;
        this.prix = prix;
        this.ageMin = ageMin;
        this.participants = participants;
    }

    /**
     * Méthode affichage permettant d'afficher un divertissement
     */
    public abstract void affichage();
}
