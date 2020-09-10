import java.util.ArrayList;
/**
 * Classe Hotel permettant de représenter un Hôtel.
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Hotel
{
    // Variables d'instance
    private static final ArrayList<Prestation> prestations = new ArrayList<>();

    /**
     * Méthode permettant de calculer le prix moyen de toutes les prestations proposées par l'hotel
     * @return le prix moyen
     */
    public double prixMoyen(){
        double prixTotal = 0;
        int nbPrestations = prestations.size();

        for (Prestation p : prestations){
            prixTotal += p.getPrix();
        }

        return prixTotal/nbPrestations;
    }

    /**
     * Méthode main permettant de lancer les tests
     * @param args  tableau d'arguments
     */
    public static void main(String[] args){
        Hotel h = new Hotel();

        System.out.println("Liste des prestations de l'Hôtel");
        prestations.add(new Volleyball("Volleyball",50,true,12,81));
        prestations.add(new Football("Football",80,false,22,10800));
        prestations.add(new Peinture("Peinture sur soie",100,16,20,"Suzanne Gaugain"));
        prestations.add(new Bricolage("Bricolage pour tous",20,25,30,"Bri-colle"));

        for (Prestation p : prestations){
            System.out.println("-----------------");
            p.affichage();
        }

        System.out.println("");
        System.out.println("Pour un prix moyen de "+ h.prixMoyen() +"CHF");
    }
}
