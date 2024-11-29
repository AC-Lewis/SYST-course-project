/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author aclew
 */
public class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     */
    public enum Suit{HEARTS,SPADES,CLUBS,DIAMONDS};
    
    public enum Value
    {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);
        private final int value;
        
        private Value(int value) {
        this.value = value;
    }

    };
    
    private Suit suit;
    private Value value;
    
    public Card(Suit s, Value v)
        {
            suit=s;
            value=v;
        }

    public Value getValue() 
    {
        return value;
    }
    
    public void setValue(Value val) 
    {
        this.value = val;
    }
    public void setSuit(Suit suit) 
    {
        this.suit = suit;
    }
    
    @Override
  public String toString()
  {
    return this.value + " of " + this.suit;   
  }

}
