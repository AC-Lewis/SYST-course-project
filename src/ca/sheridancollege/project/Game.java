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
        //Creates the deck
        GroupOfCards deck = new GroupOfCards();
        deck.createDeck();
        deck.shuffle();
        deck.shuffle();
        
        //deals the cards to the players
        while(deck.getSize() >= 2) 
        {
            players.get(0).getCard(deck.topDeck());
            players.get(1).getCard(deck.topDeck());
        }
        players.get(0).useWinStack();
        players.get(1).useWinStack();
        
        //creating the stack of cards for the War
        Stack warBattle = new Stack();
        
        //loop ends after 50 turns or one player has no cards
        gameLoop : for(int i= 1; i<51;i++) 
        {
            if(!cardLimit(1)) break gameLoop;
            //Each player plays one card per turn
            Card c1 = players.get(0).playCard();
            Card c2 = players.get(1).playCard();
            //prints the turn number
            System.out.println("\nTurn" + i + ": ");
            System.out.println(players.get(0).getName() + " plays: " + c1 + " ");
            System.out.println(players.get(1).getName() + " plays: " + c2 + " ");
            
           /*
            Ordinals here seemed easier to implement than the compare method. May change later
            Used help from https://www.tutorialspoint.com/java/lang/enum_ordinal.htm
            */ 
            if(c1.getValue().ordinal() > c2.getValue().ordinal()) 
            {
                players.get(0).getCard(c1);
                players.get(0).getCard(c2);
                System.out.println(players.get(0).getName()+ " wins the turn ");
            }
            else if (c1.getValue().ordinal() < c2.getValue().ordinal()) 
            {
                players.get(1).getCard(c1);
                players.get(1).getCard(c2);
                System.out.println(players.get(1).getName()+ " wins the turn ");
            }
            //War conditions
            else 
            {
                //clears the current stack of cards
                warBattle.clear();
                warBattle.addCard(c1);
                warBattle.addCard(c2);
                boolean warOver = false;
                do 
                {                    
                    if (!cardLimit(2)){
                        break gameLoop;
                        }
                    System.out.println("\nA War has started, each player puts down 4 cards");
                    
                    //players put down 4 cards and compare the last one
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
                        System.out.println(players.get(0).getName()+ " has won the war and get 4 cards!");
                        warOver = true;
                    }
                    else if(c1.getValue().ordinal() < c2.getValue().ordinal()) 
                    {
                        players.get(1).getCards(warBattle);
                        System.out.println(players.get(1).getName()+ " has won the war and gets 4 cards!");
                        warOver = true;
                    }
                    
                } while (!warOver);  
            }//prints the current amount of cards each player has
            System.out.println("\n"+players.get(0).getName()+ " has " + players.get(0).getCardsLeft()+ " cards left \n" + players.get(1).getName()+ " has " 
                    + players.get(1).getCardsLeft()+" cards left \n");
        }
    }
    
    //checks if player has enough cards to continue
    public boolean cardLimit(int n)
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
    
    //Declares winner
    public Player getWinner() 
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


