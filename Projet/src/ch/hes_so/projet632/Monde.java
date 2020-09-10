// Package
package ch.hes_so.projet632;

// Imports
import fr.emse.simulator.world.SimulationMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Monde permettant de représenter une carte lors de la simulation
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Monde implements SimulationMap
{
    // Variables d'instance
    private int nbRows;
    private int nbCols;
    private ArrayList<ArrayList<Cellule>> cellules;
    private final ArrayList<Cellule> voleurs;
    private final ArrayList<Cellule> drones;
    private final ArrayList<Cellule> casesVideBord;
    private final ArrayList<Cellule> pieces;

    /**
     * Constructeur public de la classe World
     */
    public Monde()
    {
        // Initialisation des variables d'instance
        cellules = new ArrayList<>();
        voleurs = new ArrayList<>();
        drones = new ArrayList<>();
        casesVideBord = new ArrayList<>();
        pieces = new ArrayList<>();
    }

    /**
     * Méthode get permettant d'obtenir une cellule avec sa colonne et sa ligne
     * @param ligne     ligne de la cellule
     * @param colonne    colonne de la cellule
     * @return          la cellule demandée
     */
    @Override
    public Cellule get(int ligne, int colonne){
        // Nous retournons la cellule demandée
        return cellules.get(ligne).get(colonne);
    }

    // Getters et setters
    @Override
    public int getNbRows(){
        return nbRows;
    }

    @Override
    public int getNbCols(){
        return nbCols;
    }

    public void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }

    public void setNbCols(int nbCols) {
        this.nbCols = nbCols;
    }

    public ArrayList<Cellule> getVoleurs(){
        return voleurs;
    }

    public ArrayList<Cellule> getDrones(){
        return drones;
    }

    public ArrayList<Cellule> getCasesVideBord(){
        return casesVideBord;
    }

    public ArrayList<Cellule> getPieces(){
        return pieces;
    }

    public ArrayList<ArrayList<Cellule>> getCellules(){
        return cellules;
    }

    /**
     * Méthode setCellules permettant de rajouter des cellules dans une structure de données bidimensionnelle
     * @param cellules  Structure bidimensionnelle
     */
    public void setCellules(ArrayList<ArrayList<Cellule>> cellules) {
        this.cellules = cellules;
        updateLists();
    }

    /**
     * Méthode updateLists permettant de rajouter des cellules dans des listes
     */
    public void updateLists(){
        // Réinitialisation des ArrayList
        voleurs.clear();
        drones.clear();
        pieces.clear();
        casesVideBord.clear();

        // En fonction de l'occupant d'une cellule, ajouter cette cellule dans la liste adéquate
        for (ArrayList<Cellule> celluleArrayList : cellules){
            for (Cellule cellule : celluleArrayList){
                if (cellule.getOccupant() != null){
                    if (cellule.getOccupant().getClass() == Voleur.class){
                        voleurs.add(cellule);
                    } else if (cellule.getOccupant().getClass() == Drone.class){
                        drones.add(cellule);
                    } else if (cellule.getOccupant().getClass() == Argent.class){
                        pieces.add(cellule);
                    }
                }else{
                    // Si la cellule est vide et qu'elle est sur un bord, la rajouter dans la liste des casesVideBord
                    if ((cellule.getRow() == 0 || cellule.getRow() == nbRows) || (cellule.getCol() == 0 || cellule.getCol() == nbCols)){
                        casesVideBord.add(cellule);
                    }
                }
            }
        }
    }

    /**
     * Méthode permettant de retourner les cellules contenant des occupants pouvant bouger
     * @return celluleArrayList
     */
    public ArrayList<Cellule> getMovers() {
        // Concaténation des drones et des voleurs
        ArrayList<Cellule> celluleArrayList = new ArrayList<>(drones);
        celluleArrayList.addAll(voleurs);

        // Mélange au hasard des cellules
        Collections.shuffle(celluleArrayList);

        // Retourne la liste mélangée
        return celluleArrayList;
    }
}