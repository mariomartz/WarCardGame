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
    private Player Player1;
    private Player Computer;
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
        this.Player1 = user;
        playerList.add(computer);
        this.Computer = computer;
        setPlayers(playerList);
    }
    
    @Override
    public void play() {
        // Instantiate GroupOfCards to create deck made up of 52 cards
        deck = new GroupOfCards(cardsInDeck);        
        // Populates the deck of cards, 4 suits and 13 cards for each suit
        for (int r = 1; r < 14; r++) {
            for (int c = 0; c < 4; c++) {
                deck.getCards().add(new Card(r, Card.suits[c]));
            }
        }           
        // Call shuffle method from GroupOfCards and shuffle deck
        deck.shuffle();
        // Create 2 ArrayList's based on the shuffled cards in the deck (one for the user, one for the computer)
        ArrayList<Card> userCards = new ArrayList<>();
        ArrayList<Card> computerCards =  new ArrayList<>();
        // Even cards are added to user ArrayList, odd cards are added to computer ArrayList
        for (Card card : deck.getCards()) {
            if (card.getCardNum() % 2 == 0) {
                userCards.add(card);
            } else {
                computerCards.add(card);
            }
        }
        // Create 2 GroupOfCards deck objects using the size of the 2 ArrayLists
        GroupOfCards playerDeck = new GroupOfCards(userCards.size());
        GroupOfCards computerDeck = new GroupOfCards(computerCards.size());
        // Set the cards in these GroupOfCards objects to the ones that were placed in the 2 ArrayLists earlier
        playerDeck.setCards(userCards);
        computerDeck.setCards(userCards);
        // Give the 2 GroupsOfCards to the player objects
        Player1.setCards(playerDeck);
        Computer.setCards(computerDeck); // This could be done better maybe (Computer)
        // Clear the userCards ArrayList and the computerCards ArrayList to be used as each players discard pile
        userCards.clear();
        computerCards.clear();
        // Draw the top card in each players deck
        Card playerTopCard = Player1.getCards().getTopCard();
        Card computerTopCard = Computer.getCards().getTopCard();
        
        // We need to compare the values of both cards that were drawn 
        
    }

    public Player compareCards(Card playerCard, Card computerCard) {
        // Holds the value of each card in a variable so that it can be referenced quickly
        int playerCardValue = playerCard.getCardNum();
        int computerCardValue = computerCard.getCardNum();
        // Checks if the value of the cards are equal
        if (playerCardValue != computerCardValue) {
            // if they are not equal, the winner will be the player with the higher value card
            if (playerCardValue > computerCardValue) {
                return Player1;
            } else {
                return Computer;
            }
            // if they are equal, the players go to war
        } else {
            return null;
        }  
    }
    @Override
    public void declareWinner() {
        
    }
}
