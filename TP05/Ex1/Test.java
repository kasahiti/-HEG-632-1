import java.util.ArrayList;

/**
 * Classe Test permettant de tester les différentes méthodes des classes Plafonnier, Lampe, et de tester l'interface
 * Vendable et la classe abstraite Produit.
 *
 * @author  Kastriot Sahiti
 * @version 2020-06-01
 */
public class Test
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static final ArrayList<Produit> produits = new ArrayList<>();

    public static void main (String[] args){
        produits.add(new Lampe("EasyRead", 100, 20,30));
        produits.add(new Lampe("Lueur D'espoir", 75, 10,20));
        produits.add(new Lampe("LightV4", 150, 0,60));
        produits.add(new Lampe("LuxeLight", 180, 15,130));
        produits.add(new Plafonnier("AmbianceLight", 100, 20,"Vis"));
        produits.add(new Plafonnier("A Light Name", 130, 10,"Colle spéciale"));
        produits.add(new Plafonnier("E-Light", 100, 30,"Vis"));
        produits.add(new Plafonnier("ModernLight", 300, 40,"Colle spéciale"));
        for(Produit p: produits){
            // Appel à la méthode affichage, redéfinie de l'interface Vendable
            if (p.getClass() == Plafonnier.class){
                ((Plafonnier)p).affichage();
            } else {
                ((Lampe)p).affichage();
            }

            System.out.println("----------");
        }
    }
}
