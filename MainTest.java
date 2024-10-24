import java.util.Scanner;
////////////////WALA RANI DIRE RAKO NI TEST SA MGA GI PANG EXPERIMENT NAKO
public class MainTest {
    public static void xdd(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Choices c1 = new Choices();
        Choices c2 = new Choices();

        System.out.println("Echoes of War: The Guardian's Path");
        System.out.print("Enter your name: ");
        String playerName = scan.nextLine();
        System.out.print("Choose mode (1-PVP/2-PVE): ");
        int chooseMode = scan.nextInt();

        Player player1;
        Player player2; // Change Player2 to Player
        if (chooseMode == 1) {
            System.out.println("You have chosen player versus player!");
            c1.characterSelectionPVP1();
            Characters[] player1Characters = c1.getChosenChars();
            player1 = new Player(playerName, player1Characters);
            player1.displayCharacters(c1.getChosenCharacters());

            System.out.println("Player 1 has chosen. Press Enter for Player 2 to choose.");
            scan.nextLine(); // Consume the newline
            scan.nextLine(); // Wait for Enter

            c2.characterSelectionPVP2();
            Characters[] player2Characters = c2.getChosenChars();
            player2 = new Player("Player 2", player2Characters);
            player2.displayCharacters(c2.getChosenCharacters());
        } else {
            // Handle PVE mode if needed
            return;
        }







        int currentPlayer = 1;
        // Game loop for combat
        while (player1.hasAliveCharacters() && player2.hasAliveCharacters()) {
            System.out.println("-----------------------");
            if (currentPlayer == 1) {
                System.out.println("Player 1 turn");
                System.out.println("-----------------------");
                player1.combat(player1, player2); // Player 1 attacks
                currentPlayer = 2; // Switch to Player 2
            } else {
                if (player2.hasAliveCharacters()) {
                    System.out.println("-----------------------");
                    System.out.println("Player 2 turn");
                    player2.combat(player2, player1); // Player 2 attacks
                }
                currentPlayer = 1; // Switch to Player 1
            }
        }
        scan.close();
    }
}
