/**
 * Classe permettant l’affichage d’un carré dans la console
 *
 * @author Kastriot Sahiti
 * @version 2020-02-08
 */
public class Carre
{
    //Pas de constructeur - constructeur par défaut défini par la JVM

    /**
     * Méthode permettant d'afficher un carré dans la console
     * @param n = taille du carré
     */
    public void afficheCarre(int n){
        // Pour chaque ligne
        for(int i=0; i<n; i++){
            // Pour chaque colone
            for(int j=0; j<n; j++){
                // S'il s'agit de la première ou dernière ligne, alors n'afficher que des étoiles
                if(i==0 || i==n-1){
                    System.out.print("* ");
                }else{
                    // Dans le cas où il ne s'agit pas de la première et dernière ligne, afficher des étoiles à la première et dernière colone (bords extérieurs du carré)
                    if(j==0 || j==n-1){
                        System.out.print("* ");
                    }

                    // S'il s'agit de la deuxième ou de l'avant dernière ligne, alors afficher des tirets
                    if(i==1 || i==n-2){
                        if(j>0 && j<n-1){
                            System.out.print("- ");
                        }
                    }else if(j>1 || j<n-1){
                        // Afficher des espaces pour tous les autres cas
                        if(j!=n-2){
                            // Afficher un espace s'il ne s'agit pas de l'avant dernière colone
                            System.out.print("  ");
                        }
                    }
                }
            }
            // Faire un retour à la ligne à chaque fois que i augmente de 1 (pour chaque nouvelle ligne)
            System.out.println();
        }
    }// Fin de la méthode afficheCarre
}
