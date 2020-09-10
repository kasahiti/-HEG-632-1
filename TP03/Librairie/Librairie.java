import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Classe librairie permettant de représenter et de manager une librairie
 *
 * @author Kastriot Sahiti
 * @version 2020-05-03
 */
public class Librairie
{
    private HashMap<Livre,Integer> listeLivre = new HashMap<>();
    private HashSet<Livre> listeLivreDisponible = new HashSet<>();

    //Constructeur publique de la classe Librairie
    public Librairie(){
        chargerLivres();
    }

    /**
     * Méthode main de la classe Librairie
     * Cette méthode a été crée uniquement pour pouvoir travailler depuis IntelliJ
     * @param args = tableau d'argument fourni au programme
     */
    public static void main(String[] args){
        Librairie lib = new Librairie();
        lib.afficheEtatLibraire();
        lib.emprunterLivre("978-8-71235-963-7");
        lib.afficheEtatLibraire();
        System.out.println("Il y a " + lib.nombreLivreLibrairie() + " livres dans la librairie.");

        lib.depotLivre(new Livre("978-1-11111-111-1", "Harry Potter à l'école des sorciers", "J. K. Rowling"));
        lib.afficheEtatLibraire();
        System.out.println("Il y a " + lib.nombreLivreLibrairie() + " livres dans la librairie.");
    }
    
    /**
     * Méthode permettant de charger les données de livres dans la HashMap 
     * gérant le nombre d'exemplaires et la HashSet gérant les livres 
     * disponibles.
     */
    private void chargerLivres()
    {
        listeLivre.put(new Livre("978-5-78945-963-4","Les fleurs du mal", "Charles Baudelaire"), 3);
        listeLivre.put(new Livre("978-8-71235-963-7","L'étranger", "Albert Camus"), 1);
        listeLivre.put(new Livre("978-2-41322-578-1","L'assommoir", "Émile Zola"),2);
        listeLivre.put(new Livre("978-3-13245-922-3","Le tour du monde en quatre-vingts jours", "Jules Vernes"),3);
        listeLivre.put(new Livre("978-1-78234-913-4","Germinal", "Émile Zola"),1);
        listeLivre.put(new Livre("978-8-71115-963-4","La peste", "Albert Camus"),4);
        for (Livre l : listeLivre.keySet()){
            listeLivreDisponible.add(l);
        }
    }

    /**
     * Méthode permettant d'emprunter un livre de la librairie. Cette méthode ajuste le contenu de listeLivre et listeLivreDisponible
     * @param isbn = code ISBN du livre à emprunter
     */
    public void emprunterLivre(String isbn){
        //Nous utilisons un itérateur pour parcourir la liste des livres disponibles
        Iterator<Livre> it = listeLivreDisponible.iterator();

        while(it.hasNext()){
            Livre livre = it.next();
            if(livre.getIsbn().equalsIgnoreCase(isbn)) {
                listeLivre.put(livre, listeLivre.get(livre)-1);

                //Si le n'est plus dans le stock après l'emprunt, le supprimer de la liste des livres disponible avec la méthode remove() demandée dans l'énoncé
                if (listeLivre.get(livre) == 0){
                    it.remove();
                }
            }
        }
    }

    /**
     * Méthode permettant de déposer un nouveau livre
     * @param nouveauLivre = une instance de Livre à déposer dans la librairie
     */
    public void depotLivre(Livre nouveauLivre){
        boolean found = false;

        //Vérifier si le livre existe déjà dans la librairie (ie si ce n'est pas un don)
        for(Livre livre : listeLivre.keySet()){
            if(nouveauLivre.equals(livre)){
                //Si le livre existe déjà, rajouter un exemplaire en stock
                listeLivre.put(livre, listeLivre.get(livre)+1);
                found = true;
            }
        }

        //Si le livre n'existe pas, l'ajouter dans la liste des livres de la librairie
        if(!found){
            listeLivre.put(nouveauLivre, 1);
        }

        //Dans tous les cas, rajouter le livre dans la liste des livres disponibles à l'emprunt
        listeLivreDisponible.add(nouveauLivre);
    }

    /**
     * Méthode permettant de calculer le nombre total de livres dans la librairie
     * @return le nombre de livres disponible dans la librairie
     */
    public int nombreLivreLibrairie(){
        int nbLivre = 0;

        for(Livre livre : listeLivre.keySet()){
            nbLivre += listeLivre.get(livre);
        }
        return nbLivre;
    }

    /**
     * Méthode permettant d'afficher l'état de la librairie (liste des livres en stocks + livres empruntable)
     */
    public void afficheEtatLibraire(){
        //Affichage des livres de la librairie en parcourant la HashMap listeLivre
        System.out.println("Liste des livres de la librairie :");
        for (Livre livre : listeLivre.keySet()){
            System.out.println(livre + " - Nombre d'exemplaires : " + listeLivre.get(livre));
        }

        //Affichage des livres disponibles de la librairie en parcourant la HashSet listeLivreDisponible
        System.out.println("\nListe des livres disponibles :");
        for (Livre livre : listeLivreDisponible){
            System.out.println(livre);
        }

        System.out.println();
    }
}
