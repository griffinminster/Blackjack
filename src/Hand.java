import java.util.*;

public class Hand
{
    /**
     * Create instance variables
     */
    private final ArrayList<Card> handAL;
    private int aceCount;
    private static boolean bust;
    private static boolean blackjack;

    /**
     * Creates a hand object
     */
    public Hand(){
        handAL = new ArrayList<>();
        aceCount = 0;
        bust = false;
    }

    /**
     * This method returns the whole hand in its current form
     * @return the hand
     */
    public ArrayList<Card> getHand(){
        return handAL;
    }

    /**
     * This method adds a card to the hand
     */
    public void addCard(Card c){
        handAL.add(c);
    }

    /**
     * This method returns the total value of the hand
     * @return the hand's value
     */
    public int getValue(){
        //System.out.println("Get Value called");
        bust = false;
        blackjack = false;
        aceCount = 0;
        int totalValue = 0;
        for(int i = 0; i < getNumCards(); i++){
            totalValue += handAL.get(i).getValue(handAL.get(i).getRank());
            if((handAL.get(i).getRank().equals("Ace"))){
                aceCount++;
            }
            //System.out.println("Total Value adding cards " + totalValue);
        }
        for(int i = 0; i < aceCount; i++){
            //System.out.println("aceCount for loop;" + aceCount);
            if(totalValue > 21){
                totalValue -= 10;
                //System.out.println("Total value with ace conversion " + totalValue);
            }
        }
        if(totalValue > 21){
            bust = true;
        }
        if(totalValue == 21 && getNumCards() == 2){
            blackjack = true;
        }
        return totalValue;
    }

    /**
     * This method returns the number of cards in the hand
     * @return the size of the hand
     */
    public int getNumCards(){
        return handAL.size();
    }

    /**
     * This method clears and resets the hand
     * @param Card new first card in hand
     * @param Card new second card in hand
     */
    public void reset(/*Card one, Card two*/){
        handAL.clear();
        // handAL.add(one);
        // handAL.add(two);
    }

    /**
     * This method checks if the hand has busted
     * @return if the hand is a bust
     */
    public boolean bust(){
        return bust;
    }

    /**
     * This method checks if the hand is a blackjack
     * @return if the hand is a blackjack
     */
    public boolean blackjack(){
        return blackjack;
    }

    /**
     * This method returns a string representation of the hand
     * @return each Card in the hand along with the hand's total value, blackjack condition, and bust condition
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < getNumCards(); i++){
            result.append(handAL.get(i)).append("   ");
        }
        result.append("\nValue: ").append(getValue())/* + "\nBlackjack: " + blackjack() + "\nBust: " + bust()*/;
        return result.toString();
    }
}

