public class DealerTester
{
    public static void main(String[] args)
    {
        Player p = new Player("Kid", 1000);
        
        Dealer d = new Dealer(p);
        d.startGame();
        d.blackJack();
        d.playersTurn();
    }
}
