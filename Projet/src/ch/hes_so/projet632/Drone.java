// Package
package ch.hes_so.projet632;

// Imports
import fr.emse.simulator.astar.AStarPathFinder;
import fr.emse.simulator.world.*;

import java.util.ArrayList;

/**
 * Classe Drone permettant de représenter un drone
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Drone implements Robot{
    // Variables d'instance
    ArrayList<ArrayList<Cell>> paths = new ArrayList<>();
    ArrayList<Cell> cheminTemporaire = null;
    ArrayList<Cell> chemin = null;

    AStarPathFinder solver;
    Monde monde;
    Cellule cellule;

    /**
     * Méthode permettant de bouger une instance de Drone vers une destination
     *
     * @param monde     une instance de la classe Monde
     * @param cellule   une cellule
     * @param solver    instance de la classe AStarPathFinder, permettant d'utiliser l'algorithme A*
     */
    public void move(Monde monde, Cellule cellule, AStarPathFinder solver){
        // Initialisation des variables
        this.solver = solver;
        this.cellule = cellule;
        this.monde = monde;

        // Utilisation de l'algorithme A* ("A-Star") pour cette simulation
        getTarget(monde.getVoleurs());

        if(chemin != null){
            effectuerMouvement();
        }
    }

    /**
     * Méthode permettant d'effectuer un mouvement
     */
    public void effectuerMouvement(){
        ((Cellule)chemin.get(1)).setOccupant(cellule.getOccupant());
        cellule.setOccupant(null);
    }

    /**
     * Méthode permettant de définir le chemin le plus court à l'objectif le plus proche
     * @param targets   liste de tous les objectifs à atteindre
     */
    public void getTarget(ArrayList<Cellule> targets){
        // Réinitialisation des ArrayList
        paths.clear();
        if (cheminTemporaire != null) cheminTemporaire = null;
        if (chemin != null) chemin = null;

        // Parcours de tous les objectifs
        for (Cellule objectif : targets){
            paths.add(solver.getShortestPath(cellule, objectif));
        }

        // Selection de l'objectif le plus proche
        for (ArrayList<Cell> path : paths) {
            if (path == null) {
                continue;
            }

            if (cheminTemporaire == null){
                cheminTemporaire = path;
            }

            if (path.size() < cheminTemporaire.size()){
                chemin = path;
            }

            if (chemin == null){
                chemin = cheminTemporaire;
            }
        }
    }
}
