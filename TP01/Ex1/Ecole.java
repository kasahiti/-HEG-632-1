/**
 * La classe école décrit une école. Elle possède tous les champs nécessaire à la gestion de l'école : adresse, nom, type, degré, etc.
 *
 * @author Kastriot Sahiti
 * @version 2020-02-08
 */
public class Ecole
{
    // variables d'instance
    private String nom;
    private String adresse;
    private String type;
    private String degre;
    private String domaine;
    private int nbEtudiants;
    private int nbBat;

    /**
     * Constructeur d'objets de classe Ecole. Pour chaque paramètre, assigner la valeur du paramètre dans les variables d'instance
     */
    public Ecole(String nom, String adresse, String type, String degre, String domaine, int nbEtudiants, int nbBat)
    {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.degre = degre;
        this.domaine = domaine;
        this.nbEtudiants = nbEtudiants;
        this.nbBat = nbBat;
    }// Fin du constructeur Ecole

    /**
     * Méthode permettant de modifier le nombre de bâtiment d'une école
     * @param nb = nouveau nombre de bâtiments
     */
    public void setNbBat(int nb)
    {
        nbBat = nb;
    }// Fin de la méthode setNbBat

    /**
     * Méthode permettant de modifier le nombre d'élèves d'une école
     * @param nb
     */
    public void setNbEtudiants(int nb)
    {
        nbEtudiants = nb;
    }// Fin de la méthode setNbEtudiants

    /**
     * Méthode permettant de changer le degré par une valeur donnée.
     * @param degre = nouveau degré
     */
    public void setDegre(String degre){
        // Si le type de l'école est publique, et que le nouveau degré est "Primaire" ou "C.O.", alors changer le domaine en "Général"
        if(type.equals("Publique") && (degre.equals("Primaire") || degre.equals("C.O."))){
            this.degre = degre;
            domaine = "Général";
        }else{
            this.degre = degre;
        }
    }// Fin de la méthode setDegre

    /**
     * Méthode affichant une école. Si le paramètre "full" est true, alors l'affichae de l'école sera complet (nom + adresse, type, degré, domaine, etc.)
     * @param full = booléen permettant d'afficher toutes les informations ou seulement une partie
     */
    public void afficherEcole(boolean full) {
        if(full){
            System.out.println(nom + ", " + adresse + "\n" + "Ecole " + type + " de degré " + degre + " dans le domaine " + domaine);
            System.out.println("Il y a " + nbBat + " bâtiments pour " + nbEtudiants + " étudiants");
        }else{
            System.out.println(nom + ", " + adresse);
        }
    }// Fin de la méthode afficherEcole
}
