// Package
package ch.hes_so.projet632;

// Imports
import fr.emse.simulator.Simulator;
import fr.emse.simulator.astar.AStarPathFinder;
import fr.emse.simulator.astar.EuclideanDistanceHeuristic;
import fr.emse.simulator.astar.PreferEmptyCellsLocalCost;
import fr.emse.simulator.gui.MapFrame;
import fr.emse.simulator.world.Occupant;

import java.io.File;
import java.util.ArrayList;

/**
 * Classe Simulateur permettant de lancer une simulation avec des drones, des voleurs, de l'argent, des murs et des cases vides.
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Simulateur extends Simulator {
    // Variables d'instance
    private final int TIME = 200;
    private Monde monde;
    private final AStarPathFinder solver;

    /**
     * Constructeur public de la classe Simulateur
     * @param file  fichier à lire
     */
    public Simulateur(File file){
        // Appel au constructeur de la classe abstraite mère
        super(file);

        // Initialisation de l'algorithme A*
        ArrayList<Class<? extends Occupant>> aIgnorer = new ArrayList<>();
        aIgnorer.add(Drone.class);
        solver = new AStarPathFinder(
                monde,
                new EuclideanDistanceHeuristic(),
                new PreferEmptyCellsLocalCost(1, 3),
                aIgnorer);
    }

    /**
     * Méthode permettant de charger un monde
     * @param file  fichier pointant vers la carte représentée sous forme de texte
     */
    @Override
    public void loadMap(File file){
        // Instanciation d'un Monde
        monde = new Monde();

        // Chargement de la configuration
        try {
            ConfigLoader.load(monde, file);
        } catch (Exception e) {
            // Affichage d'un message significatif en cas d'exception
            System.out.println("Problème lors du chargement de la configuration");
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant d'effectuer les mouvements des drones et des voleurs
     */
    @Override
    public void runOneStep(){
        // Pour chaque occupant, effectuer le mouvement
        for (Cellule cellule : monde.getMovers()){
            if (cellule.getOccupant().getClass() == Drone.class){
                ((Drone)cellule.getOccupant()).move(monde, cellule, solver);
            }else{
                ((Voleur)cellule.getOccupant()).move(monde, cellule, solver);
            }

            // Mise à jour des structures de données des voleurs, drones, etc.
            monde.updateLists();
        }
    }

    /**
     * Méthode permettant de lancer la simulation
     */
    @Override
    public void run(){
        // Création d'une nouvelle fenêtre
        MapFrame frame = new MapFrame(monde);

        // Tant que la partie n'est pas finie, continuer la simulation
        while (!isOver()){
            System.out.println("Le jeu n'est pas terminé");

            // Effectuer un mouvement de plus pour toutes les entités pouvant se déplacer
            runOneStep();

            // Mise à jour de la fenêtre
            frame.repaint(TIME);
        }

        System.out.println("Le jeu est terminé");
    }

    /**
     * Méthode permettant de vérifier qu'une simulation est terminée
     * @return false si la simulation n'est pas terminée
     */
    @Override
    public boolean isOver(){
        // Une simulation est terminée lorsqu'il n'y a plus de voleurs sur la carte
        return monde.getVoleurs().isEmpty();
    }
}
