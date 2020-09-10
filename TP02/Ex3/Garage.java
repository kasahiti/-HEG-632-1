import java.util.ArrayList;
/**
 * Write a description of class Garage here.
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class Garage
{
    //Variables d'instance
    private ArrayList<Voiture> voitures = new ArrayList<>();

    /**
     * Méthode entreeVoiture permettant de représenter une entrée de voiture dans le garage
     */
    public void entreeVoiture(Voiture v){
        //Ajout du paramètre de type voiture dans la liste voitures
        voitures.add(v);
    }
    
    /**
     * Méthode sortieVoiture permettant de représenter une sortie de voiture dans le garage
     */
    public void sortieVoiture(Voiture v){
        //Retrait du paramètre de type voiture dans la liste voitures
        voitures.remove(v);
    }
    
    /**
     * Méthode reviserToutesLesVoitures permettant de changer la date de révision de toutes les voitures du garage à 2020
     */
    public void reviserToutesLesVoitures(){
        for(Voiture voiture : voitures){
            voiture.setAnneeRevision(2020);
        }
    }
    
    /**
     * Méthode afficherVoitures permettant d'afficher toutes les voitures du garage
     */
    public void afficherVoitures(){
        for(Voiture voiture : voitures){
            //Utilisation de la méthode redéfinie toString pour afficher les voitures
            System.out.println(voiture.toString());
        }
    }
    
    /**
     * Méthode voiturePresente permettant de chercher par plaque d'immatriculation la présence d'un véhicule dans le garage
     */
    public void voiturePresente(String plaqueImmatriculation){
        boolean existe = false;
        
        for(Voiture voiture : voitures){
            //Si la plaque d'immatriculation existe (test effectué grâce à la méthode redéfinie equals de la classe Voiture), alors afficher un message
            if(voiture.equals(plaqueImmatriculation)){
                System.out.println(voiture.toString() + " est présente dans le garage.");
                existe = true;
            }
        }
        
        //Si la voiture cherchée n'est pas dans le garage, afficher un message
        if(!existe){
            System.out.println("La voiture ayant la plaque " + plaqueImmatriculation + " n'est pas présente.");
        }
    }
}
