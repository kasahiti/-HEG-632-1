// Package
package ch.hes_so.projet632;

// Imports
import fr.emse.simulator.world.Cell;
import fr.emse.simulator.world.Occupant;

/**
 * Classe Cellule représentant une cellule, et implémentant l'interface Cell
 *
 * @author  Kastriot Sahiti, Deborah Palma
 * @version 2020-05-31
 */
public class Cellule implements Cell
{
    // Variables d'instance
    private Occupant occupant;
    private int ligne;
    private int colone;

    /**
     * Constructeur public de la classe Cellule
     */
    public Cellule(int ligne, int colone, Occupant occupant){
        this.ligne = ligne;
        this.colone = colone;
        this.occupant = occupant;
    }

    /**
     * Méthode permettant de vérifier qu'une cellule est vide
     * @return vrai si la cellule est vide
     */
    @Override
    public boolean isEmpty(){
        return !(occupant != null &&
                (occupant.getClass() == Argent.class || occupant.getClass() == Drone.class || occupant.getClass() == Mur.class || occupant.getClass() == Voleur.class));
    }

    // Getters et setters
    @Override
    public int getCol(){
        return colone;
    }

    @Override
    public int getRow(){
        return ligne;
    }

    @Override
    public Occupant getOccupant(){
        return occupant;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColone(int colone) {
        this.colone = colone;
    }
}
