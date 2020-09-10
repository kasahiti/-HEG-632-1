/**
 * Write a description of class Voiture here.
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class Voiture
{
    //Variables d'instance
    private String marque;
    private String modele;
    private int annee;
    private String plaqueImmatriculation;
    private int anneeRevision;

    /**
     * Constructor for objects of class Voiture
     */
    public Voiture(String marque, String modele, int annee, String plaqueImmatriculation, int anneeRevision)
    {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.anneeRevision = anneeRevision;
    }    
    
    /**
     * Méthode setAnneeRevision permettant de changer l'année de révision de la voiture
     * @param l'année de révision
     */
    public void setAnneeRevision(int anneeRevision){
        this.anneeRevision = anneeRevision;
    }
    
    /**
     * Méthode redéfinie toString permettant d'afficher tous les détails de la voiture
     */
    public String toString(){
        String str = marque + " " + modele + " de " + annee + " - " + plaqueImmatriculation + " Année de révision : " + anneeRevision;
        return str;
    }
    
    /**
     * Méthode redéfinie equals permettant de tester si une plaque d'immatriculation correspond à celle de la voiture
     * @param le numéro d'immatriculation à tester
     * @return true si la plaque d'immatriculation en paramètre correspond à la plaque de la voiture, faux sinon
     */
    public boolean equals(String plaque){
        if(plaqueImmatriculation == plaque){
            return true;
        }
        
        return false;
    }
}
