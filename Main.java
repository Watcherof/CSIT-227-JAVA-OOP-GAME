import java.util.Scanner;
    public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();

        gameLogic.gameTitle();
        String playerName = gameLogic.name();
        ///////////////////////////read story
        gameLogic.readStory(playerName);
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
