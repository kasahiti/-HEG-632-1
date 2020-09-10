import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * La classe GestionnairePersonne permet de gérer une liste de personnes
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class GestionnairePersonne
{
    //Variables d'instances
    private ArrayList<Personne> personnes = new ArrayList<>();
    private ArrayList<String> nationalites = new ArrayList<>();
    
    /**
     * Méthode lectureFichier permettant de lire le contenu d'un fichier et de retourner son contenu sous forme de string
     *
     * @param  path   le chemin vers le fichier
     * @return        le contenu du fichier sous forme de String
     */
    public String lectureFichier(String path) throws IOException{
        BufferedReader lecteurAvecBuffer = null;
        String texte = "";
        String ligne;
        try{
              lecteurAvecBuffer = new BufferedReader(new FileReader(path));
        }
        catch(FileNotFoundException exc){
              System.out.println("Erreur d'ouverture");
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null)
          texte += ligne + "\n";
        lecteurAvecBuffer.close();
        return texte;
    }
    
    /**
     * Méthode chargerNationalites permettant de créer une liste des nationalités
     */
    public void chargerNationalites(){
        for(int i=0; i<personnes.size(); i++){
            //Si la nationalité n'est pas encore dans la liste, la rajouter
            if(!nationalites.contains(personnes.get(i).getNationalite())){
                nationalites.add(personnes.get(i).getNationalite());
            }
        }
    }
    
    /**
     * Méthode chargerPersonnes permettant de prendre le contenu renvoyé par lectureFichier et de créer une liste de personne
     */
    public ArrayList chargerPersonnes(String donnees){
        //Déclaration et initialisation des variables locales
        ArrayList<Personne> listePersonnes = new ArrayList<>();
        String[] ligne = donnees.split("\n");
        
        String nom;
        String prenom;
        int age;
        String nationalite;
                
        //Pour chaque ligne (personne), créer une nouvelle personne et la rajouter dans listePersonnes
        for(int i=0; i<ligne.length; i++){
            String[] personne = ligne[i].split(";");
            
            nom = personne[0];
            prenom = personne[1];
            age = Integer.parseInt(personne[2]);
            nationalite = personne[3];
            
            listePersonnes.add(new Personne(nom, prenom, age, nationalite));
        }
        
        return listePersonnes;
    }
    
    /**
     * Méthode affichant les personnes ayant moins de trente ans
     */
    public void afficheMoinsTrente(){
       System.out.println("-------- Moins de 30 ans --------");
       
       for(Personne p : personnes){
           if(p.getAge()<30){
               //Pour chaque personne dans la liste personnes, afficher celles qui ont moins de trente ans (grâce à la méthode toString redéfinie);
               System.out.println(p.toString());
           }
       }
    }
    
    /**
     * Méthode affichant les personnes par nationalité
     */
    public void afficheNationalite(){
        System.out.println("-------- Par nationalité --------");
        
        for(String nat : nationalites){
           System.out.println("--- " + nat + " ---");
           for(Personne p : personnes){
               //Pour chaque nationalité dans la liste nationalites, afficher les personnes en fonction de leur nationalités
               if(p.getNationalite().equals(nat)){
                   System.out.println(p.toString());
               }
           }
        }
    }
    
    /**
     * Méthode affichant les personnes correspondant à une certaine recherche
     */
    public void recherchePersonne(String valeur){
        boolean trouve = false;
        
        System.out.println();
        System.out.println("-------- Recherche --------");
        
        for(Personne p : personnes){
            //Si une personne dans liste personnes continent la valeur de la recherche, alors l'afficher grâce à la méthode redéfinie toString
            if(p.toString().toLowerCase().contains(valeur.toLowerCase())){
                System.out.println(p.toString());
                trouve = true;
            }
        }
        
        //Si aucune personne n'a été trouvée, alors afficher un message
        if(!trouve){
            System.out.println("Personne ne correspond à cette recherche");
        }
    }
    
    /**
     * Méthode main exécutant toutes les autres méthodes
     */
    public void main() throws IOException{
        personnes.clear();
        personnes = chargerPersonnes(lectureFichier("personnes.txt"));
        chargerNationalites();
        afficheMoinsTrente();
        afficheNationalite();
        recherchePersonne("Hoeffer");
        recherchePersonne("Suisse");
        recherchePersonne("mi");
        recherchePersonne("Test");
    }
}
