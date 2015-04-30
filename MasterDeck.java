/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Jackie Horton / Ben Carroll
 */

import java.util.Random;
import java.util.ArrayList;

public class MasterDeck {
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
   public MasterDeck()
   {
            deck = new ArrayList<Card>();
   }
   
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck(){
      for(int i=0; i<CARDS_IN_DECK; i++){
          deck.add(new Card(i));
      }      
   }
   
   /**
     * get a card at a certain index
     *
     */     
   public Card getCard(int i){
       return deck.get(i);
   }
   
   /**
     * Add a card to the bottom of the pile
     * @param c the card to be added
     */
   public void addCard(Card c){
       deck.add(c);
   }
   
   /**
     * an overloaded version of addCard for a specific index
     * @param c the card to be added
     */
   public void addCard(int i, Card c){
       deck.add(i,c);
   }
     
   
   /** 
     * Remove and return the top Card on the Deck
     * @return c reference to a Card that was top on the Deck
     */
   public Card dealCard(){
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining(){  
      return deck.size();
   }
   
   /** 
    * Randomize the order of Cards in Deck
    */
   public void shuffle(){
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */  
   public boolean isEmpty(){
      return (deck.size() == 0);
   }
  
}