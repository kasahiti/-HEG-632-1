/**
 * Classe Peinture héritant de Divertissement et représentant la divertissement peinture
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Peinture extends Divertissement {
    // Variables d'instance
    String nomPrenom;

    /**
     * Constructeur public de la classe Peinture
     * @param nomDivertissement      nom du divertissement
     * @param prix                   prix du divertissement
     * @param ageMin                 age minimum requis pour ce divertissement
     * @param participants           nombre maximal de participants
     * @param nomPrenom              nom et prénom de la personne dispensant ce divertissement
     */
    public Peinture(String nomDivertissement, int prix, int ageMin, int participants, String nomPrenom) {
        super(nomDivertissement, prix, ageMin, participants);
        this.nomPrenom = nomPrenom;
    }

    /**
     * Méthode redéfinie affichage permettant d'afficher les détails de ce divertissement
     */
    @Override
    public void affichage() {
        System.out.println(nomDivertissement + " pour " + super.prix + "CHF\n" +
                "Ce divertissement est prévu dès " + ageMin + " ans et accueille " + participants + " participants au maximum.\n" +
                "Requiert un atelier, de la peinture et le matériel adéquat. Ce cours est dispensé par : " + nomPrenom);
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
