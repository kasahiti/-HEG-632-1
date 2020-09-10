/**
 * Décrivez votre classe Personne ici.
 *
 * @author Kastriot Sahiti
 * @version 2020-04-12
 */
public class Personne
{
    //Variables d'instance
    String nom;
    String prenom;
    int age;
    String nationalite;
    
    //Constructeur public
    public Personne(String nom, String prenom, int age, String nationalite){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nationalite = nationalite;
    }
    
    /**
     * Méthode retournant le nom
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Méthode retournant le prénom
     */
    public String getPrenom(){
        return prenom;
    }
    
    /**
     * Méthode retournant l'age
     */
    public int getAge(){
        return age;
    }
    
    /**
     * Méthode retournant la nationalite
     */
    public String getNationalite(){
        return nationalite;
    }
    
    /**
     * Méthode redéfinie toString permettant d'afficher la personne
     */
    public String toString(){
        String str = nom.toUpperCase() + " " + prenom + " " + age + " ans, " + nationalite;
        return str;
    }
}
