/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author aclew
 */
public class GroupOfCards 
{

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    
    public void createDeck()
    {
        int count = 0;
        cards = new ArrayList<>();
        
        for (Card.Suit s : Card.Suit.values())
        {
            for(Card.Value v: Card.Value.values())
            {
                cards.add(count, new Card(s,v));
                count++;
            }
        }
    }


    public void shuffle() 
    {
        Collections.shuffle(cards);
    }
    
    public Card topDeck()
    {
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() 
    {
        return cards.size();
    }

    public Card getCard(int index)
    {
        return this.cards.get(index);
    }


}//end class
