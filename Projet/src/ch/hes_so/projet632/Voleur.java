// Package
package ch.hes_so.projet632;

// Imports
import fr.emse.simulator.astar.AStarPathFinder;
import fr.emse.simulator.world.*;

import java.util.ArrayList;

/**
 * Classe Voleur permettant de représenter un voleur
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Voleur implements Robber{
    // Variables d'instance
    ArrayList<ArrayList<Cell>> paths = new ArrayList<>();
    ArrayList<Cell> cheminTemporaire = null;
    ArrayList<Cell> chemin = null;

    AStarPathFinder solver;
    Monde monde;
    Cellule cellule;

    int pieces = 0;
    int compteur = 0;

    boolean[] pieceUne = {true, true, false};
    boolean[] pieceDeux = {true, false, false};

    /**
     * Méthode permettant de bouger une instance de Voleur vers une destination
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

        // Tant que le voleur n'as pas volé 2 pièces, continuer de chercher des pièces
        if (pieces < 2){
            // Utilisation de l'algorithme A*
            getTarget(monde.getPieces());
            if (chemin.get(1).getOccupant() != null && chemin.get(1).getOccupant().getClass() == Argent.class){
                pieces++;
                compteur = 0;
            }
        } else {
            // Dès que le voleur a 2 pièces, chercher une sortie
            getTarget(monde.getCasesVideBord());
        }

        // En fonction du nombre de pièces, effectuer N-x tours, ou n = 3 et x = au nombre de pièces
        if (pieces == 0){
            if (chemin != null) effectuerMouvement();
        } else if (pieces == 1 && pieceUne[compteur]){
            if (chemin != null) effectuerMouvement();
        } else if (pieces == 2 && pieceDeux[compteur]){
            if (chemin != null) effectuerMouvement();
        }

        // Ajustement du compteur
        compteur++;
        if (compteur == 3){
            compteur = 0;
        }
    }

    /**
     * Méthode permettant d'effectuer un mouvement
     */
    public void effectuerMouvement(){
        if (chemin.get(0).getRow() == 0 || chemin.get(0).getRow() == monde.getNbRows() || chemin.get(0).getCol() == 0 || chemin.get(0).getCol() == monde.getNbCols()){
            ((Cellule) chemin.get(0)).setOccupant(null);
        } else {
            ((Cellule) chemin.get(1)).setOccupant(cellule.getOccupant());
            cellule.setOccupant(null);
        }
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
