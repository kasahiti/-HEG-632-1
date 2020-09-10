/**
 * Classe commentaire permettant de représenter un commentaire
 *
 * @author Kastriot Sahiti
 * @version 2020-05-16
 */
public class Commentaire{
    //Variables d'instance
    String author;
    String content;
    long timestamp;

    /**
     * Constructeur public de la classe Commentaire
     * @param author    auteur du commentaire
     * @param content   message du commentaire
     */
    public Commentaire(String author, String content) {
        this.author = author;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    //Getters et Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Méthode redéfinie toString
     * @return une String représentant le commentaire
     */
    @Override
    public String toString(){
        return "[" + author + "] : " + content + " - " + Post.timeString(timestamp)  + " seconds ago";
    }
}
