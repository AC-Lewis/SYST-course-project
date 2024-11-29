/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 *
 * @author aclew
 */
public class Stack {
    private ArrayList<Card> stack;
    private int top,bottom;
    
    public Stack()
    {
        stack = new ArrayList<>();
        top = 0;
        bottom = 0;
    }
    
    public int getSize()
    {
        return bottom - top;
    }
    
    public void clear()
    {
        top = 0;
        bottom = 0;
    }
    
    public void addCard(Card c)
    {
        stack.add(c);
        bottom++;
    }
    
    public void addCards(Stack s)
    {
        while (s.getSize() >0)
        {
            addCard(s.nextCard());
        }
    }
    
    public Card nextCard()
    {
        if(top == bottom) return null;
        
        Card c = stack.get(top);
        top++;
        return c;
    }
    
}
