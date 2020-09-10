import java.util.HashMap;
import java.util.HashSet;

/**
 * Décrivez votre classe GestionnairePanier ici.
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class GestionnairePanier
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashSet<Produit> listeProduit = chargerProduits();
    private HashMap<Produit,Integer> panier = new HashMap<>();

    /**
     * Méthode main de la classe GestionnairePanier
     * Cette méthode a été crée uniquement pour pouvoir travailler depuis IntelliJ
     * @param args = tableau d'argument fourni au programme
     */
    public static void main(String[] args){
        GestionnairePanier gp = new GestionnairePanier();
        gp.afficherListeProduit();

        System.out.println();

        gp.ajouterProduitPanier("Lave-vaisselle", "Miele", 10);
        gp.afficherPanier();

        System.out.println();

        gp.retirerProduitPanier("Lave-vaisselle", "Miele");
        gp.afficherPanier();

        System.out.println();

        gp.ajouterProduitPanier("Test produit inexistant", "HEG", 2);
        gp.afficherPanier();
    }

    /**
     * Méthode affichange la liste des produits du magasin
     */
    public void afficherListeProduit()
    {
        //Nous parcourons la liste des produits et appelons implicitement les méthodes toString() des Produits
        for(Produit p : listeProduit){
            System.out.println(p);
        }
    }

    /**
     * Méthode permettant d'afficher le panier en cours
     */
    public void afficherPanier()
    {
        double total = 0.0;

        //Parcours du panier et affichage des informations
        for(Produit p : panier.keySet()){
            System.out.println(p + " Nombre d'exemplaires : " + panier.get(p));

            //Calcul du total pour chaque produit
            total += p.prix * panier.get(p);
        }

        //Affichage du prix total à payer
        System.out.println("Somme à payer : " + total + "CHF");
    }

    /**
     * Méthode permettant d'ajouter un produit au panier, en donnant son nom, sa marque, et la quantité voulue
     * @param nom = nom du produit
     * @param marque = marque du produit
     * @param quantite = quantité du produit
     */
    public void ajouterProduitPanier(String nom, String marque, int quantite){
        boolean found = false;

        //Nous parcourons la liste de tous les produits et l'ajoutons au panier si le produit existe
        for(Produit produit : listeProduit){
            if(produit.getNom().equalsIgnoreCase(nom) && produit.getMarque().equalsIgnoreCase(marque)){
                panier.put(produit, quantite);
                found = true;
            }
        }

        //Si le produit n'existe pas, nous affichons un message
        if(!found){
            System.out.println("Le produit ne fait pas parti de notre liste de produit");
        }
    }

    /**
     * Méthode permettant de retirer un produit du panier avec son nom et sa marque
     * @param nom = nom du produit
     * @param marque = marque du produit
     */
    public void retirerProduitPanier(String nom, String marque){
        boolean found = false;

        //Nous parcourons le panier et vérifions si le produit à retirer est dans le panier
        for (Produit produit : panier.keySet()){
            if(produit.getNom().equalsIgnoreCase(nom) && produit.getMarque().equalsIgnoreCase(marque)){
                panier.remove(produit);
                found = true;
            }
        }

        //Si le produit à retirer n'est pas dans le panier, nous affichons un message
        if(!found){
            System.out.println("Le produit ne fait pas parti de notre liste de produit");
        }
    }

    /**
     * Méthode permettant de charger tous les produits
     * @return un HashSet de tous les produits du magasin
     */
    private HashSet<Produit> chargerProduits()
    {
        HashSet<Produit> produits = new HashSet<>();
        produits.add(new Produit("Lave-vaisselle","Miele",700));
        produits.add(new Produit("Sèche-linge", "Miele", 900));
        produits.add(new Produit("Micro-ondes","Electrolux",90.45));
        produits.add(new Produit("Réfrigérateur", "Bosch", 859.90));
        produits.add(new Produit("Congélateur","Bosch",599.95));
        produits.add(new Produit("Hotte de ventilation", "Electrolux", 250.95));
        return produits;
    }
}
