/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package content;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public ArrayList<Card> drawCards(int numCardsDrawn) {
        ArrayList<Card> drawnCards = new ArrayList<>();
        int cardsLeft = (cards.size() - numCardsDrawn);
        for (int i = cards.size(); i > cardsLeft; i--) {
            drawnCards.add(cards.get(i));
            cards.remove(i);
        }
        return drawnCards;
    }
    
    public Card getTopCard() {
        Card topCard = cards.get(size-1);
        cards.remove(cards.get(size-1));
        return topCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
