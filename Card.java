/**
Ben Carroll 
4/29/15
Description: depending on the integer value entered in the constructor, a card is made from a 
choice of 52 cards.
*/

import java.util.*;

public class Card implements Cardable{   
    // all of the possible suits and ranks
    private String[] suits = {"h","d","c","s"};
    private String[]  ranks = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
    
    // Card suit and rank
    private String suit;
    private String rank;
    
    // filenames for the pictures
    private String CARD_BACK = "back.jpg";
    
    // is the card face up?
    private boolean face_up = true;
    
    // card rank value
    private int value;
    
    /**
        * Card method : when the constructor is called the card suit and rank is determined by the 
        * card number.
        * @param num the number out of 52 in the deck
    */
    public Card(int num){
        // make constant
        int SUIT_LENGTH = 13;
    
        // call the setCard method to set the card.
        setCard(num);
        
        // set the card value
        this.value = (num%SUIT_LENGTH);
    }
    
    /*
        *  set card : sets the card 
        * @param num the number to be set of the card
    **/
    public void setCard(int num){
        // make variables
        int SUIT_LENGTH = 13;
        
        suit = suits[num/SUIT_LENGTH];
        rank = ranks[num%SUIT_LENGTH];     
    }
    
    /*
        * gets the current card 
        * @return suit the current suit of the card
    **/
    public String getSuit(){
        return suit;
    }
    
    /*
        * gets the card 
        * @return rank the current rank of the card
    **/
    public String getRank(){
        return rank;
    }
    
    /*
        * gets the file name of a card 
        * @return rank+suit+".jpg" the file name
    **/       
    public String getFrontFile(){
      return rank + suit + ".jpg";
    }
    
    /*
        * gets the current value of the card 
        * @return value the current value of the card
    **/
    public int getValue(){
        return value;
    }
    
}