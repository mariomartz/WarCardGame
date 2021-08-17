/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package content;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author nusrath syed
 */
public class Card {
    
    private int cardNum;
    private String suit = "";
    public static final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

    public Card (int theCard, String suit) {
        this.cardNum = theCard;
        this.suit = suit;
    }

    public void setCardNum (int theCard) {
        cardNum = theCard;
    }

    public int getCardNum() {
        return cardNum;
    }

    @Override
    public String toString() {
        return cardNum + " of " + suit;
    }

    public String getSuit() {
        return suit;
    }
}
