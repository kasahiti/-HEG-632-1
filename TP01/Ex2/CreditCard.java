/**
 * Classe permettant la création et la gestion d'une carte de crédit
 *
 * @author Kastriot Sahiti
 * @version 2020-02-08
 */
public class CreditCard
{
    // variables d'instance
    private String ID;
    private int codePIN;
    
    /**
     * Constructeur d'objets de classe CreditCard
     */
    public CreditCard(String ID, int PIN)
    {
        this.ID = ID;
        codePIN = PIN;
    }// Fin du constructeur CreditCard

    /**
     * Méthode permettant de vérifier que le PIN reçu en paramètre est égal au PIN de la carte
     * @param PIN = PIN à vérifier
     * @return true si le PIN est correct, false sinon
     */
    public boolean verifyPIN(int PIN)
    {
        if(codePIN != PIN){
            return false;
        }
        return true;
    }// Fin de la méthode verifyPIN

    /**
     * Méthode permettant de retourner les 4 premiers numéros de la carte
     * @return les 4 premiers numéros de la carte
     */
    public String getNumId(){
        // Nous récupérons d'abords les 4 premiers numéros, puis nous convertissons cette String en entier avec la méthode parseInt. Enfin, nous retournons cet entier.
        return Integer.parseInt(ID.substring(0,4));
    }// Fin de la méthode getNumId
}
