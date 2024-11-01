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
    private Player computer = null;


        public int chooseMode() {
            int mode = 0;
            boolean isEnabled = true;

            while (isEnabled) {
                try {
                    System.out.print("Choose mode (1 - PVP / 2 - PVE): ");
                    mode = scan.nextInt();
                    // Check if mode is valid (1 or 2)
                    if (mode == 1 || mode == 2) {
                        isEnabled = false; // Exit loop if a valid mode is selected
                    } else {
                        System.out.println("Invalid selection. Please enter 1 for PVP or 2 for PVE.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scan.next(); // Clear invalid input
                }
            }
            return mode;
        }
        // ang try catch ani nana sa chooseMode()
    public void startGame(String playerName, int gameMode) throws InterruptedException {
        // Character selection based on mode
        if (gameMode == 1) {//pvp
            System.out.println("You have chosen player versus player!");
            c1.characterSelectionPVP1(); // Player 1 selects characters
            Characters[] player1Characters = c1.getChosenChars(); // Get selected characters
            player1 = new Player("Player 1", player1Characters); // Create Player 1
            player1.displayCharacters(c1.getChosenCharacters(),gameMode); // Display selected characters

            System.out.println("Player 1 has chosen. Press Enter for Player 2 to choose.");
            scan.nextLine(); // Consume the newline character
            scan.nextLine(); // w8 4 enter

            c2.characterSelectionPVP2(); // Player 2 selects characters
            Characters[] player2Characters = c2.getChosenChars(); // Get selected characters
            player2 = new Player("Player 2", player2Characters); // Create Player 2
            player2.displayCharacters(c2.getChosenCharacters(),gameMode); // Display selected characters
            combatPVP(); // Start PVP combat
        } else if (gameMode == 2) { 
            System.out.println("You have chosen player vs environment!");
            c1.characterSelectionPVE(playerName);
            Characters[] playerCharacters = c1.selectCharacters(); 
            player1 = new Player(playerName, playerCharacters); 
            player1.displayCharacters(c1.getChosenCharacters(),1);
            System.out.println("Player " + playerName + " has chosen. Press enter for Computer to choose.");
            scan.nextLine();//consume the newline cahr
            scan.nextLine();// w8 4 enter


            Characters[] computerCharacters = c2.computerSelectCharacter();
            computer = new Player("computer", computerCharacters);
            computer.displayCharacters(c2.getChosenCharacters(),gameMode);
            System.out.println("Enter to start combat");
            scan.nextLine();
            combatPVE(playerName); 
        }else{
            System.out.println("Invalid choice! Please choose 1 or 2");
        }
    }

// Method for PVP combat logic
    private void combatPVP() {
        int currentPlayer = 1; // Track which player's turn it is
        int roundCounter = 1;   // Initialize round counter

        // Game loop for combat
        while (player1.hasAliveCharacters() && player2.hasAliveCharacters()) { // Continue until one player has no alive characters
            clearScreen(); // Clear the screen before each round
            

            if(roundCounter < 10){
                System.out.println("╔═════════════════════════════════════╗");
                System.out.println("║              ROUND " + roundCounter + "                ║");
                System.out.println("╚═════════════════════════════════════╝");
            }else{
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║              ROUND " + roundCounter + "                ║");
                System.out.println("╚══════════════════════════════════════╝");
            }


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
                roundCounter++; // Increment the round counter after each turn
            }
        }

        // Determine and display the winner
        if (player1.hasAliveCharacters()) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║              Player 1 wins!            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Player 1 defeated player 2 in " + roundCounter + " rounds!");
        } else {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║              Player 2 wins!            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Player 2 defeated player 1 in " + roundCounter + " rounds!");
        }
    }

    
    // Placeholder for PVE combat logic
    private void combatPVE(String playerName) {
       
        int currentPlayer = 1; // Track which player's turn it is
        int roundCounter = 1;   // Initialize round counter
        // Implement PVE combat logic here
        while(player1.hasAliveCharacters() && computer.hasAliveCharacters()){
            clearScreen();

            if(roundCounter < 10){
                System.out.println("╔═════════════════════════════════════╗");
                System.out.println("║              ROUND " + roundCounter + "                ║");
                System.out.println("╚═════════════════════════════════════╝");
            }else{
                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║              ROUND " + roundCounter + "                ║");
                System.out.println("╚══════════════════════════════════════╝");
            }
   
            if (currentPlayer == 1) {
                System.out.println("Player " + playerName + " turn");
                System.out.println("-----------------------");
                player1.combat(player1, computer);
                currentPlayer = 2; 
            } else { // Player 2's turn
                if (computer.hasAliveCharacters()) {
                    System.out.println("Computers turn");
                    System.out.println("-----------------------");
                    computer.computerCombat(computer, player1); // Player 2 attacks
                }
                currentPlayer = 1; // Switch back to Player 1
                roundCounter++; // Increment the round counter after each turn
            }
        }

        if (player1.hasAliveCharacters()) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║               User wins!               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Player 1 defeated player 2 in " + roundCounter + " rounds!");
        } else {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║              Computer wins!            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Player 2 defeated player 1 in " + roundCounter + " rounds!");
        }
    }


    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
            System.out.println("Could not clear the screen.");
        }
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
        boolean continueReading = true;
        while (continueReading) {
            int loreChoice = 0;
            while (true) {
                try {
                    System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
                    loreChoice = scan.nextInt();
                    if (loreChoice == 1 || loreChoice == 2) {
                        break; // Exit loop if valid input
                    } else {
                        System.out.println("Invalid choice. Please enter 1 for YES or 2 for NO.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                    scan.next(); // Clear invalid input
                }
            }
    
            if (loreChoice == 1) {
                boolean repeatReading = true;
    
                while (repeatReading) {
                    System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
                    char classChoice = Character.toUpperCase(scan.next().charAt(0));

                    switch (classChoice) {
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
                            System.out.println("Invalid choice. Please enter M, R, or W."); 
                            continue; // Skip the rest of the loop and prompt again for class choice
                    }
    
                    // Ask if the user wants to read the lores again
                    while (true) {
                        System.out.print("Do you want to read the lores again? (1 for yes/2 for no): ");
                        int repeatChoice = scan.nextInt();
    
                        if (repeatChoice == 1) {
                            System.out.println("Now choose your lore!");
                            break; // Continue to the start of the outer loop
                        } else if (repeatChoice == 2) {
                            repeatReading = false; // Exit the inner loop
                            continueReading = false;//Exit outer loop since we dont wanna read no more
                            break; // Exit this while loop
                        } else {
                            System.out.println("Invalid choice. Please enter 1 or 2 only!");
                        }
                    }
                }
            } else {
                continueReading = false; // Exit the outer loop if user does not want to read lores
            }
        }
    }
    
}
