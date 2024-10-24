import java.util.Scanner;

public class GameLogic {
    private Choices c1 = new Choices();
    private Choices c2 = new Choices(); 
    private Story s1 = new Story(); 
    private WarriorLore w1 = new WarriorLore();
    private MageLore m1 = new MageLore(); 
    private RangerLore r1 = new RangerLore(); 
    private Scanner scan = new Scanner(System.in);
    private Player player1; 
    private Player player2 = null; 

    // Method to start the game based on player name and game mode
    public void startGame(String playerName, int gameMode) throws InterruptedException {
        // Character selection based on mode
        if (gameMode == 1) {//pvp
            System.out.println("You have chosen player versus player!");
            c1.characterSelectionPVP1(); // Player 1 selects characters
            Characters[] player1Characters = c1.getChosenChars(); // Get selected characters
            player1 = new Player("Player 1", player1Characters); // Create Player 1
            player1.displayCharacters(c1.getChosenCharacters()); // Display selected characters

            System.out.println("Player 1 has chosen. Press Enter for Player 2 to choose.");
            scan.nextLine(); // Consume the newline character
            scan.nextLine(); // w8 4 enter

            c2.characterSelectionPVP2(); // Player 2 selects characters
            Characters[] player2Characters = c2.getChosenChars(); // Get selected characters
            player2 = new Player("Player 2", player2Characters); // Create Player 2
            player2.displayCharacters(c2.getChosenCharacters()); // Display selected characters
            combatPVP(); // Start PVP combat
        } else if (gameMode == 2) { 
            System.out.println("You have chosen player vs environment!");
            c1.characterSelectionPVE(playerName);
            c1.selectCharacters(); 
            player1 = new Player(playerName, c1.getChosenChars()); 
            player1.displayCharacters(c1.getChosenCharacters());
            combatPVE(); 
        } else {
            System.out.println("Invalid game mode selected.");
        }
    }

    // Method for PVP combat logic
    private void combatPVP() {
        System.out.println("Combat starts!");
        int currentPlayer = 1; // Track which player's turn it is

        // Game loop for combat
        while (player1.hasAliveCharacters() && player2.hasAliveCharacters()) { // Continue until one player has no alive characters
            System.out.println("-----------------------");
            if (currentPlayer == 1) { 
                System.out.println("Player 1 turn");
                System.out.println("-----------------------");
                player1.combat(player1, player2); 
                currentPlayer = 2; 
            } else { // Player 2's turn
                if (player2.hasAliveCharacters()) {
                    System.out.println("Player 2 turn");
                    System.out.println("-----------------------");
                    player2.combat(player2, player1); // Player 2 attacks
                }
                currentPlayer = 1; // Switch back to Player 1
            }
        }
        // Determine and display the winner
        if (player1.hasAliveCharacters()) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║              Player 1 wins!            ║");
            System.out.println("╚════════════════════════════════════════╝");
        } else {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║              Player 2 wins!            ║");
            System.out.println("╚════════════════════════════════════════╝");
        }
    }

    // Placeholder for PVE combat logic
    private void combatPVE() {
        // Implement PVE combat logic here
    }

    public void readStory(String playerName, String kingdom, String warrior, String ranger, String mage) throws InterruptedException {
        System.out.print("Do you want to read the story? (1-YES/2-NO): ");
        int skip = scan.nextInt();

        if (skip == 1) {
            Thread.sleep(1000);
            s1.tellStoryIntro(playerName); 
            Thread.sleep(1000);
            s1.tellStoryKingdom(kingdom, playerName, warrior, ranger, mage);
            Thread.sleep(1000);
            s1.tellStoryEnd(playerName);
        }
    }

    // Method to read character lore based on player's choice
    public void readCharacterLore() throws InterruptedException {
        System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
        int loreChoice = scan.nextInt();
        if (loreChoice == 1) { 
            System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
            char classChoice = scan.next().charAt(0); 
            switch (classChoice) { // Handle class choice
                case 'W':
                    w1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    w1.tellCharLoreSupport(); 
                    break;
                case 'M':
                    m1.tellCharLoreAttack(); 
                    Thread.sleep(1000);
                    m1.tellCharLoreSupport(); 
                    break;
                case 'R':
                    r1.tellCharLoreAttack(); 
                    Thread.sleep(1000);
                    r1.tellCharLoreSupport();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter M, R, or W."); // Handle invalid choice
                    break;
            }
        }
    }
}
