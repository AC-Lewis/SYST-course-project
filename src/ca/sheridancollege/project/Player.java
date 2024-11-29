/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author aclew
 */
public class Player {

    private String name; //the unique name for this player

    private Stack playerStack, winStack;
    
    public Player(String name) 
    {
        this.name = name;
        playerStack = new Stack();
        winStack = new Stack();
    }


    public String getName() 
    {
        return name;
    }


    public void setName(String name) 
    {
        this.name = name;
    }

    public Card playCard()
    {
        if (playerStack.getSize() == 0)
            useWinStack();
        if(playerStack.getSize() > 0)
        
            return playerStack.nextCard();
        return null;
        
    }
    
    public void getCard(Card c)
    {
        winStack.addCard(c);
    }
    
    public void getCards(Stack s)
    {
        winStack.addCards(s);
    }
    
    public void useWinStack()
    {
        playerStack.clear();
        playerStack.addCards(winStack);
        winStack.clear();
    }
    
    public int getCardsLeft()
    {
       return playerStack.getSize() + winStack.getSize();
    }
    


}
