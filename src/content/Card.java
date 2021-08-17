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
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] ranks = {"2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King", "Ace"};

    Card (int theCard) {
        setCardNum (theCard);
    }

    public void setCardNum (int theCard) {
        cardNum = (theCard >= 0 && theCard <= 51)? theCard: 0;
    }

    public int getCardNum() {
        return cardNum;
    }

    public String toString() {
        return ranks[cardNum%13] + " of " + suits[cardNum/13];
    }

    public String getSuit() {
        return suits[cardNum/13];
    }

    public String getRank() {
        return ranks[cardNum%13];
    }

    public int getValue() {
        return cardNum%13;
    }
}
