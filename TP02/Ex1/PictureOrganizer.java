import java.util.ArrayList;
import java.util.Collections;
/**
 * La classe PictureOrganizer permet d'effectuer toutes les actions (lecture de l'image, previous, next, lectureAleatoire, etc.)
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class PictureOrganizer
{
     // An ArrayList for storing music tracks.
    private ArrayList<Picture> pictures;
    // A player for the music tracks.
    private PicturePlayer player;
    // A reader that can read music files and load them as tracks.
    private PictureReader reader;
    
    private int indexPictureDisplayed = -1;

    /**
     * Constructor for objects of class PictureOrganizer
     */
    public PictureOrganizer()
    {
        pictures = new ArrayList<>();
        player = new PicturePlayer();
        reader = new PictureReader();
        readLibrary("pictures");
        System.out.println("Picture library loaded. " + getNumberOfPictures() + " pictures.");
        System.out.println();
        
    }
    
    private void readLibrary(String folderName)
    {
        ArrayList<Picture> tempPictures = reader.readPictures(folderName, ".jpg");
        for(Picture picture : tempPictures) {
            addPicture(picture);
        }
    }

    public void addPicture(Picture picture)
    {
        pictures.add(picture);
    }
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfPictures()
    {
        return pictures.size();
    }
    
    public void showFirstPicture(){
        if(pictures.size() > 0) {
            player.playPicture(pictures.get(0).getPicturePath());
            indexPictureDisplayed = 0;
        }
    }
    
    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= pictures.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    public void showPicture(int index)
    {
        if(indexValid(index)) {
            Picture picture = pictures.get(index);
            player.playPicture(picture.getPicturePath());
            indexPictureDisplayed = index;
        }
    }
    
    /**
     * Fonction permettant de rendre la lecture aléatoire en mélangeant les images dans l'ArrayList pictures
     */
    public void lectureAleatoire(){
        //Mélange toutes les images dans la liste "pictures"
        Collections.shuffle(pictures);
    }
    
    /**
     * Fonction permettant d'afficher la prochaine image.
     */
    public void next(){
        //S'il n'y a aucune image dans pictures, ne rien faire.
        if(pictures.size() > 0) {
            //Si nous voulons afficher la prochaine image mais que nous sommes à la dernière image de pictures, alors afficher la première image de pictures
            if(indexPictureDisplayed == pictures.size()-1){
                indexPictureDisplayed = 0;
            }else{
                indexPictureDisplayed++;
            }
            
            //Appel de la fonction playPicture en lui donnant l'index de l'image à afficher
            player.playPicture(pictures.get(indexPictureDisplayed).getPicturePath());
        }
    }
    
    /**
     * Fonction permettant d'afficher l'image précédente.
     */
    public void previous(){
        //S'il n'y a aucune image dans pictures, ne rien faire.
        if(pictures.size() > 0) {
            //Si nous voulons afficher l'image précédente mais que nous sommes à la première image de pictures, alors afficher la dernière image de pictures
            if(indexPictureDisplayed == 0){
                indexPictureDisplayed = pictures.size()-1;
            }else{
                indexPictureDisplayed--;
            }
            
            //Appel de la fonction playPicture en lui donnant l'index de l'image à afficher
            player.playPicture(pictures.get(indexPictureDisplayed).getPicturePath());
        }
    }
}
