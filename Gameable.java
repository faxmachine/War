/**
Ben Carroll
4/29
description: inferface for Game class
*/

import java.util.*;

interface Gameable{    
    // set the initial message value
     String message = "Click the button to play!";
    
    // deal the cards to the piles
    public void deal();   
    
    // play a card from each deck and determine the winner
    public void play();
    
    // call this is there is a tie (this makes a recursive call if there is another war)
    public void war();
    
    // take the pile an add it to a deck
    public void takePile(MasterDeck player);
    
    // get player 1 deck
    public MasterDeck getPlayer1();     
    
    // get player 2 deck
    public MasterDeck getPlayer2();    
    
    // get player 1 pile
    public MasterDeck getPile1(); 
    
    // get player 2 pile
    public MasterDeck getPile2();  
    
    // get player 1 card 
    public Card getP1Card();
    
    // get player 2 card
    public Card getP2Card();    
            
    // set the status message
    public void setMessage(String message);
}
