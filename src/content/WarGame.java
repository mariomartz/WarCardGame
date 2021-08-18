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
    private ArrayList<Card> warPool = new ArrayList<>();
    private Player Player1;
    private Player Computer;
    private int cardsInDeck = 52;
    private Player GameWinner = null;
    
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
                deck.getCardDeck().add(new Card(r, Card.suits[c]));
            }
        }           
        // Call shuffle method from GroupOfCards and shuffle deck
        deck.shuffle();
        // Create 2 ArrayList's based on the shuffled cards in the deck (one for the user, one for the computer)
        ArrayList<Card> userCards = new ArrayList<>();
        ArrayList<Card> computerCards =  new ArrayList<>();
        
        
        // Even cards are added to user ArrayList, odd cards are added to computer ArrayList
        for (int i = 0; i < deck.getCardDeck().size(); i++) {
            if (i % 2 == 0) {
                userCards.add(deck.getCardDeck().get(i));
            } else {
                computerCards.add(deck.getCardDeck().get(i));
            }
        }
        // Create 2 GroupOfCards deck objects using the size of the 2 ArrayLists
        GroupOfCards playerDeck = new GroupOfCards(userCards.size());
        GroupOfCards computerDeck = new GroupOfCards(computerCards.size());
        // Set the cards in these GroupOfCards objects to the ones that were placed in the 2 ArrayLists earlier
        playerDeck.setCardDeck(userCards);
        computerDeck.setCardDeck(computerCards);
        // Give the 2 GroupsOfCards to the player objects
        Player1.setCards(playerDeck);
        Computer.setCards(computerDeck);
        // Clear the userCards ArrayList and the computerCards ArrayList to be used as each players discard pile
        userCards.clear();
        computerCards.clear();
        // Draw the top card in each players deck
        int index = 0;
        boolean runGame = true;
        while (runGame) {
            if (Player1.getCards().getSize() == 0 || Computer.getCards().getSize() == 0) {
                runGame = false;
                break;
            }
            Card playerTopCard = Player1.getCards().getTopCard();
            Card computerTopCard = Computer.getCards().getTopCard();
            Player roundWinner = compareCards(playerTopCard, computerTopCard);
            if (roundWinner == Player1) {
                userCards.add(playerTopCard);
                userCards.add(computerTopCard);
            } else if (roundWinner == Computer) {
                computerCards.add(playerTopCard);
                computerCards.add(computerTopCard);
            } else {
                warPool.add(playerTopCard);
                warPool.add(computerTopCard);
                startWar(userCards, computerCards);
            }
            index++;
        }
        if (userCards.size() > computerCards.size()) {
            GameWinner = Player1;
        } else if (userCards.size() < computerCards.size()) {
            GameWinner = Computer;
        }
        
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
    
    public void startWar(ArrayList<Card> userCard, ArrayList<Card> computerCard) {
        if (Player1.getCards().getSize() > 3 && Computer.getCards().getSize() > 3) {
            int war = 3; // 3 Cards into the pool        
            for (int i = 0; i < war; i++) {
                warPool.add(Player1.getCards().getTopCard());
                warPool.add(Computer.getCards().getTopCard());
            }
        }
        Card playerFinalCard = Player1.getCards().getTopCard();
        Card computerFinalCard = Computer.getCards().getTopCard();
        warPool.add(playerFinalCard);
        warPool.add(computerFinalCard);
        Player warWinner = compareCards(playerFinalCard, computerFinalCard);
        if (warWinner == Player1) {
            userCard.addAll(warPool);
            warPool.clear();
        } else if (warWinner == Computer) {
            computerCard.addAll(warPool);
            warPool.clear();
        } else {
            startWar(userCard, computerCard);
        }
    }    
    
    @Override
    public void declareWinner() {
        if (GameWinner == null) {
            System.out.println("No winner!");
        } else if (GameWinner == Player1) {
            System.out.println("Winner is Player 1.");
        } else if (GameWinner == Computer) {
            System.out.println("Winner is Computer.");
        }
    }
}
