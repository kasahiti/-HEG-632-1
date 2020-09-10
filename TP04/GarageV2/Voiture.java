import java.util.Objects;

/**
 * Classe Voiture permettant de représenter une voiture
 *
 * @author Kastriot Sahiti
 * @version 2020-05-16
 */
public class Voiture extends Vehicule
{
    // instance variables - replace the example below with your own
    int chevaux;

    /**
     * Constructeur de la classe Voiture
     */
    public Voiture(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision, int chevaux)
    {
        super(marque, modele, annee, plaqueImmatriculation, anneeRevision);
        this.chevaux = chevaux;
    }

    /**
     * Constructeur avec un seul paramètre de la classe Voiture
     */
    public Voiture(String plaqueImmatriculation){
        super(plaqueImmatriculation);
    }

    /**
     * Redéfinition de la méthode héritée equals
     * @param o objet à comparer avec l'instance de cette classe
     * @return  vrai si les objets sont égaux (ie. si les plaques sont les mêmes)
     */
    public boolean equals(Object o){
        if (o != null && o.getClass() == Voiture.class){
            return ((Voiture) o).plaqueImmatriculation.equalsIgnoreCase(plaqueImmatriculation);
        }
        return false;
    }

    /**
     * Redéfinition de la méthode héritée hashCode (car equals() a été redéfinie)
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(chevaux);
    }

    /**
     * Redéfinition de la méthode héritée toString()
     * @return une String représentant la voiture
     */
    @Override
    public String toString()
    {
        return "Voiture : " + marque + " " + modele + " de " + annee + " - " + plaqueImmatriculation + " Année de révision : " + anneeRevision + " " + chevaux + " chevaux";
    }
}
