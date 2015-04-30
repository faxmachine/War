/**
Ben Carroll 
4/29/15
Description: This is the GUI for the main program.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements GUIable{
    // make instance of the game
    private Game game = new Game();

    // make JFrame fields
    private JPanel CardPanel, StatusPanel;  // break up regions
    private JPanel ButtonPanel;  // game status
    private ImageIcon backimage;
    
    // make piles and decks private to the class
    private JLabel player1_pile = new JLabel(" | Player 1 pile |");
    private JLabel player2_pile = new JLabel(" | Player 2 pile |");
    private JLabel player1_deck = new JLabel(" | Player 1 deck |");
    private JLabel player2_deck = new JLabel("| Player 2 deck |");
    private JLabel message = new JLabel(game.getMessage());
    
    //button
    private JButton button;
    
    
    // card dimensions
    private final int CARDHEIGHT = 250;
    private final int CARDWIDTH = 152;
    
    /** the constructor of the game GUI it makes an instance of the game
     *  and sets up the panels
     */
    public GameGUI(){
        try{ 
        // set the grid layout
        setLayout(new GridLayout(2,1));
        
        // setup the Card Panel
        CardSetup();
                
        // setup the Button Panel
        ButtonPanelSetup();
        }
        
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
    
    /** updates the cards in the piles that are being shown
     * 
     */
    public void updatePiles(){
        // get the cards from the piles
        Card top1, top2;
        top1 = game.getP1Card();
        top2 = game.getP2Card();
                
                
        player1_pile.setIcon(new ImageIcon("cards/"+top1.getFrontFile()));
        player2_pile.setIcon(new ImageIcon("cards/"+top2.getFrontFile()));
        
        CardPanel.add(player1_deck);
        CardPanel.add(player1_pile);
        CardPanel.add(player2_pile);
        CardPanel.add(player2_deck);
        
        // update the message
        message.setText(game.getMessage());
        ButtonPanel.add(message);

    }
    
    /** CardSetup sets up the cards in the CardPanel
     * 
     */
    public void CardSetup(){
        try{
        // setup the Card Panel
        CardPanel = new JPanel();
        CardPanel.setBackground(Color.green);
        //CardPanel.setLayout(new );
        
        //make player 1 deck and pile 
         
        player1_deck.setVerticalTextPosition(JLabel.TOP); 
        player1_deck.setHorizontalTextPosition(JLabel.CENTER); 
        player1_deck.setIcon(new ImageIcon("cards/back.jpg"));
        
        //make player 1 deck and pile 
        
        player1_pile.setVerticalTextPosition(JLabel.TOP); 
        player1_pile.setHorizontalTextPosition(JLabel.CENTER);
        player1_pile.setPreferredSize(new Dimension(CARDWIDTH, CARDHEIGHT)); 
        player1_pile.setIcon(new ImageIcon("cards/back.jpg"));
        
        //make player 1 deck and pile 
     
        player2_pile.setVerticalTextPosition(JLabel.TOP); 
        player2_pile.setHorizontalTextPosition(JLabel.CENTER);
        player2_pile.setPreferredSize(new Dimension(CARDWIDTH, CARDHEIGHT));  
        player2_pile.setIcon(new ImageIcon("cards/back.jpg"));
        
        //make player 1 deck and pile 
        
        player2_deck.setVerticalTextPosition(JLabel.TOP); 
        player2_deck.setHorizontalTextPosition(JLabel.CENTER);   
        player2_deck.setIcon(new ImageIcon("cards/back.jpg"));
                
        CardPanel.add(player1_deck);
        CardPanel.add(player1_pile);
        CardPanel.add(player2_pile);
        CardPanel.add(player2_deck);
        
        // add the panel
        add(CardPanel);
        }
        
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    
    /** sets up the button and the status message
     * 
     */
    public void ButtonPanelSetup(){
        // setup the Button Panel
        ButtonPanel = new JPanel();
        ButtonPanel.setBackground(Color.blue);
        
        // setup the button
        button = new JButton("Play cards");
        ButtonPanel.add(button); 
        button.addActionListener(new ButtonListener());
       
        // setup message
        //message.setVerticalTextPosition(JLabel.TOP); 
        //message.setHorizontalTextPosition(JLabel.CENTER);
        message.setForeground(Color.white);
        
        ButtonPanel.add(message);
       
        // add the panel 
        add(ButtonPanel);
        
    } 
    
    // private inner class 
    class ButtonListener implements ActionListener{
        /** actionPerformed: once an action has been detected it does the code in this method
          * @param e the event performed
          */
        public void actionPerformed (ActionEvent e){  
            // start the play      
            game.play();
                      
            // print the results to the command line
            System.out.println("Player 1 Cards left: "+game.getPlayer1().cardsRemaining());
            System.out.println("Player 2 Cards left: "+game.getPlayer2().cardsRemaining());
            
            // if one of the players is out of cards they win
            if(game.getPlayer1().cardsRemaining() == 0){
                // disable the button
                button.setEnabled(false);
                game.setMessage("Player 1 wins!");
            }
            else if(game.getPlayer2().cardsRemaining() == 0){
                // disable the button
                button.setEnabled(false);
                game.setMessage("Player 2 wins!");
            }
            // update the piles on the screen
            updatePiles();
            
                        
         
      }
   }
      
    
    public static void main(String Args[]){
      final int WIDTH = 630;
      final int HEIGHT = 600;
    
      JFrame frame = new GameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
      frame.validate();
      frame.setVisible(true);
    }
}