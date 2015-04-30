/**
Ben Carroll
4/29
description: inferface for GameGUI class
*/

import java.util.*;

interface GUIable{
        
    // card dimensions
     final int CARDHEIGHT = 250;
     final int CARDWIDTH = 152;
    
    // update the card piles on display
    public void updatePiles();    
    
    // setup the cards and card panel
    public void CardSetup();
    
    // setup the button and the button panel
    public void ButtonPanelSetup();
      

} 
