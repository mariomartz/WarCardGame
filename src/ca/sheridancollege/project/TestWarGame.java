package ca.sheridancollege.project;

import content.WarGame;
import content.WarPlayer;
import java.util.Scanner;

/**
 * This class +++Insert Description Here+++
 *
 * @author Mario Martinez
 */
public class TestWarGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instantiates WarGame subclass
        WarGame warGame = new WarGame();
        System.out.println(warGame.getName());
        
        // Prompts user to enter their userName
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String userName = input.nextLine();
        
        // Instantiates WarPlayer subclass to create 1 user controlled WarPlayer object
        WarPlayer user = new WarPlayer(userName);
        
        // Creates the player array list for the game to run
        warGame.createPlayerList(user);
        warGame.play();
        warGame.declareWinner();
        
    }
}
