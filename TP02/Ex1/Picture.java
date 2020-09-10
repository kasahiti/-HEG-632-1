
/**
 * La classe Picture permet de représenter un image
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class Picture
{
    //Variables d'instance
    String picturePath;
    
    /**
     * Constructeur publique prenant comme paramètre un chemin vers un fichier image
     */
    public Picture(String path){
        picturePath = path;
    }
    
    /**
     * Méthode retournant le chemin vers une image
     */    
    public String getPicturePath(){
        return picturePath;
    }
}
