/**
 * Classe abstraite Prestation représentant une prestation.
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public abstract class Prestation {
    /**
     * Méthode permettant d'afficher une prestation
     */
    public abstract void affichage();

    /**
     * Méthode permettant d'obtenir le prix d'une prestation
     * @return le prix de la prestation
     */
    abstract int getPrix();
}
