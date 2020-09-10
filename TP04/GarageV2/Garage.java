import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Garage permettant de représenter un garage.
 *
 * @author  Kastriot Sahiti
 * @version 2020-05-16
 */
public class Garage
{
    // Variables d'instance
    private ArrayList<Vehicule> listeVehicules;
    private HashMap<Integer, ArrayList<Vehicule>> hmTousVehicules;

    /**
     * Constructeur de la classe Garage.
     */
    public Garage(){
        //Initialisation des liste ete hashmap de la classe
        listeVehicules = new ArrayList<>();
        hmTousVehicules = new HashMap<>();
    }

    /**
     * Méthode main permettant de tester les différentes méthode et classe
     * @param args  arguments de la console
     */
    public static void main(String[] args){
        // Nouveau garage
        Garage garage = new Garage();

        // Création de nouveux véhicules
        Moto kawa = new Moto("Kawasaki", "Z900", 2017, "BE0202022", 2019, 948);
        Moto suzu = new Moto("Suzuki", "SV650", 2014, "VS0203045", 2017, 650);
        Voiture rena = new Voiture("Renault", "Clio", 2010, "GE1234567", 2012, 98);
        Voiture pors = new Voiture("Porsche", "911", 2016, "GE0987654", 2017, 368);

        // Ajout des véhicules dans le garage
        garage.entreeVehicule(kawa);
        garage.entreeVehicule(suzu);
        garage.entreeVehicule(rena);
        garage.entreeVehicule(pors);

        // Différents tests demandés pour tester les méthodes
        garage.afficherVehicules();
        garage.afficherCarnetVehicule();
        garage.envoiPromotion();
        garage.reviserTousLesVehicules();
        garage.afficherVehicules();
        garage.afficherCarnetVehicule();
        garage.envoiPromotion();
        garage.sortieVehicule(suzu);
        garage.afficherVehicules();
        garage.afficherCarnetVehicule();
    }

    /**
     * Méthode permettant de faire entrer un vehicule dans le garage
     * @param v vehicule à rentrer dans le garage
     */
    public void entreeVehicule(Vehicule v)
    {
        listeVehicules.add(v);
        updateHmTousVehicules(v);
    }

    /**
     * Méthode permettant de mettre à jour la liste de tous les véhicules qui sont entrés dans le garage et de les
     * classe par année de révision dans une HashMap
     *
     * @param v vehicule à mettre à jour dans la HashMap
     */
    public void updateHmTousVehicules(Vehicule v){
        if (!hmTousVehicules.containsKey(v.getAnneeRevision())){
            // Si l'année de révision n'est pas dans la HashMap, la créer et rajouter une liste
            ArrayList<Vehicule> vehicules = new ArrayList<>();
            vehicules.add(v);
            hmTousVehicules.put(v.getAnneeRevision(), vehicules);
        } else {
            // Si l'année est déjà dans la hashmap, rajouter le véhicule dans la liste correspondante
            hmTousVehicules.get(v.getAnneeRevision()).add(v);
        }
    }

    /**
     * Méthode permettant de supprimer un véhicule de la listeVehicules
     * @param v vehicule à sortir du garage
     */
    public void sortieVehicule(Vehicule v){
        listeVehicules.remove(v);
    }

    /**
     * Méthode permettant de réviser tous les véhicules du garage
     */
    public void reviserTousLesVehicules(){
        for (Vehicule v : listeVehicules){
            // Nous supprimons le véhicule dans la hashMap de tous les véhicules
            hmTousVehicules.get(v.anneeRevision).remove(v);

            // Nous faisons la révision
            v.faireRevision();

            // Et nous mettons à jour la hashMap pour refléter la nouvelle année de révision
            updateHmTousVehicules(v);
        }
    }

    /**
     * Méthode permettant d'afficher tous les véhicules du garage
     */
    public void afficherVehicules(){
        for (Vehicule v : listeVehicules){
            System.out.println(v);
        }
        System.out.println();
    }

    /**
     * Méthode permettant d'afficher le carnet des véhicules
     */
    public void afficherCarnetVehicule(){
        System.out.println("Affichage du carnet");

        // Affichage des véhicules, classés par année
        for (Integer annee : hmTousVehicules.keySet()){
            System.out.println("----" + annee + "----");
            for (Vehicule vehicule : hmTousVehicules.get(annee)){
                //Appel implicite à la méthode redéfinie toString du vehicule
                System.out.println(vehicule);
            }
        }
        System.out.println();
    }

    /**
     * Méthode permettant d'afficher les promotions qui seront envoyées
     */
    public void envoiPromotion(){
        boolean promo = false;

        System.out.println("Un mail de promotion sur la révision a été envoyé aux propriétaires de :");
        for (Vehicule vehicule : listeVehicules){
            // Si l'année de révision est inférieur ou égale à 2018, afficher le véhicule (envoyer la "promotion")
            if (vehicule.getAnneeRevision() <= 2018){
                System.out.println(vehicule);
                promo = true;
            }
        }

        // Si aucune promotion n'a été envoyée, afficher un message significatif
        if (!promo){
            System.out.println("Aucun client ne réponds aux critères.");
        }
        System.out.println();
    }

    /**
     * Méthode permettant d'afficher si un vehicule est présent dans le garage
     * @param plaqueImmatriculation plaque d'immatriculation à checker
     */
    public void vehiculesPresents(String plaqueImmatriculation){
        Voiture voiture = new Voiture(plaqueImmatriculation);
        String result = "La voiture ayant la plaque " + plaqueImmatriculation + " n'est pas présente.";

        // Checker tous les véhicules du garage et appel à la méthode redéfinie equals pour effectuer la comparaison des plaques
        for (Vehicule v : listeVehicules){
            if(v.equals(voiture)){
                result = v + " est présente dans le garage.";
                break;
            }
        }

        System.out.println(result);
    }
}
