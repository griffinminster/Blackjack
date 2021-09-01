import javax.swing.JOptionPane;


public class Player
{
    /**
     * Creates instance variables
     */
    private final Hand pHand;
    private int bankRoll;
    private int bet;
    private String name;
    private Shoe s;

    /**
     * Creates a Player object with a name and a bankroll
     * @param String the name of the Player
     * @param int the initial bankroll of the player
     */
    public Player(String name, int bankRoll){
        this.name = name;
        this.bankRoll = bankRoll;
        pHand = new Hand();
        s = new Shoe(6);
    }

    /**
     * Sets the name of the player
     */
    public void setName(){
        name = JOptionPane.showInputDialog(null, "What is your name?");
        if(name == null || name.equals("")){
            name = "Player";
        }
    }

    /**
     * Returns the player's hand
     * @return the player's hand
     */
    public Hand getPHand(){
        return pHand;
    }

    /**
     * Sets the initial bankroll of the player
     */
    public void setBankRoll(){
        boolean check = true;
        String theBankRoll = "";
        while(check){
            theBankRoll = JOptionPane.showInputDialog(null, "Hello " + getName() + "!\nWhat is your bankroll?");
            if(theBankRoll == null || theBankRoll.equals("")){
                check = false;
            }
            else{
                for(int i = 0; i < theBankRoll.length(); i++){
                    char c = theBankRoll.charAt(i);
                    if(!(Character.isDigit(c))){
                        check = false;
                        break;
                    }
                }
            }
            if(!check || theBankRoll.equals("0") || theBankRoll.length() > 9){
                check = true;
                JOptionPane.showMessageDialog(null,"Please enter a valid amount for your bankroll.");
            }
            else{
                check = false;
            }
        }
        bankRoll = Integer.parseInt(theBankRoll);
    }

    /**
     * Returns the player's bankroll
     * @return the player's current bankroll
     */
    public int getBankRoll(){
        return bankRoll;
    }

    /**
     * Returns the player's bet
     * @return the player's bet
     */
    public int getBet(){
        return bet;
    }

    /**
     * Returns the player's name
     * @return the player's name
     */
    public String getName(){
        return name;
    }

    /**
     * Allows the player to place a bet
     */
    public void placeBet(){
        boolean check = true;
        String theBet = "";
        while(check){
            theBet = JOptionPane.showInputDialog(null, "What is your bet?");
            if(theBet == null || theBet.equals("")){
                check = false;
            }
            else{
                for(int i = 0; i < theBet.length(); i++){
                    char c = theBet.charAt(i);
                    if(!(Character.isDigit(c))){
                        check = false;
                        break;
                    }
                }
            }
            if(!check || theBet.length() > 10 || Integer.parseInt(theBet) > getBankRoll() || theBet.equals("0")){
                check = true;
                JOptionPane.showMessageDialog(null,"Please enter a valid bet.");
            }
            else{
                check = false;
            }
        }
        bet = Integer.parseInt(theBet);
        bankRoll -= bet;
    }

    /**
     * Allows the player to double down, if called in the Dealer class
     */
    public void doubleDown(){
        bankRoll -= bet;    
        bet *= 2;
        JOptionPane.showMessageDialog(null, "Your updated bet is $" + getBet(), "Updated Bet", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Adds a card to the player's hand
     * @param Card the card being added to the player's hand
     */
    public void addCard(Card c){
        pHand.addCard(c);
    }

    /**
     * Pays the money to the player's bankroll after a round
     * @param int the money to be payed out
     */
    public void payOut(int money){
        bankRoll += money;
    }

    /**
     * Returns a string representation of the Player
     * @return a String of the player
     */
    public String toString(){
        return "Player " + getName() + " has a bankroll of $" + getBankRoll() + ", a bet of $" + getBet() + ", and their current hand is: " + getPHand();
    }
}