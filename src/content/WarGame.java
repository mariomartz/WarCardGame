package content;

import java.util.ArrayList;

/**
 * This class implements the Game class and allows for the creation of a WarGame object that contains all the rules
 * to run/manage/control/play the WarGame.
 * 
 * Game has a maximum of 2 players. One of those players is controlled by the computer.
 *
 * @author Mario Martinez
 */
public class WarGame extends Game {
    
    private GroupOfCards deck;
    private int cardsInDeck = 52;
    
    public WarGame() {
        super("War");
    }
    
    /**
     * Creates an ArrayList using the player controlled object and the computer controlled object.
     * This method ensures that the game is limited to 1 player and 1 computer.
     * 
     * @param user 
     */
    public void createPlayerList(Player user) {
        Player computer = new WarPlayer("Computer");
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(user);
        playerList.add(computer);
        setPlayers(playerList);
    }
    
    @Override
    public void play() {
        // Instantiate GroupOfCards to create deck made up of 52 cards
        deck = new GroupOfCards(cardsInDeck);
        // Call shuffle method from GroupOfCards
        deck.shuffle();
        // Create 2 smaller GroupOfCards based on the shuffled cards in the deck
        ArrayList<Card> userCards = new ArrayList<Card>();
        ArrayList<Card> computerCards =  new ArrayList<Card>();
        for (int i = 0; i < cardsInDeck; i++) {
            if (i < cardsInDeck/2) {
                //userCards.add(deck.getTopCard());
            } else {
                //computerCards.add(deck.getTopCard());
            }
        }
        // At this point, we can either hold the player and computer cards here, or transfer them into the
        // player objects
        
        // 
    }
    
    @Override
    public void declareWinner() {
        
    }
}
