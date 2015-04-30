/**
Ben Carroll 
4/29/15
Description: This is the class for an instance of a game of war..
*/

import java.util.*;

public class Game implements Gameable{
    // make fields: deck and player decks;
    private MasterDeck master = new MasterDeck();
    private MasterDeck player1 = new MasterDeck();
    private MasterDeck player2 = new MasterDeck();
    private MasterDeck pile1 = new MasterDeck();
    private MasterDeck pile2 = new MasterDeck();
    
    // set the initial message value
    private String message = "Click the button to play!";
    
    // the played cards of each player. This will help with the GUI later
    private Card player1Card;
    private Card player2Card;
    
    /** game constructor: deals out the cards to the players
    */
    public Game(){
        try{
        // populate the deck
        master.freshDeck();
        System.out.println("Master Deck has been populated");
        
                // shuffle the cards
        master.shuffle();
        System.out.println("Master Deck has been shuffled");
        
        // deal the cards
        deal();
        System.out.println("Cards have been dealt to the players");
        }
        
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        
        
        
    }
    
    /** deal the cards to the players
     *
     */
    public void deal(){
       // begin dealing all cards to each of the players
       while(!(master.isEmpty())){
           // deal a card to each of the players
           player1.addCard(master.dealCard());
           player2.addCard(master.dealCard());
       }
       
    }
    
    /** A general play between the two players. two cards from each of the players 
      *  decks are pulled and placed in their rescective piles. 
      *  when a war happens it calls war();
      */
    public void play(){
        // make a string for the winner
        String winner;
       
        // each player plays a card
        pile1.addCard(player1.dealCard());
        pile2.addCard(player2.dealCard());
        
        // print the results to the command line
        System.out.println("Player 1: "+pile1.getCard(0).getValue()+
        "   Player 2: "+pile2.getCard(0).getValue());
        
        // if player1 wins
        if(pile1.getCard(0).getValue() > pile2.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player1);
            
            //return winner;
            message = "The winner is player 1";
        }
            
        else if(pile2.getCard(0).getValue() > pile1.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player2);
            
            //return winner;
            message = "The winner is player 2";
        }
        
        // otherwise there is a war
        else
            //return war();
            war();
    }
    
    /** War. If another war happens within war() it simply makes a recursive call of war().
     *
     */
    public void war(){
        // let the war be known in the console
        System.out.println("War!");
        
        // make a winner
        String winner;
        
        // each player plays a card (face down)
        pile1.addCard(0,player1.dealCard());
        pile2.addCard(0,player2.dealCard());
        
        // each player plays a card (face up)
        pile1.addCard(0,player1.dealCard());
        pile2.addCard(0,player2.dealCard());
        
        
        // print the progress to the command line
        System.out.println("Player 1 card value: "+pile1.getCard(0).getValue()+
        "   Player 2 card value: "+pile2.getCard(0).getValue());
                
        // if player1 wins
        if(pile1.getCard(0).getValue() > pile2.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player1);          

            message = "There has been a war! Play one card face down then one up. The winner is player 1";
            //return winner;
        }
        
        // ok, this looks really confusing but it is just comparing the values of the two cards
        else if(pile2.getCard(0).getValue() > pile1.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player2);
            
            winner = "There has been a war! Play one card face down then one up. The winner is player 2";
            //return winner;
        }
        
        // otherwise there is a war
        else 
           //return  war();
           war();
        
    }
    
    /** take all cards in pile
     *  @param player the deck of a player
     */
    public void takePile(MasterDeck player){
        // save the cards for the gui
        player1Card = pile1.getCard(0);
        player2Card = pile2.getCard(0);
    
        for(int i = 0;i<pile1.cardsRemaining();i++){
            player.addCard(pile1.dealCard());
        }
        
        for(int i = 0; i<pile2.cardsRemaining();i++){
            player.addCard(pile2.dealCard());
        }
    }
    
    /** get player1. returns the deck of player 1
     * @return the deck of player 1
     */
    public MasterDeck getPlayer1(){
        return player1;
    } 
    
    /** get player2
     *  @return player2 the deck of player 2
     */
    public MasterDeck getPlayer2(){
        return player2;
    }
    
    /** get pile1. returns the card pile for player 1
     * @return pile1 the card pile for player 1
     */
    public MasterDeck getPile1(){
        return pile1;
    }
    
    /** get pile2. returns the pile for player 2
     * @return pile2 the card pile for player 2
     */
    public MasterDeck getPile2(){
        return pile2;
    }
  
    /** get the played card of player 1 for GUI
     * @return player1Card the played card for player 1
     */
    public Card getP1Card(){
        return player1Card;
    }
    
    /** get the played card of player 2 for GUI
     * @return player2Card the played card for player 2
     */
    public Card getP2Card(){
        return player2Card;
    }
    
    /** get messaage for the status of the game
     * @return message the game status
     */
    public String getMessage(){
        return message;
    }
    
    /** set messaage for the status of the game
     * @param message the game status
     */
    public void setMessage(String message){
        this.message = message;
    }
 
}