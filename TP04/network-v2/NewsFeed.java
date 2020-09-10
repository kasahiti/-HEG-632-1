import java.util.ArrayList;
import java.util.Scanner;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application.
 *
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 *
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class NewsFeed
{
    //Variables de la classe NewsFeed
    private ArrayList<Post> posts;

    /**
     * Méthode main de la classe NewsFeed.
     * Permet de lire le fichier data.txt et appelle la fonction show pour afficher tous les posts ainsi que leurs commentaires.
     * @param args arguments de la console
     */
    public static void main(String[] args){
        // Nouvelle newsFeed
        NewsFeed newsFeed = new NewsFeed();

        // Tableau multidimensionnel représentant les données du fichier data.txt
        String[] data = FileToStr.lireCsv("data.txt");


        for (String str : data){
            // Nous remplissons les données du post en cours dans un tableau
            String[] donnee = str.split(";");

            /*En fonction du type de post, créer l'objet correspondant et l'ajouter à la liste "posts" par appel
            de la méthode "addPost" de newsFeed
             */
            switch (donnee[0].toLowerCase()){
                case "messagepost": newsFeed.addPost(new MessagePost(donnee[1], donnee[2]));
                                    break;
                case "photopost":   newsFeed.addPost(new PhotoPost(donnee[1], donnee[2], donnee[3]));
                                    break;
                case "videopost":   newsFeed.addPost(new VideoPost(donnee[1], donnee[2], Integer.parseInt(donnee[3])));
                                    break;
                default:            break; // Aucun traitement s'il ne s'agit pas d'un type de post connu
            }
        }

        //Affichage de tous les posts
        newsFeed.show();
    }

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();
    }

    /**
     * Add a post to the news feed.
     *
     * @param post  The post to be added.
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        // Déclaration et initialisation des variables permettant d'afficher des posts et d'enregistrer des commentaires
        Scanner scan = new Scanner(System.in);
        String nom;
        String message;
        boolean next = true;

        // Affiche tous les posts
        for(Post post : posts) {
            // Tant que l'utilisateur a saisi un commentaire avec un nom, continuer d'afficher le même post
            while (next){
                // Affichage du post en cours de traitement dans la liste
                post.display();

                // Enregistrement d'un commentaire
                System.out.println("\n Entrez votre nom :");
                nom = scan.nextLine();
                System.out.println("\n Entrez votre message :");
                message = scan.nextLine();

                // Si l'utilisateur n'a pas saisi de commentaire, alors passer au post suivant
                if (message.isEmpty() && nom.isEmpty()){
                    next = false;
                }else{
                    // Si l'utilisateur a saisi un commentaire, l'ajouter au post en cours, et boucler sur le même post
                    post.addComment(new Commentaire(nom, message));
                }
            }
            next = true;
        }

        //Dernier affichage de tous les posts avec leurs commentaires
        for (Post post : posts){
            post.display();
            System.out.println();
        }
    }
}
