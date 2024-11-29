/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author aclew
 */
public class Game 
{

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String name) 
    {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) 
    {
        this.players = players;
    }

    public void play()
    {
        GroupOfCards deck = new GroupOfCards();
        deck.createDeck();
        deck.shuffle();
        deck.shuffle();
        
        //players draw cards
        while(deck.getSize() >= 2) 
        {
            players.get(0).getCard(deck.topDeck());
            players.get(1).getCard(deck.topDeck());
        }
        players.get(0).useWinStack();
        players.get(1).useWinStack();
        
        Stack warBattle = new Stack();
        
        gameLoop : for(int i= 1; i<50;i++) 
        {
            if(!cardLimit(1)) break gameLoop;
            
            Card c1 = players.get(0).playCard();
            Card c2 = players.get(1).playCard();
            System.out.println("\nTurn" + i + ": ");
            System.out.println(players.get(0).getName() + ": " + c1 + " ");
            System.out.println(players.get(1).getName() + ": " + c2 + " ");
            
            if(c1.getValue().ordinal() > c2.getValue().ordinal()) 
            {
                players.get(0).getCard(c1);
                players.get(0).getCard(c2);
                System.out.println(players.get(0).getName()+ " gets card(s) ");
            }
            else if (c1.getValue().ordinal() < c2.getValue().ordinal()) 
            {
                players.get(1).getCard(c1);
                players.get(1).getCard(c2);
                System.out.println(players.get(0).getName()+ " gets card(s) ");
            }
            else // WAR happening
            {
                warBattle.clear(); //clearing pile of war cards
                warBattle.addCard(c1);
                warBattle.addCard(c2);
                boolean warOver = false;
                do 
                {                    
                    if (!cardLimit(2)){
                        break gameLoop;
                        }
                    System.out.println("\nA War has started, each player puts down ");
                    System.out.println(4 +" card(s)");
                    
                    for (int j = 1; j < 4; j++) 
                    {
                        c1 = players.get(0).playCard();
                        c2 = players.get(1).playCard();
                        warBattle.addCard(c1);
                        warBattle.addCard(c2);
                    }
                    System.out.println(players.get(0).getName() + ": " + c1 + " ");
                    System.out.println(players.get(1).getName() + ": " + c2 + " ");
                    if(c1.getValue().ordinal() > c2.getValue().ordinal()) 
                    {
                        players.get(0).getCards(warBattle);
                        warOver = true;
                    }
                    else if(c1.getValue().ordinal() < c2.getValue().ordinal()) 
                    {
                        players.get(1).getCards(warBattle);
                        warOver = true;
                    }
                    
                } while (!warOver); // end of 50 turns 
            }
            System.out.println(players.get(0).getCardsLeft() + " to " + players.get(1).getCardsLeft());
        }
    }
    
    
    public boolean cardLimit(int n) // check if player has N amount of cards
    {
    if (players.get(0).getCardsLeft()< n ) 
    {
        System.out.println(players.get(0).getName() +" has no more cards");
       return false; 
    }  
    else if (players.get(1).getCardsLeft()< n ) 
    {
        System.out.println(players.get(1).getName() +" has no more cards");
       return false; 
    }  
    return true;
    }
    
    
    public Player getWinner() // this method return the winner of the game
    {
        if (players.get(0).getCardsLeft() > players.get(1).getCardsLeft()) 
        {
            return players.get(0);
        } else if (players.get(1).getCardsLeft() > players.get(0).getCardsLeft()) 
        {
            return players.get(1);
        } else {
            return null;
        }
    }
}


