public class HandTester1
{
    public static void main(String[] args)
    {
        Hand h = new Hand();
        h.addCard(new Card("4", "Hearts"));
        h.addCard(new Card("5", "Spades"));
        System.out.println(h);
        System.out.println("EXPECTED: 4HEARTS, 5SPADES, 9VALUE, FALSE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        h.addCard(new Card("6", "Hearts"));
        System.out.println(h);
        System.out.println("EXPECTED: 4HEARTS, 5SPADES, 6HEARTS, 15VALUE, FALSE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        h.addCard(new Card("7", "Diamonds"));
        System.out.println(h);
        System.out.println("EXPECTED: 4HEARTS, 5SPADES, 6HEARTS, 7DIAMONDS, 22VALUE, FALSE BLACKJACK, TRUE BUST");
        
        System.out.println();
        
        //h.reset(new Card("Ace", "Spades"), new Card("2", "Spades"));
        System.out.println(h);
        System.out.println("EXPECTED: CLEARED HAND WITH ACESPADES, 2SPADES, 13VALUE, FALSE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        h.addCard(new Card("Ace", "Clubs"));
        System.out.println(h);
        System.out.println("EXPECTED: ACESPADES, 2SPADES, ACECLUBS 14VALUE, FALSE BLACKJACK, FALSE BUST");
        System.out.println();
        
        h.addCard(new Card("King", "Diamonds"));
        System.out.println(h);
        System.out.println("EXPECTED: ACESPADES, 2SPADES, ACECLUBS, KINGDIAMONDS, 14VALUE, FALSE BLACKJACK, FALSE BUST");
        System.out.println();
        
        //h.reset(new Card("Ace", "Spades"), new Card("2", "Spades"));
        System.out.println(h);
        System.out.println("EXPECTED: CLEARED HAND WITH ACESPADES, 2SPADES, 13VALUE, FALSE BLACKJACK, FALSE BUST");
        System.out.println();
        h.addCard(new Card("Ace", "Clubs"));
        System.out.println(h);
        System.out.println("EXPECTED: WITH ACESPADES, 2SPADES, ACECLUBS, 14VALUE, FALSE BLACKJACK, FALSE BUST");
        System.out.println();
        h.addCard(new Card("Ace", "Diamonds"));
        System.out.println(h);
        System.out.println("EXPECTED: ACESPADES, 2SPADES, ACECLUBS, ACEDIAMONDS, 15VALUE, FALSE BLACKJACK, FALSE BUST");
        System.out.println();
        h.addCard(new Card("King", "Hearts"));
        System.out.println(h);
        System.out.println("EXPECTED: ACESPADES, 2SPADES, ACECLUBS, ACEDIAMONDS, KINGDIAMONDS, 15VALUE, FALSE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        //h.reset(new Card("Jack", "Spades"), new Card("Ace", "Clubs"));
        System.out.println(h);
        System.out.println("EXPECTED: CLEARED HAND WITH JACKSPADES, ACECLUBS, 21VALUE, TRUE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        h.addCard(new Card("7", "Hearts"));
        System.out.println(h);
        System.out.println("EXPECTED: JACKSPADES, ACECLUBS, 7HEARTS, 18VALUE, FALSE BLACKJACK, FALSE BUST");
        
        System.out.println();
        
        h.addCard(new Card("4", "Clubs"));
        System.out.println(h);
        System.out.println("EXPECTED: JACKSPADES, ACECLUBS, 7HEARTS, 4CLUBS, 22VALUE, FALSE BLACKJACK, TRUE BUST");
        
        System.out.println();
        
        //h.reset(new Card("Ace", "Clubs"), new Card("2", "Hearts"));
        System.out.println(h);
        h.addCard(new Card("Ace", "Spades"));
        System.out.println(h);
        h.addCard(new Card("Ace", "Hearts"));
        System.out.println(h);
        h.addCard(new Card("8", "Spades"));
        System.out.println(h);
    }
}
