import java.util.ArrayList;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class Post 
{
    //Déclaration des variables d'instances
    private final String username;  // username of the post's author
    private final long timestamp;
    private int likes;
    private final ArrayList<Commentaire> comments;
    private final int MAX_DISPLAY_COMMENTS = 6;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(Commentaire text)
    {
        comments.add(text);
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        // Afffichage de l'auteur et du timestamp au format "human"
        System.out.println("Author : " + username);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            // S'il y a des commentaires dans la liste, tous les afficher (avec une limite à 6 comm. affichés)
            System.out.println("----Comments----");
            boolean tronq = false;

            //Pour chaque commentaire dans la liste, afficher tous les commentaires
            for (int i=0; i<comments.size(); i++){
                if (i<MAX_DISPLAY_COMMENTS){
                    System.out.println(i+1 + ") " + comments.get(i));
                }else {
                    // Si la liste continent plus de 6 commentaires, ne pas afficher le 7e et suivant, et quitter la boucle
                    tronq = true;
                    break;
                }
            }

            // Si nous avons quitté la boucle plus tôt, alors afficher ce message spécial
            if (tronq){
                System.out.println("Commentaires 6 sur " + comments.size());
            }
        }
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    public static String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
