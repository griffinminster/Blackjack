public class DeckTester
{
   public static void main(String[] args)
   {
       Deck theDeck = new Deck();
       System.out.println(theDeck);
       System.out.println("EXPECTED: NEW DECK ORDER");
       
       System.out.println();
       
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("EXPECTED: ACE OF HEARTS");
       
       System.out.println(theDeck.getCardsLeft() + " Cards Remaining");
       System.out.println("EXPECTED: 51");
       
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("EXPECTED: 2 OF HEARTS");
       
       System.out.println(theDeck.getCardsLeft() + " Cards Remaining");
       System.out.println("EXPECTED: 50");
       
       System.out.println();
       
       theDeck.shuffle();
       System.out.println(theDeck);
       System.out.println("EXPECTED: SHUFFLED DECK");
       System.out.println(theDeck.getCardsLeft() + " Cards Remaining");
       System.out.println("EXPECTED: 50");
       
       System.out.println();
       
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("Dealt Card: " + theDeck.dealCard());
       System.out.println("Dealt Card: " + theDeck.dealCard());
       
       System.out.println(theDeck.getCardsLeft() + " Cards Remaining");
       System.out.println("EXPECTED: 45");
       
       System.out.println();
       
       theDeck.reshuffle();
       System.out.println(theDeck);
       System.out.println(theDeck.getCardsLeft() + " Cards Remaining");
       System.out.println("EXPECTED: FULL NEW SHUFFLED DECK, 52 CARDS");
   }
}