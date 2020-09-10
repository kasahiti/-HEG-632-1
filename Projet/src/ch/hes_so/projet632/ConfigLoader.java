// Package
package ch.hes_so.projet632;

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe ConfigLoader permettant de charger le niveau et de remplir les données dans une instance de la classe Monde
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class ConfigLoader {
    // Variables d'instance
    private static final ArrayList<String[]> donnees = new ArrayList<>();
    private static final ArrayList<ArrayList<Cellule>> cellules = new ArrayList<>();
    private static int nbLignes;
    private static int nbColones;

    /**
     * Méthode load permettant de créer des cellules et de les charger dans une instance de la classe Monde
     * @param monde         une instance de la classe Monde
     * @param file          le fichier à lire
     * @throws Exception    exception levée s'il y a un problème à la lecture
     */
    public static void load(Monde monde, File file) throws Exception {
        // Appel à la méthode lireFichier
        lireFichier(file);

        // Paramétrage du nombre de lignes et de colones
        monde.setNbCols(nbColones);
        monde.setNbRows(nbLignes);

        // Parcours des différents caractères afin de créer des cellules correspondantes
        for (int i=0; i<donnees.size(); i++){
            cellules.add(new ArrayList<>());
            for (int j=0; j<donnees.get(i).length; j++){
                switch (donnees.get(i)[j]){
                    // En fonction du caractère, créer une nouvelle cellule avec un certain occupant, et l'ajouter dans le monde
                    case "#": cellules.get(i).add(new Cellule(i, j, new Mur()));
                        break;
                    case "D": cellules.get(i).add(new Cellule(i, j, new Drone()));
                        break;
                    case "I": cellules.get(i).add(new Cellule(i, j, new Voleur()));
                        break;
                    case "$": cellules.get(i).add(new Cellule(i, j, new Argent()));
                        break;
                    default: cellules.get(i).add(new Cellule(i, j, null));
                }
            }
        }

        monde.setCellules(cellules);
    }

    /**
     * Méthode pour lire le contenu du fichier et le placer dans une ArrayList
     * @param file          fichier à lire
     * @throws Exception    exception levée s'il y a un problème à la lecture
     */
    public static void lireFichier(File file) throws Exception {
        // Ouverture d'un scanner avec un "try-with-resources"
        try(Scanner scanner = new Scanner(file)){
            // Enregistrement du nombre de lignes et de colones
            nbLignes = scanner.nextInt();
            nbColones = scanner.nextInt();

            // Lecture à vide pour ignorer la première ligne
            scanner.nextLine();

            // Lecture de toutes les lignes, et ajout des données dans des tableaux de string, qui seront rajoutés dans l'ArrayList "donnees"
            while(scanner.hasNextLine()) {
                String[] ligne = scanner.nextLine().split(" ");
                donnees.add(ligne);
            }
        }catch (FileNotFoundException e){
            // Affichage d'un message significatif en cas d'exception
            System.out.println("Il y a eu une erreur lors de la lecture du fichier !\nAffichage de l'erreur :");
            e.printStackTrace();
        }

        // Vérification de consistance des données
        if (donnees.size() != nbLignes){
            throw new Exception("Les données n'ont pas été correctement lues");
        }

        for (String[] strings : donnees){
            if (strings.length != nbColones){
                // Affichage d'un message significatif en cas d'exception
                throw new Exception("Les données n'ont pas été correctement lues");
            }
        }
    }
}