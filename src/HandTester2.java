public class HandTester2
{
    public static void main(String[] args)
    {
        Shoe s = new Shoe(4);
        s.shuffle();
        Hand h = new Hand();
        h.addCard(s.dealCard());
        h.addCard(s.dealCard());
        
        System.out.println(h);
        
        System.out.println();
        
        h.addCard(s.dealCard());
        System.out.println(h);
        
        System.out.println();
        
        h.addCard(s.dealCard());
        System.out.println(h);
        System.out.println("Num Cards in hand: " + h.getNumCards());
        System.out.println("EXPECTED: 4 CARDS DEALT OUT");
        
        System.out.println();
        
        //h.reset(s.dealCard(), s.dealCard());
        System.out.println(h);
        System.out.println("EXPECTED: RESET HAND, TWO NEW CARDS");
        
        System.out.println();
        
        System.out.println("Num Cards remaining in shoe: " + s.getCardsLeft());
        System.out.println("EXPECTED: 202");
        
        s.reshuffle();
        System.out.println("RESHUFFLED");
        System.out.println("Num Cards remaining in shoe: " + s.getCardsLeft());
        System.out.println("EXPECTED: 208");
    }
}

