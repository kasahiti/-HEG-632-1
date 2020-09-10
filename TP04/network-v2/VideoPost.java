/**
 * Classe représentant un post de type vidéo.
 *
 * @author Kastriot Sahiti
 * @version 2020-05-16
 */
public class VideoPost extends Post{
    //Variables d'instances
    String filename;
    int duration;

    /**
     * Constructeur public de la classe VideoPost
     * @param author    auteur de la vidéo
     * @param filename  nom de la vidéo
     * @param duration  durée (en secondes) de la vidéo
     */
    public VideoPost(String author, String filename, int duration) {
        super(author);
        this.filename = filename;
        this.duration = duration;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Redéfinition de la méthode display de la classe Post.
     * Permet d'afficher la duration en minutes et en secondes.
     */
    @Override
    public void display(){
        // Calcul des minutes et des secondes à partir de la duration
        int minutes = (duration % 3600) / 60;
        int secondes = duration % 60;

        //Affichage de la duration
        System.out.println("Duration : " + minutes + " minutes et " + secondes + " secondes");
        super.display();
    }
}
