// Package
package ch.hes_so.projet632;

// Imports
import java.io.File;

/**
 * Classe Main permettant de lancer la simulation
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Main {
    public static void main(String[] args) {
        // Création d'un nouveau fichier
        File file = new File("src/niveauComplexe.txt");

        // Vérifier si le fichier existe
        if (file.exists()){
            // Si le fichier existe, créer un simulateur et exécuter la simulation
            Simulateur simulateur = new Simulateur(file);
            simulateur.run();
        }else{
            // Si le fichier n'existe pas, afficher un message significatif
            System.out.println("Le fichier que vous voulez lire n'existe pas !");
        }
    }
}
