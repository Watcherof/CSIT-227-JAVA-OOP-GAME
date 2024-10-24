import java.util.Scanner;

public class GameLogic {
    private Choices c1 = new Choices(); // Choice object for Player 1
    private Choices c2 = new Choices(); // Choice object for Player 2
    private Story s1 = new Story(); // Story object to manage story-related methods
    private WarriorLore w1 = new WarriorLore(); // Lore object for Warrior class
    private MageLore m1 = new MageLore(); // Lore object for Mage class
    private RangerLore r1 = new RangerLore(); // Lore object for Ranger class
    private Scanner scan = new Scanner(System.in); // Scanner for user input
    private Player player1; // Player 1 object
    private Player player2 = null; // Player 2 object (initially null)

    // Method to start the game based on player name and game mode
    public void startGame(String playerName, int gameMode) throws InterruptedException {
        // Character selection based on mode
        if (gameMode == 1) { // PVP Mode
            System.out.println("You have chosen player versus player!");
            c1.characterSelectionPVP1(); // Player 1 selects characters
            Characters[] player1Characters = c1.getChosenChars(); // Get selected characters
            player1 = new Player("Player 1", player1Characters); // Create Player 1
            player1.displayCharacters(c1.getChosenCharacters()); // Display selected characters

            System.out.println("Player 1 has chosen. Press Enter for Player 2 to choose.");
            scan.nextLine(); // Consume the newline character
            scan.nextLine(); // Wait for Enter

            c2.characterSelectionPVP2(); // Player 2 selects characters
            Characters[] player2Characters = c2.getChosenChars(); // Get selected characters
            player2 = new Player("Player 2", player2Characters); // Create Player 2
            player2.displayCharacters(c2.getChosenCharacters()); // Display selected characters
            combatPVP(); // Start PVP combat
        } else if (gameMode == 2) { // PVE Mode
            System.out.println("You have chosen player vs environment!");
            c1.characterSelectionPVE(playerName); // Player selects characters for PVE
            c1.selectCharacters(); // Finalize character selection
            player1 = new Player(playerName, c1.getChosenChars()); // Create Player 1 for PVE
            player1.displayCharacters(c1.getChosenCharacters()); // Display selected characters
            combatPVE(); // Start PVE combat
        } else {
            System.out.println("Invalid game mode selected."); // Handle invalid mode selection
        }
    }

    // Method for PVP combat logic
    private void combatPVP() {
        System.out.println("Combat starts!"); // Notify start of combat
        int currentPlayer = 1; // Track which player's turn it is

        // Game loop for combat
        while (player1.hasAliveCharacters() && player2.hasAliveCharacters()) { // Continue until one player has no alive characters
            System.out.println("-----------------------");
            if (currentPlayer == 1) { // Player 1's turn
                System.out.println("Player 1 turn");
                System.out.println("-----------------------");
                player1.combat(player1, player2); // Player 1 attacks
                currentPlayer = 2; // Switch to Player 2
            } else {
                if (player2.hasAliveCharacters()) { // Check if Player 2 has alive characters
                    System.out.println("-----------------------");
                    System.out.println("Player 2 turn");
                    player2.combat(player2, player1); // Player 2 attacks
                }
                currentPlayer = 1; // Switch back to Player 1
            }
        }
    }

    // Placeholder for PVE combat logic
    private void combatPVE() {
        // Implement PVE combat logic here
    }

    // Method to read the story based on player choice
    public void readStory(String playerName, String kingdom, String warrior, String ranger, String mage) throws InterruptedException {
        System.out.print("Do you want to read the story? (1-YES/2-NO): ");
        int skip = scan.nextInt(); // Get player's choice to read the story

        if (skip == 1) { // If player wants to read the story
            Thread.sleep(1000); // Pause for dramatic effect
            s1.tellStoryIntro(playerName); // Tell story intro
            Thread.sleep(1000); // Pause for dramatic effect
            s1.tellStoryKingdom(kingdom, playerName, warrior, ranger, mage); // Tell story about the kingdom
            Thread.sleep(1000); // Pause for dramatic effect
            s1.tellStoryEnd(playerName); // Tell story end
        }
    }

    // Method to read character lore based on player's choice
    public void readCharacterLore() throws InterruptedException {
        System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
        int loreChoice = scan.nextInt(); // Get player's choice to read character lore
        if (loreChoice == 1) { // If player wants to read character lore
            System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
            char classChoice = scan.next().charAt(0); // Get player's character class choice
            switch (classChoice) { // Handle class choice
                case 'W':
                    w1.tellCharLoreAttack(); // Tell Warrior lore for attack
                    Thread.sleep(1000); // Pause for dramatic effect
                    w1.tellCharLoreSupport(); // Tell Warrior lore for support
                    break;
                case 'M':
                    m1.tellCharLoreAttack(); // Tell Mage lore for attack
                    Thread.sleep(1000); // Pause for dramatic effect
                    m1.tellCharLoreSupport(); // Tell Mage lore for support
                    break;
                case 'R':
                    r1.tellCharLoreAttack(); // Tell Ranger lore for attack
                    Thread.sleep(1000); // Pause for dramatic effect
                    r1.tellCharLoreSupport(); // Tell Ranger lore for support
                    break;
                default:
                    System.out.println("Invalid choice. Please enter M, R, or W."); // Handle invalid choice
                    break;
            }
        }
    }
}
