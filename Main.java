import java.util.Scanner;
    public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        String warrior = "Guardian";
        String ranger = "Arcane Musketeer";
        String mage = "Ember Witch";
        String kingdom = "Camelot";

       gameLogic.gameTitle();
        String playerName = gameLogic.name();
        ///////////////////////////read story
        gameLogic.readStory(playerName, kingdom, warrior, ranger, mage);
        ///////////////////////////////////////
        // Start the game
        gameLogic.startGame(playerName, gameLogic.chooseMode());
        ///////////////////////////////////
        // Read character lore////////////
        gameLogic.readCharacterLore();
        /////////////////////////////////
        gameLogic.thank();
        scan.close(); // Close the scanner to prevent resource leaks
    }
}
