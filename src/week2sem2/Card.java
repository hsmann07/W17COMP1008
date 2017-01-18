package week2sem2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MANN
 */
public class Card {
    private String faceName,suit;
    private int faceValue;
    public Card(String face,String suit,int value)
    {
    faceName= face;
    setSuit(suit);
    setValue(value);
    }
/**  This method will validate if the suit is valid(i.e Hearts,Diamonds,
*          Spades or Clubs
 */   
    private void setSuit(String suit)
{
if(suit.equalsIgnoreCase("hearts")||suit.equalsIgnoreCase("diamonds")||suit.equalsIgnoreCase("spades")||suit.equalsIgnoreCase("clubs"))
{
this.suit=suit;
        }
else
    throw new IllegalArgumentException("Suits must be hearts,diamonds,spadesor clubs");
    }
    /*
    this method will return a string to represent the card
    */
    public String toString()
    {
    return faceName + "of" + suit;
    }
    /*
    this will validate that the input is between 2-14and set the card value accordingly
    */
    private void setValue(int value)
    {
    if(value<2||value>14)
        throw new IllegalArgumentException("Face value must be 2-14 inclusive");
    else
    faceValue=value;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

}
