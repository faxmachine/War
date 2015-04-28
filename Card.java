import java.util.*;

public class Card{   
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
    
    /*
        when the constructor is called the card suit and rank is determined by the 
        card number.
    **/
    public Card(int num){
        // make constant
        int SUIT_LENGTH = 13;
    
        // call the setCard method to set the card.
        setCard(num);
        
        // set the card value
        this.value = (num%SUIT_LENGTH);
    }
    
    /*
        sets the card 
    **/
    public void setCard(int num){
        // make variables
        int SUIT_LENGTH = 13;
        
        suit = suits[num/SUIT_LENGTH];
        rank = ranks[num%SUIT_LENGTH];     
    }
    
    public String getSuit(){
        return suit;
    }
    
    public String getRank(){
        return rank;
    }
    
    public String getFace(){
        // determine what file to use for wheather the card is
        // face up or down
        if(face_up == true)
            return getFrontFile();
        else
            return CARD_BACK;
    }
        
    public String getFrontFile(){
      return rank + suit + ".jpg";
    }
    
    public static void main(String Args[]){
        Card c = new Card(51);
        
        System.out.println(c.getFrontFile());
    }

    
}