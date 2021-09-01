import java.util.*;


public class Shoe
{
    /**
     * Create instance variables
     */
    private ArrayList<Card> shoeAL;
    private final ArrayList<Card> discard;
    private int numDecks;

    /**
     * Creates a Shoe object and fills it with numDecks number of decks
     * @param int the number of decks in the shoe
     */
    public Shoe(int numDecks){
        shoeAL = new ArrayList<>();
        discard = new ArrayList<>();
        this.numDecks = numDecks;
        for(int i = 0; i < numDecks; i++){
            Deck d = new Deck();
            for(int j = 0; j < 52; j++){
                shoeAL.add(d.dealCard());
            }
        }
    }

    /**
     * This method returns the number of cards left in the shoe
     * @return the cards left in the shoe
     */
    public int getCardsLeft(){
        return shoeAL.size();
    }

    /**
     * This method returns the numebr of decks in the shoe
     * @return the number of decks in the shoe
     */
    public int getNumDecks(){
        return numDecks;
    }

    /**
     * This method adds a deck to the shoe
     */
    public void addDeck(){
        Deck d = new Deck();
        for(int i = 0; i < 52; i++){
            shoeAL.add(d.dealCard());
        }
        numDecks++;
    }

    /**
     * This method deals a card from the bottom of the shoe
     */
    public Card dealCard(){
        int topCard = shoeAL.size() - 1;
        Card dealt = shoeAL.get(topCard);
        discard.add(dealt);
        shoeAL.remove(topCard);
        return dealt;
    }

    /**
     * This method shuffles the deck into a random order
     */
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        int numTimes = shoeAL.size();
        for(int i = 0; i < numTimes; i++){
            int index = (int)(Math.random() * shoeAL.size());
            shuffled.add(shoeAL.get(index));
            shoeAL.remove(index);
        }
        shoeAL = shuffled;
    }

    /**
     * This method puts all of the cards back into the shoe
     * in a shuffled order
     */
    public void reshuffle(){
        shoeAL.addAll(discard);
        discard.clear();
        shuffle();
    }

    /**
     * This method returns a String representation of the shoe
     * @return each Card in the shoe
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Card card : shoeAL) {
            result.append(card).append("\n");
        }
        return result.toString();
    }
}

