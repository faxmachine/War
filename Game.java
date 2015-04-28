import java.util.*;

public class Game{
    // make fields: deck and player decks;
    private MasterDeck master = new MasterDeck();
    private MasterDeck player1 = new MasterDeck();
    private MasterDeck player2 = new MasterDeck();
    private MasterDeck pile1 = new MasterDeck();
    private MasterDeck pile2 = new MasterDeck();
    
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
        
        // if player1 wins
        if(pile1.getCard(0).getValue() > pile2.getCard(0).getValue()){
            // add cards to player2's deck
            player2.addCard(pile1.dealCard());
            player2.addCard(pile2.dealCard());
            
            winner = "player1";
        }
            
        else if(pile2.getCard(0).getValue() > pile1.getCard(0).getValue()){
            // add cards to player2's deck
            player1.addCard(pile1.dealCard());
            player1.addCard(pile2.dealCard());
            
            winner = "player2";
        }
        
        // otherwise there is a war
        else
            return war();
    }
    
    /** War
    */
    public String war(){
    
    }
    
    /** get player1
    */
    public MasterDeck getPlayer1(){
        return player1;
    } 
    
    /** get player2
    */
    public MasterDeck getPlayer2(){
        return player2;
    } 
    
    public static void main(String Args[]){
        Game game = new Game();
        
        game.deal();
        
        for(int i=0; i<26 ;i++){
          System.out.println(game.getPlayer2().dealCard().getFrontFile());
      }

        
    }
}