/**
 * Classe Lampe héritant de la classe abstraite Produit et implémentant les méthode de l'interface Vendable.
 * Cette classe représente une lampe.
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Lampe extends Produit implements Vendable {
    // Variable d'instance
    int hauteurPied;

    /**
     * Constructeur public de la classe Lampe
     * @param nom           nom de la lampe
     * @param prix          prix de la Lampe
     * @param promotion     montant de la promotion
     * @param hauteurPied   hauteur du pied de la lampe
     */
    public Lampe(String nom, int prix, int promotion, int hauteurPied) {
        super(nom, prix, promotion);
        this.hauteurPied = hauteurPied;
    }

    /**
     * Méthode redéfinie, permettant de décrire l'usage de la lampe
     * @return  une String représentant l'usage
     */
    @Override
    String descriptionUsage() {
        return "Idéal pour la lecture de livre ou pour faire vos mots-fléchés dans votre lit !";
    }

    /**
     * Méthode redéfinie, permettant d'obtenir le nouveau prix (en tenant compte de la promotion)
     * @return le nouveau prix
     */
    @Override
    public double prixPromo() {
        return prix * (100-promotion) / 100;
    }

    /**
     * Méthode affichage redéfinie, et affichant les détails de la lampe.
     */
    @Override
    public void affichage() {
        System.out.println("Nom du produit : " + nom + "\n" +
                "Prix : " + prixPromo() + "CHF (Avant : " + prix + "CHF)\n" +
                "Promotion de : " + promotion + "%\n" +
                "Hauteur du pied : " + hauteurPied + "cm");

        System.out.println(descriptionUsage());
    }
}
