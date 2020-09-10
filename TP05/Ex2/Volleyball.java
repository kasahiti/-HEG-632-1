/**
 * Classe Volleyball héritant de Sport et représentant le sport volleyball
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Volleyball extends Sport {

    /**
     * Constructeur public de la classe Volleyball
     * @param nom           nom du sport
     * @param prix          prix du sport
     * @param interieur     vrai s'il s'agit d'un sport d'intérieur
     * @param participants  nombre maximal de participants
     * @param surface       surface du terrain
     */
    public Volleyball(String nom, int prix, boolean interieur, int participants, int surface) {
        super(nom, prix, interieur, participants, surface);
    }

    /**
     * Méthode redéfinie affichage permettant d'afficher les détails de ce sport
     */
    @Override
    public void affichage() {
        System.out.print(nom + " pour " + prix + "CHF\nCe sport est pratiqué à");

        if (interieur){
            System.out.print(" l'intérieur ");
        }else{
            System.out.print(" l'extérieur ");
        }

        System.out.println("par " + participants + " participants au maximum.\n" +
                "Il faut un terrain de " + surface + "m^2, posséder un filet d'une hauteur de 2m42 et un ballon de " + nom.toLowerCase() + ".");
    }

    /**
     * Méthode permettant d'obtenir le prix
     * @return  le prix du sport
     */
    @Override
    int getPrix() {
        return prix;
    }
}
