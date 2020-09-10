/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    
    // The amount of money entered by a customer so far.
    private int balance;
    
    // The total amount of money collected by this machine.
    private int total;
    
    // The pin entered by the user
    //private int pinEntered = -1;
    
    // The identification code for Visa
    private int CODE_VISA = 4950;
    
    // The identification code for MasterCard
    private int CODE_MASTERCARD = 5468;

    // Variable de type CreditCard permettant de stocker la référence vers la carte de l'utilisateur
    private CreditCard cc;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
    
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
    
            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }
    
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * Méthode permettant de créer une nouvelle carte
     * @param ID = numéro de la nouvelle carte
     * @param PIN = code confidentiel de la nouvelle carte
     */
    public void creerCarte(String ID, int PIN)
    {
        // Appel du constructeur de la classe CreditCard
        cc = new CreditCard(ID, PIN);
    }

    /**
     * Méthode permettant de vérifier que le code saisi est correct ou non
     * @param PIN = code PIN saisi par l'utilisateur
     * @return true si le PIN est le bon, false si le PIN est erroné
     */
    private boolean entrerCodePin(int PIN)
    {
        return cc.verifyPIN(PIN);
    }

    /**
     * Méthode permettant d'effecteur le paiement par carte
     * @param PIN = code PIN saisi par l'utilisateur
     */
    public void paiementCarte(int PIN)
    {
        // Nous vérifions d'abord que le code PIN est le bon
        boolean pin = entrerCodePin(PIN);

        if(!pin){
            // Si le code PIN est erroné, alors afficher un message significatif
            System.out.println("The pin you entered is incorrect");
        } else if(cc.getNumId() != CODE_VISA && cc.getNumId() != CODE_MASTERCARD){
            // Si le type de carte n'est pas le bon (Visa ou Mastercard), alors afficher un message significatif
            System.out.println("We only accept \"Visa\" and \"MasterCard\"");
        } else if(balance < price){
            // Si la balance est inférieur au prix d'un ticket, alors afficher un message significatif
            System.out.println("Not enough balance on this card.");
        } else{
            // Sinon, imprimer le ticket
            printTicket();
        }
    }
}
