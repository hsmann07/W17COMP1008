/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2sem2;

import java.util.ArrayList;

/**
 *
 * @author MANN
 */
public class GameOfWar {
  private  ArrayList<Card> p1Hand;
  private ArrayList<Card> p2Hand;  
  public GameOfWar()
  {
  p1Hand = new ArrayList<>();
  p2Hand = new ArrayList<>();
  
  DeckOfCards theDeck = new DeckOfCards();
  theDeck.shuffle();
  dealTheCards(theDeck);
  
  }//end of the constructor

    private void dealTheCards(DeckOfCards theDeck) {
     for(int cardNum = 0;cardNum < 52; cardNum++)
     {
         if(cardNum%2==0)
         {
         p1Hand.add(theDeck.dealTopCard());
         }
         else
         {
         p2Hand.add(theDeck.dealTopCard());
         }
     }
    }
    /*
    This method will simulate playing the game called "War"
    */
    public void playTheGame()
    {
    while(!p1Hand.isEmpty() && !p2Hand.isEmpty())
    {
    playHand();
    }
    
    if(p1Hand.isEmpty())
        System.out.println("Player 2 is the winner!");
    else
        System.out.println("Player1 is the winner!");
    }
    /*
    This method will simulate 1 hand at the game of war
    */

    private void playHand() {
       Card p1Card = p1Hand.remove(0);
       Card p2Card = p2Hand.remove(0);
       // Player 1's card is higher than player 2's card
       if(p1Card.getFaceValue()> p2Card.getFaceValue())
       {
       p1Hand.add(p1Card);
       p1Hand.add(p2Card);
       }
       
       // player 2's card is higher than player 1's
       else if(p2Card.getFaceValue()> p1Card.getFaceValue())
           {
       p2Hand.add(p1Card);
       p2Hand.add(p2Card);
       }
       
       // otherwise its's War
       else
       {
       ArrayList<Card> warPile = new ArrayList<>();
       warPile.add(p1Card);
       warPile.add(p2Card);
       playWarHand(warPile);
       }
    }// end of method playHand()
   /**
    * This method will stimulate playing the "war" hand
    */
    private void playWarHand(ArrayList<Card> warPile) {
        
        if(p1Hand.size() < 3)
        {
        p2Hand.addAll(p1Hand);
        p1Hand.clear();
        p2Hand.addAll(warPile);
        }
        // Check if player 2 had enough cards
        if(p2Hand.size() < 3)
        {
        p1Hand.addAll(p2Hand);
        p2Hand.clear();
        p1Hand.addAll(warPile);
        }
        
        warPile.add(p1Hand.remove(0));
         warPile.add(p1Hand.remove(0));
          warPile.add(p2Hand.remove(0));
           warPile.add(p2Hand.remove(0));
        
           Card p1Card = p1Hand.remove(0);
           Card p2Card = p2Hand.remove(0);
          


           //if player 1 wins 
           if(p1Card.getFaceValue() > p2Card.getFaceValue())
           {
           p1Hand.addAll(warPile);
           p1Hand.add(p1Card);
           p1Hand.add(p2Card);
           
           }
           //if player 2 wins
            if(p1Card.getFaceValue() > p2Card.getFaceValue())
           {
           p2Hand.addAll(warPile);
           p2Hand.add(p1Card);
           p2Hand.add(p2Card);
           
           }
            
            else{
            warPile.add(p1Card);
            warPile.add(p2Card);
            this.playWarHand(warPile);
            }
    }// end of playWarHand method
    
}//end of class
