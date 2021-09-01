import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.UIManager;  
import javax.swing.plaf.ColorUIResource;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Dealer
{
    //All JOptionPane tutorials from https://mkyong.com/swing/java-swing-how-to-make-a-simple-dialog/

    /**
     * Create instance variables
     */
    private Shoe s;
    private Hand dHand;
    private Player p;
    private Music m;
    private boolean dealerBust;
    private boolean playerW;
    private boolean blackJackCalled;
    private boolean pushCalled;
    private boolean fcc;

    /**
     * Creates a Dealer object with a player
     * @param Player the player
     */
    public Dealer(Player p){
        this.p = p;
        s = new Shoe(6);
        dHand = new Hand();
        m = new Music();
        playerW = false;
        dealerBust = false;
        blackJackCalled = false;
        pushCalled = false;
        fcc = false;
    }

    /**
     * Returns the dealer's hand
     * @return the dealer's hand
     */
    public Hand getDHand(){
        return dHand;
    }

    /**
     * Returns the game's shoe
     * @return the shoe
     */
    public Shoe getDShoe(){
        return s;
    }

    /**
     * Adds a card to the player's hand if they choose to hit
     */
    public void hit(){
        p.getPHand().addCard(s.dealCard());
    }

    /**
     * Deals with a push when the player and dealer get the same value
     */
    public void push(){
        p.payOut(p.getBet());
        pushCalled = true;
    }

    /**
     * Starts the game
     */
    public void startGame(){
        if(s.getCardsLeft() < 52){
            s.reshuffle();
        }
        JOptionPane.showMessageDialog(null, "Let's start the game!");
        p.placeBet();
        JOptionPane.showMessageDialog(null, "You bet $" + p.getBet() + "\n\nYour current bankroll is $" + p.getBankRoll());

        p.addCard(s.dealCard());
        dHand.addCard(s.dealCard());
        p.addCard(s.dealCard());
        dHand.addCard(s.dealCard());

        JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()));
        if(getDHand().getHand().get(1).getRank().equals("10") || getDHand().getHand().get(1).getRank().equals("Jack") || getDHand().getHand().get(1).getRank().equals("Queen") || getDHand().getHand().get(1).getRank().equals("King") || getDHand().getHand().get(1).getRank().equals("Ace")){
            JOptionPane.showMessageDialog(null, "The dealer is checking for Blackjack.");
            if(((getDHand().getValue() == 21) && (getDHand().getNumCards() == 2))){
                JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand() + "\n\nThe dealer has Blackjack!");
                blackJackCalled = true;
                if(!((p.getPHand().getValue() == 21) && (p.getPHand().getNumCards() == 2))){
                    results();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "The dealer does not have Blackjack.");
            }
        }
    }

    /**
     * Checks if the player has blackjack
     */
    public void blackJack(){
        if((p.getPHand().getValue() == 21) && (p.getPHand().getNumCards() == 2)){
            blackJackCalled = true;
            playerW = true;
            JOptionPane.showMessageDialog(null, "\nYou have Blackjack!");
            results();
        }
    }

    /**
     * Runs the player's whole turn
     */
    public void playersTurn(){
        int message = JOptionPane.showConfirmDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()) + "\n\nWould you like to Double Down?", "Select an Option...",JOptionPane.YES_NO_OPTION);
        if(message == JOptionPane.YES_OPTION && (p.getBet() * 2) <= p.getBankRoll()){
            p.doubleDown();
            p.getPHand().addCard(s.dealCard());
            JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()));
        }
        else if(message == JOptionPane.YES_OPTION && (p.getBet() * 2) > p.getBankRoll()){
            JOptionPane.showMessageDialog(null, "Sorry, you don't have enough money to double down.");
        }
        if((message == JOptionPane.NO_OPTION) || (message == JOptionPane.YES_OPTION && (p.getBet() * 2) > p.getBankRoll()) || (message == JOptionPane.CLOSED_OPTION)){
            String[] buttons = {"Hit", "Stay"};
            while(p.getPHand().getValue() <= 21){
                int option = JOptionPane.showOptionDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()) + "\n\nWhat would you like to do?", "Player's Move", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[1]);
                if(option == 0){
                    hit();
                    if((p.getPHand().getNumCards() == 5) && (p.getPHand().getValue() <= 21))
                    {
                        JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()) + "\n\nYou have 5 Card Charlie!");
                        fcc = true;
                        break;
                    }
                }
                else if(option == 1){
                    break;
                }
                else if(option == JOptionPane.CLOSED_OPTION){}
            }
        }
        if(p.getPHand().bust()){
            JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand().getHand().get(1) + "\nValue: " + getDHand().getHand().get(1).getValue(getDHand().getHand().get(1).getRank()) + "\n\nYou busted!");
            results();
        }
        if(fcc){
            results();
        }
    }

    /**
     * Runs the dealer's whole turn
     */
    public void dealersTurn(){
        JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand());
        while(dHand.getValue() < 17){
            dHand.addCard(s.dealCard());
            JOptionPane.showMessageDialog(null, "Your Hand: " + p.getPHand() + "\n\nDealer's Hand: " + getDHand());
        }
        if(getDHand().getValue() > 21){
            dealerBust = true;
        }
        results();
    }

    /**
     * Checks the results of the game
     */
    public void results(){
        if(p.getPHand().getValue() > 21){
            playerW = false;
        }
        else if(dealerBust){
            playerW = true;
        }
        else if(fcc){
            playerW = true;
        }
        else if(p.getPHand().getValue() > getDHand().getValue()){
            playerW = true;
        }
        else if(p.getPHand().getValue() < getDHand().getValue()){
            playerW = false;
        }
        else{
            push();
        }

        if(pushCalled){
            m.playMusic(new File("push.wav"));
            //https://www.freesoundslibrary.com/game-fail-sound-effect/
            JOptionPane.showMessageDialog(null, "Push!\n\nYour bankroll is now $" + p.getBankRoll());
        }
        else if(playerW){
            if(p.getPHand().getValue() == 21 && p.getPHand().getNumCards() == 2 && !pushCalled){
                double money = p.getBet() * 2.5;
                p.payOut((int)money);
            }
            else{
                p.payOut(p.getBet() * 2);
            }
            m.playMusic(new File("tada.wav"));
            //https://www.freesoundslibrary.com/tada-sound/
            JOptionPane.showMessageDialog(null, "You won!\n\nYour bankroll is now $" + p.getBankRoll());
        }
        else if(!playerW && !pushCalled){
            m.playMusic(new File("fail.wav"));
            //https://www.freesoundslibrary.com/fail-sound-effect/
            JOptionPane.showMessageDialog(null, "You lost.\n\nYour bankroll is now $" + p.getBankRoll());
        }
    }

    /**
     * Actually runs the game, calling all of the major methods
     */
    public void playGame(){
        startGame();
        blackJack();
        if(!blackJackCalled){
            playersTurn();
            if((!p.getPHand().bust()) && (!fcc)){
                dealersTurn();
            }
        }

        dealerBust = false;
        playerW = false;
        blackJackCalled = false;
        pushCalled = false;
        fcc = false;
    }

    /**
     * Returns a string representation of the Dealer's hand
     * @return a string representation of the Dealer's hand
     */
    public String toString(){
        return "The dealer has a current hand of: " + getDHand();
    }
}
