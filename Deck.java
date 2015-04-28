/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Jackie Horton
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   private ArrayList<Card> deck;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
            
   }
   
   /** 
    * Remove and return the top Card on the Deck
    * @return A reference to a Card that was top on the Deck
    */
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
  /** 
    * Return current number of Cards in Deck
    * @return number of Cards in Deck
    */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
  /** 
    * Determine if Deck is empty
    * @return true if there are no more cards, false otherwise
    */
   
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
   
}

