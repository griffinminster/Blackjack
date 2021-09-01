import java.util.*;

public class CardTester
{
    public static void main(String[] args)
    {
        Card fourSpades = new Card("4", "Spades");
        System.out.println(fourSpades);
        
        Card queenHearts = new Card("Queen", "Hearts");
        System.out.println(queenHearts);
        
        Card jackClubs = new Card("Jack", "Clubs");
        System.out.println(jackClubs);
        
        Card sixDiamonds = new Card("6", "Diamonds");
        System.out.println(sixDiamonds);
        
        System.out.println(new Card("Ace", "Spades"));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the rank?");
        String scanRank = sc.nextLine();
        System.out.println("What is the suit?");
        String scanSuit = sc.nextLine();
        System.out.println(new Card(scanRank, scanSuit));
    }
}