import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        String warrior = "Guardian";
        String ranger = "Arcane Musketeer";
        String mage = "Ember Witch";
        String kingdom = "Camelot";

        System.out.println("Echoes of War: The Guardian's Path");
        System.out.print("Enter your name: ");
        String playerName = scan.nextLine();

        ///////////////////////////read story
        gameLogic.readStory(playerName, kingdom, warrior, ranger, mage);
        ///////////////////////////////////////


        System.out.print("Choose mode (1-PVP/2-PVE): ");
        int chooseMode = scan.nextInt();
        // Start the game
        gameLogic.startGame(playerName, chooseMode);


 

        // Read character lore
        gameLogic.readCharacterLore();
        System.out.println("\nThank You for playing the game:)");
        scan.close(); // Close the scanner to prevent resource leaks
    }
}
