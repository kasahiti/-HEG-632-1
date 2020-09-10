/**
 * Classe Plafonnier héritant de la classe abstraite Produit et implémentant les méthode de l'interface Vendable.
 * Cette classe représente un plafonnier.
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Plafonnier extends Produit implements Vendable{
    // Variable d'instance
    String typeFixation;

    /**
     * Constructeur public de la classe Plafonnier
     * @param nom           nom du plafonnier
     * @param prix          prix du plafonnier
     * @param promotion     montant de la promotion
     * @param typeFixation  type de fixation
     */
    public Plafonnier(String nom, int prix, int promotion, String typeFixation) {
        super(nom, prix, promotion);
        this.typeFixation = typeFixation;
    }

    /**
     * Méthode redéfinie, permettant de décrire l'usage du plafonnier
     * @return  une String représentant l'usage
     */
    @Override
    String descriptionUsage() {
        return "Idéal pour une pièce telle qu'une cuisine ou un salon.";
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
     * Méthode affichage redéfinie, et affichant les détails du plafonnier.
     */
    @Override
    public void affichage() {
        System.out.println("Nom du produit : " + nom + "\n" +
                "Prix : " + prixPromo() + "CHF (Avant : " + prix + "CHF)\n" +
                "Promotion de : " + promotion + "%\n" +
                "Type de fixation : " + typeFixation);

        System.out.println(descriptionUsage());
    }
}
