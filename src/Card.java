import java.util.*;

public class Card
{
    /**
     * Create instance variables
     */
    private String rank;
    private String suit;

    /**
     * Creates a Card object with a rank and suit
     * @param String the rank of the card
     * @param String the suit of the card
     */
    public Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * This method returns the rank of the card
     * @return the rank
     */
    public String getRank(){
        return rank;
    }

    /**
     * This method returns the suit of the card
     * @return the suit
     */
    public String getSuit(){
        if(suit.equals("Spades")){
            suit = "\u2660";
        }
        else if(suit.equals("Hearts")){
            suit = "\u2665";
        }
        else if(suit.equals("Clubs")){
            suit = "\u2666";
        }
        else if(suit.equals("Diamonds")){
            suit = "\u2663";
        }
        //https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
        return suit;
    }

    /**
     * This method returns the actual value of the card
     * @param String the rank of the card
     * @return the true value of the card
     */
    public int getValue(String rank){
        if(rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")){
            return 10;
        }
        else if(rank.equals("Ace")){
            //return aceValue;
            return 11;
        }
        else{
            int value = Integer.parseInt(getRank());
            return value;
        }
    }

    /**
     * This method returns a string representation of the card
     * @return the rank, suit, and value
     */
    public String toString(){
        return getRank() + " of " + getSuit();
    }
}