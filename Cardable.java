/**
Ben Carroll
4/29
description: inferface for Card
*/

import java.util.*;

interface Cardable{
     // all of the possible suits and ranks
     String[] suits = {"h","d","c","s"};
     String[]  ranks = {"ace","2","3","4","5","6","7","8","9","10","jack","queen","king"};
    
        
    // filenames for the pictures
    String CARD_BACK = "back.jpg";
    
    // method for setting the card
    public void setCard(int num);

    // method for getting the suit
    public String getSuit(); 
       
    // method for getting the rank
    public String getRank();
    
    // method for getting the filename
    public String getFrontFile();    
    
    //method for getting the numerical value of the card
    public int getValue();

}