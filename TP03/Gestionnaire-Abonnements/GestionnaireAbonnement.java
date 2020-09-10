import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Classe GestionnaireAbonnement permettant de gérer tous les abonnements disponibles, souscris, etc.
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class GestionnaireAbonnement
{
    //Variables d'instance
    private InputReader reader;
    private Responder responder;
    private ArrayList<Service> servicesAbonnes = new ArrayList<>(); // Service auxquels vous êtes abonnés
    private HashSet<Service> tousServices = new HashSet<>(); // Tous les services disponibles

    /**
     * Méthode main de la classe GestionnaireAbonnement
     * Cette méthode a été crée uniquement pour pouvoir travailler depuis IntelliJ
     * @param args = tableau d'argument fourni au programme
     */
    public static void main(String[] args){
        GestionnaireAbonnement gest = new GestionnaireAbonnement();
        gest.start();
    }

    /**
     * Constructeur de la classe GestionnaireAbonnement
     */
    public GestionnaireAbonnement()
    {
        // Ne pas modifier !
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Méthode permettant de lancer le gestionnaire
     */
    public void start()
    {
        // A compléter
        System.out.println("Bonjour et bienvenue dans votre gestionnaire d'abonnements");
        chargerDonnees();
        selectionUtilisateur();
        printGoodbye();
    }

    /**
     * Méthode permettant d'afficher le menu
     */
    public void afficherMenu(){
        System.out.println("\n-----------------------------------------");
        System.out.println("Pour lister vos abonnements, tapez 1\n" +
                "Pour lister tous les abonnements, tapez 2\n" +
                "Pour vous désabonner d'un service, tapez 3\n" +
                "En tout temps, vous pouvez taper \"exit\" pour quitter le gestionnaire.");
        System.out.println("-----------------------------------------\n");
    }

    /**
     * Méthode permettant à l'utilisateur de faire un choix sur le menu
     */
    public void selectionUtilisateur(){
        //Déclaration et initialisation des variables locales
        boolean fin = false;
        int noChoix = 0;
        HashSet<String> choix = new HashSet<>();

        //Affichage du menu
        afficherMenu();
        while (!fin){
            //Saisie du choix de l'utilisateur et transformation en entier
            choix = reader.getInput();
            for (String str : choix){
                if (!str.equalsIgnoreCase("exit")) {
                    noChoix = Integer.parseInt(str);
                }else{
                    noChoix = 0;
                    break;
                }
            }
            fin = noChoix >= 0 && noChoix <= 3;
        }

        //En fonction du choix, appel aux méthodes concernées
        switch (noChoix){
            case 1: System.out.println(responder.generateResponse(choix));
                    afficherAbo();
                    selectionUtilisateur();
                    break;
            case 2: System.out.println(responder.generateResponse(choix));
                    afficherAboDispo();
                    selectionUtilisateur();
                    break;
            case 3: System.out.println(responder.generateResponse(choix));
                    supprimerAbo();
                    selectionUtilisateur();
                    break;
            default: break; //si le choix ne fait pas partie de la liste des choix (ie si l'utilisateur tape "exit"), alors fin de la méthode selectionUtilisateur()
        }
    }

    /**
     * Méthode permettant d'afficher la liste des abonnements de l'utilisateur
     */
    public void afficherAbo(){
        for(Service service : servicesAbonnes){
            System.out.println(service.toString());
        }
    }

    /**
     * Méthode permettant d'afficher la liste de tous les services
     */
    public void afficherAboDispo(){
        for(Service service : tousServices){
            System.out.println(service.getNom());
        }
    }

    /**
     * Méthode permettant de supprimer la liste de tous les abonnements pour un service donné
     */
    public void supprimerAbo(){
        afficherAbo();

        String service = reader.getInput().iterator().next();
        Iterator<Service> it = servicesAbonnes.iterator();
        boolean supp = false;

        while (it.hasNext()){
            String nom = it.next().getNom();
            if(nom.equalsIgnoreCase(service)){
                it.remove();
                supp = true;
            }
        }

        if(supp){
            System.out.println("Un abonnement " + service + " a bien été retiré de vos abonnements.");
        }else {
            System.out.println("Aucun service ne coresspond à votre entrée. Retour au Menu");
        }
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        // Ne pas modifier !
        System.out.println("Au plaisir de vous revoir.");
    }
    
    private void chargerDonnees(){
        // Ne pas modifier !
        tousServices.add(new Service("Netflux"));
        tousServices.add(new Service("JunglePrimeVideo"));
        tousServices.add(new Service("Thisknee-"));
        tousServices.add(new Service("CBO"));
        tousServices.add(new Service("PearTV+"));
        tousServices.add(new Service("Holol"));
        servicesAbonnes.add(new Service("Netflux",15,"25-06-2021"));
        servicesAbonnes.add(new Service("Netflux",15,"25-06-2021"));
        servicesAbonnes.add(new Service("Thisknee-",9.95,"21-04-2020"));
        servicesAbonnes.add(new Service("PearTV+",42.95,"25-08-2020"));
        servicesAbonnes.add(new Service("JunglePrimeVideo",13.85,"25-06-2021"));
    }
}
