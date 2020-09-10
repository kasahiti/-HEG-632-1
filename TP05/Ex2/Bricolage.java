/**
 * Classe Bricolage héritant de Divertissement et représentant le divertissement bricolage
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Bricolage extends Divertissement {
    // Variables d'instance
    String nomAssociation;

    /**
     * Constructeur public de la classe Peinture
     * @param nomDivertissement      nom du divertissement
     * @param prix                   prix du divertissement
     * @param ageMin                 age minimum requis pour ce divertissement
     * @param participants           nombre maximal de participants
     * @param nomAssociation         nom et prénom de la personne dispensant ce divertissement
     */
    public Bricolage(String nomDivertissement, int prix, int ageMin, int participants, String nomAssociation) {
        super(nomDivertissement, prix, ageMin, participants);
        this.nomAssociation = nomAssociation;
    }

    /**
     * Méthode redéfinie affichage permettant d'afficher les détails de ce divertissement
     */
    @Override
    public void affichage() {
        System.out.println(nomDivertissement + " pour " + prix + "CHF\n" +
                "Ce divertissement est prévu dès " + ageMin + " ans et accueille " + participants + " participants au maximum.\n" +
                "Requiert le matériel de base de bricolage. Ce cours est dispensé par : " + nomAssociation);
    }

    /**
     * Méthode permettant d'obtenir le prix
     * @return  le prix du divertissement
     */
    @Override
    int getPrix() {
        return prix;
    }
}
