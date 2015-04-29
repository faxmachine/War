import java.util.*;

public class Game{
    // make fields: deck and player decks;
    private MasterDeck master = new MasterDeck();
    private MasterDeck player1 = new MasterDeck();
    private MasterDeck player2 = new MasterDeck();
    private MasterDeck pile1 = new MasterDeck();
    private MasterDeck pile2 = new MasterDeck();
    
    private Card player1Card;
    private Card player2Card;
    
    /** game constructor
    */
    public Game(){
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
      *  decks are pulled and placed in their rescective piles
      *  @return winner the winner of the play
      */
    public String play(){
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
            takePile(player2);
            
            winner = "player1";
            return winner;
        }
            
        else if(pile2.getCard(0).getValue() > pile1.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player1);
            
            winner = "player2";
            return winner;
        }
        
        // otherwise there is a war
        else
            return war();
    }
    
    /** War
     *
     */
    public String war(){
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
        
        
        
        System.out.println("Player 1: "+pile1.getCard(0).getValue()+
        "   Player 2: "+pile2.getCard(0).getValue());
                
        // if player1 wins
        if(pile1.getCard(0).getValue() > pile2.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player2);          

            winner = "player1";
            return winner;
        }
        
        // ok, this looks really confusing but it is just comparing the values of the two cards
        else if(pile2.getCard(0).getValue() > pile1.getCard(0).getValue()){
            // add cards to player2's deck
            takePile(player1);
            
            winner = "player2";
            return winner;
        }
        
        // otherwise there is a war
        else 
           return  war();
        
    }
    
    /** take all cards in pile
     *
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
    
    /** get player1
     *
     */
    public MasterDeck getPlayer1(){
        return player1;
    } 
    
    /** get player2
     *
     */
    public MasterDeck getPlayer2(){
        return player2;
    }
    
    /** get pile1
     *
     */
    public MasterDeck getPile1(){
        return pile1;
    }
    
    /** get pile2
     *
     */
    public MasterDeck getPile2(){
        return pile2;
    }
    
    public Card getP1Card(){
        return player1Card;
    }
    
    public Card getP2Card(){
        return player2Card;
    }

 
    public static void main(String Args[]){
        Game game = new Game();
        
        game.deal();
        
        System.out.println(game.play());
        
    }
}