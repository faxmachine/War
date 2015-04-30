/**
Ben Carroll
4/29
description: inferface for MasterDeck
*/

import java.util.*;

interface Deckable{
    /** 
   *  Number of cards in standard deck
   **/
   final int CARDS_IN_DECK = 52;
   
   // makes a fresh 52 card deck
   public void freshDeck();
   
   // gets a card at an index
   public Card getCard(int i);  
   
   // adds a card to the deck
   public void addCard(Card c);  
    
   // adds a card at an index
   public void addCard(int i, Card c);     
   
   // deals a card from the top
   public Card dealCard();   
   
   // gets the cards remaining in a deck
   public int cardsRemaining();   

   // shuffles the cards in a deck
   public void shuffle(); 

   // determns wheather a deck is empty or not
   public boolean isEmpty();
}
