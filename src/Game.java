import javax.swing.JOptionPane;
import javax.swing.UIManager;  
import javax.swing.plaf.ColorUIResource;
import java.io.File;


public class Game
{
    public static void main(String[] args)
    {
        UIManager.put("OptionPane.background",new ColorUIResource(15,99,37));
        UIManager.put("Panel.background",new ColorUIResource(15,99,37));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(255,255,255));
        //https://www.roseindia.net/tutorial/java/swing/showtextcolor.html

        boolean playAgain = true;
        Player p = new Player("", 0);
        Dealer d = new Dealer(p);

        
        Music.playMusic(new File("casino.wav"));
        //https://freesound.org/people/lonemonk/sounds/100841/
        
        p.setName();
        p.setBankRoll();
        JOptionPane.showMessageDialog(null, "Your bankroll is $" + p.getBankRoll(), "Confirm Bankroll", JOptionPane.PLAIN_MESSAGE);
        d.getDShoe().shuffle();
        while(playAgain){
            d.playGame();
            int option = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again?",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION && p.getBankRoll() > 0){
                p.getPHand().reset();
                d.getDHand().reset();
            }
            else if(option == JOptionPane.YES_OPTION && p.getBankRoll() == 0){
                JOptionPane.showMessageDialog(null, "You are out of money.");
                playAgain = false;
            }
            else if(option == JOptionPane.NO_OPTION || option == JOptionPane.CLOSED_OPTION){
                playAgain = false;
            }
        }
        JOptionPane.showMessageDialog(null, "Thank you for playing!\nYou have a total of $" + p.getBankRoll());
        System.exit(0);
    }
}
