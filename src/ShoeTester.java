import java.util.*;


public class ShoeTester
{
    public static void main(String[] args)
    {
        Shoe shoe = new Shoe(2);
        System.out.println(shoe);
        System.out.println("Cards left: " + shoe.getCardsLeft());
        System.out.println("Num decks: " + shoe.getNumDecks());
        System.out.println("EXPECTED: 104 CARDS, 2 DECKS");
        
        System.out.println();
        
        shoe.addDeck();
        System.out.println(shoe);
        System.out.println("Cards left: " + shoe.getCardsLeft());
        System.out.println("Num decks: " + shoe.getNumDecks());
        System.out.println("EXPECTED: 156 CARDS, 3 DECKS");
        
        System.out.println();
        
        shoe.shuffle();
        System.out.println(shoe);
        System.out.println("EXPECTED: SHUFFLED SHOE");
        System.out.println("Cards left: " + shoe.getCardsLeft());
        System.out.println("Num decks: " + shoe.getNumDecks());
        System.out.println("EXPECTED: 156 CARDS, 3 DECKS");
        
        System.out.println();
        
        System.out.println("Dealt Card: " + shoe.dealCard());
        System.out.println("Dealt Card: " + shoe.dealCard());
        System.out.println("Dealt Card: " + shoe.dealCard());
        System.out.println("Dealt Card: " + shoe.dealCard());
        System.out.println("Dealt Card: " + shoe.dealCard());
        System.out.println();
        System.out.println(shoe);
        System.out.println("EXPECTED: SHUFFLED SHOE");
        System.out.println("Cards left: " + shoe.getCardsLeft());
        System.out.println("Num decks: " + shoe.getNumDecks());
        System.out.println("EXPECTED: 151 CARDS, 3 DECKS");
        
        System.out.println();
        
        shoe.reshuffle();
        System.out.println(shoe);
        System.out.println("EXPECTED: RESHUFFLED SHOE");
        System.out.println("Cards left: " + shoe.getCardsLeft());
        System.out.println("Num decks: " + shoe.getNumDecks());
        System.out.println("EXPECTED: 156 CARDS, 3 DECKS");
        
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many decks would you like in the shoe?");
        int c = sc.nextInt();
        sc.nextLine();
        System.out.println("Would you like to shuffle the shoe?");
        String response = sc.nextLine();
        Shoe shoe2 = new Shoe(c);
        if(response.equalsIgnoreCase("yes")){
            shoe2.shuffle();
        }
        System.out.println();
        System.out.println(shoe2);
        System.out.println("EXPECTED: SHOE WITH NUMBER OF DECKS FROM USER, SHUFFLE CHOSEN BY USER");
    }
}

