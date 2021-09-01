import java.util.*;

public class Deck
{
    /**
     * Create instance variables
     */
    private ArrayList<Card> deckAL;
    private ArrayList<Card> discard;
    private ArrayList<String> suits;
    private ArrayList<String> ranks;

    /**
     * Creates a Deck object and fills the deck in new deck order
     */
    public Deck(){
        deckAL = new ArrayList<Card>();
        discard = new ArrayList<Card>();

        suits = new ArrayList<String>();
        ranks = new ArrayList<String>();

        suits.add("Spades");
        suits.add("Diamonds");
        suits.add("Clubs");
        suits.add("Hearts");

        ranks.add("Ace");
        for(int i = 2; i <= 10; i++){
            ranks.add(Integer.toString(i));
        }
        ranks.add("Jack");
        ranks.add("Queen");
        ranks.add("King");

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 13; j++){
                deckAL.add(new Card(ranks.get(j), suits.get(i)));
            }
        }
        for(int a = 2; a < 4; a++){
            for(int b = 12; b >= 0; b--){
                deckAL.add(new Card(ranks.get(b), suits.get(a)));
            }
        }
    }

    /**
     * This method returns the whole deck in its current form
     * @return the deck
     */
    public ArrayList<Card> getDeck(){
        return deckAL;
    }

    /**
     * This method returns the current top card (face down)
     * @return the top card
     */
    public Card dealCard(){
        int topCard = deckAL.size() - 1;
        Card dealt = deckAL.get(topCard);
        discard.add(dealt);
        deckAL.remove(topCard);
        return dealt;
    }

    /**
     * This method returns how many cards are in the deck
     * @return the size of the deck
     */
    public int getCardsLeft(){
        return deckAL.size();
    }

    /**
     * This method shuffles the deck into a random order
     */
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        int numTimes = deckAL.size();
        for(int i = 0; i < numTimes; i++){
            int index = (int)(Math.random() * deckAL.size());
            shuffled.add(deckAL.get(index));
            deckAL.remove(index);
        }
        deckAL = shuffled;
    }

    /**
     * This method puts all of the cards back into the deck
     * in a shuffled order
     */
    public void reshuffle(){
        for(int i = 0; i < discard.size(); i++){
            deckAL.add(discard.get(i));
        }
        discard.clear();
        shuffle();
    }

    /**
     * This method returns a string representation of the deck
     * @return each Card in the deck and its value
     */
    public String toString(){
        String result = "";
        for(int i = 0; i < deckAL.size(); i++){
            result += deckAL.get(i) + "\n";
        }
        return result;
    }
}

