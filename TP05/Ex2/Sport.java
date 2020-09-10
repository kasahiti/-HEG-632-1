/**
 * Classe abstraite Sport héritant de Prestation, et représentant un sport
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public abstract class Sport extends Prestation {
    // Variables
    String nom;
    boolean interieur;
    int prix;
    int participants;
    int surface;

    /**
     * Constructeur de Sport
     *
     * @param nom           nom du sport
     * @param prix          prix du sport
     * @param interieur     vrai si le sport se fait à l'intérieur
     * @param participants  nombre de participants
     * @param surface       surface du terrain
     */
    public Sport(String nom, int prix, boolean interieur, int participants, int surface){
        this.nom = nom;
        this.prix = prix;
        this.interieur = interieur;
        this.participants = participants;
        this.surface = surface;
    }

    /**
     * Méthode affichage permettant d'afficher un sport
     */
    public abstract void affichage();
}
