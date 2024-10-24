import java.util.Random; // Importing Random for generating random numbers
import java.util.Scanner; // Importing Scanner for user input

public class Player extends Choices { // Player class extending Choices
    private String name; // Player's name
    private final Characters[] chosenCharacters = new Characters[3]; // Array to store selected Characters
    private final boolean[] classChosen = new boolean[3]; // Track chosen classes: [0] Warrior, [1] Mage, [2] Ranger
    private Characters[] characters; // Array of available characters
    private int index; // Index of the currently active character

    // Constructor
    public Player(String name, Characters[] characters) {
        this.name = name; // Initialize player's name
        this.characters = characters; // Assign the characters array passed to the constructor
        this.index = 0; // Set initial character index to 0
    }

    // Getters
    public String getName() {
        return name; // Return player's name
    }

    public Characters getCurrentCharacter() {
        return characters[index]; // Return the currently active character
    }

    // Method to return chosen Characters
    public Characters[] getChosenChar() {
        return this.chosenCharacters; // Return the array of chosen Characters
    }

    // Switch character if valid
    public boolean switchCharacter(int index) {
        if (index >= 0 && index < characters.length && characters[index].isAlive()) {
            this.index = index; // Switch to the new character if it's alive
            return true; // Successful switch
        } else {
            System.out.println("Cannot switch to that character. Either it's dead or invalid."); // Error message
            return false; // Unsuccessful switch
        }
    }

    // Check if the player has any alive characters
    public boolean hasAliveCharacters() {
        for (Characters character : characters) {
            if (character.isAlive()) {
                return true; // Return true if any character is alive
            }
        }
        return false; // No alive characters found
    }

    // Method to take damage
    public void damageTaken(int damage) {
        Characters currentCharacter = getCurrentCharacter(); // Get the current character
        if (currentCharacter != null && currentCharacter.isAlive()) {
            currentCharacter.takeDamage(damage); // Apply damage to the current character
            System.out.println(currentCharacter.getName() + " takes " + damage + " damage."); // Print damage info
        } else {
            System.out.println("Current character is already dead or invalid."); // Error message
        }
    }

    
    public void printAllCharacterStatus() {
        for (int i = 0; i < characters.length; i++) {
            System.out.println((i + 1) + ". " + characters[i].getName() + ": " 
                + (characters[i].isAlive() ? characters[i].getHealth() + " HP" : "Dead"));
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Generate random numbers that sum up to 10
    public int[] generateNumbers() {
        Random random = new Random(); // Create a Random object
        int[] numbers = new int[4]; // Array to hold four numbers
        int sum = 10; // We want the sum of the four numbers to be exactly 10

        // Generate three random numbers between 0 and the remaining sum
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(Math.min(sum + 1, 11)); // Ensure sum does not exceed 10
            sum -= numbers[i]; // Subtract the generated number from the sum
        }

        // The fourth number should be the remainder of the sum to ensure total sum is 10
        numbers[3] = sum; // Assign remaining sum to the fourth number
        return numbers; // Return the generated numbers
    }

    // Wish method to receive random resources
    public int[] wish() {
        System.out.println("\nPress Enter key to wish..."); // Prompt for user input
        Scanner scan = new Scanner(System.in); // Create a Scanner for input
        scan.nextLine(); // Wait for user to press Enter
        int[] result = generateNumbers(); // Generate random resource numbers
        System.out.println("You received: "); // Print received resources
        System.out.println("Stamina: " + result[0] + ", Mana: " + result[1] + ", Spirit: " + result[2] + ", Energy: " + result[3]);

        return result; // Return the generated resources
    }

    // Combat method to manage player vs opponent combat
    // NAPAY KUWANG DRE GUYZ ANG PAG INITIALIZE PARA MAKA PILI OG CHARACTERS
    public int combat(Player current, Player opponent) {
        int[] res = wish();  // Assume res[0] is stamina or energy
        Scanner scan = new Scanner(System.in); // Create a Scanner for user input
        Characters g1 = null, m1 = null, r1 = null; // Initialize character instances
        int i = 0, track = 0, choice, damage = 0; // Initialize variables
        int accumulatedDmg; // Variable to accumulate damage
        int a  = 0;
        do {
            ////TODO
            // MAKE A CONDITIONAL STATEMENT(if else) in this part so that
            // IF A USER WANTS TO PICK GUARDIAN g1 will be g1 = new Guardian(res[0])
            g1 = new General(res[0]); // Create a General character with stamina
            m1 = new EmberWitch(res[1]); // Create an EmberWitch character with mana
            r1 = new ShadowStrider(res[2]); // Create a ShadowStrider character with spirit
            accumulatedDmg = 0;
            // Access the opponent's current character's health
            Characters opponentCurrent = opponent.getCurrentCharacter(); // Get the opponent's current character
            Characters mc = current.getCurrentCharacter(); // Get the current character of the player
            switch (track) {
                case 0:
                    i = 0; // Use the first character
                    System.out.println("\nEnemy Current Character: " + opponentCurrent.getName() + ": " + opponentCurrent.getHealth()); // Print enemy health
                    mc.choices(res[a], accumulatedDmg, mc.getHealth()); // Display choices for General
                    break;
                case 1:
                    i = 1; // Use the second character
                    System.out.println("\nEnemy Current Character: " + opponentCurrent.getName() + ": " + opponentCurrent.getHealth()); // Print enemy health
                    mc.choices(res[a], accumulatedDmg, mc.getHealth()); // Display choices for EmberWitch
                    break;
                case 2:
                    i = 2; // Use the third character
                    System.out.println("\nEnemy Current Character: " + opponentCurrent.getName() + ": " + opponentCurrent.getHealth()); // Print enemy health
                    mc.choices(res[a], accumulatedDmg, mc.getHealth()); // Display choices for ShadowStrider
                    break;
                default:
                    i = 0; // Reset to first character
                    track = 0; // Reset track
                    System.out.println("\nEnemy Current Character: " + opponentCurrent.getName() + ": " + opponentCurrent.getHealth()); // Print enemy health
                    g1.choices(res[a], accumulatedDmg, mc.getHealth()); // Display choices for General
                    break;
            }


            // Get the player's choice
            choice = scan.nextInt(); // Read user input for choice

            // Perform the attack based on the choice
            if (choice < 4) {
                damage = performAttack(i, res,choice, opponent,mc); // Perform the attack
                accumulatedDmg += damage; // Accumulate damage
            }

            // Handle switching characters and other choices
            switch (choice) {
                case 4: // Switch character
                    System.out.println("Choose a char to switch to: ");
                    current.printAllCharacterStatus();
                     a = scan.nextInt() - 1;
                    current.switchCharacter(a);
                    //track++;  // Move to the next character
                    System.out.println("CHAR CHANGED"); // Notify character change
                    break;

                case 5: // Reroll stamina/energy
                    res = wish(); // Reroll resources
                    break;

                case 6: // End turn
                    displayWithDelay(" decides to regroup and ends their turn.", 150); // Notify end of turn
                    return 0; // Return to end turn

                default:
                    if (choice < 1 || choice > 6) {
                        displayWithDelay("Invalid choice. Please select an action.", 300); // Error message for invalid choice
                    }
                    break;
            }
        } while (g1.getHealth() > 0 || m1.getHealth() > 0 || r1.getHealth() > 0 || choice == 6);

        if (g1.getHealth() == 0 && m1.getHealth() == 0 && r1.getHealth() == 0) {
            return -21;  // Indicate player has lost
        }
        return damage; // Return damage dealt
    }

    // Method to perform the chosen attack
    private int performAttack(int i,  int[] res, int choice, Player opponent,Characters current) {
        int damage = 0; // Initialize damage variable
        switch (choice) {
            case 1: // Basic attack
                if (i == 0) {
                    current.basicAttack(res[i], opponent.getCurrentCharacter()); // Perform basic attack with General
                    res[i] -= 2; // Deduct resources
                } else if (i == 1) {
                    current.basicAttack(res[i], opponent.getCurrentCharacter()); // Perform basic attack with EmberWitch
                    res[i] -= 2; // Deduct resources
                } else if (i == 2) {
                    current.basicAttack(res[i], opponent.getCurrentCharacter()); // Perform basic attack with ShadowStrider
                    res[i] -= 2; // Deduct resources
                }
                break;

            case 2: // Skill attack
                if (i == 0) {
                    current.skill(res[i], opponent.getCurrentCharacter()); // Perform skill attack with General
                    res[i] -= 5; // Deduct resources
                } else if (i == 1) {
                    current.skill(res[i], opponent.getCurrentCharacter()); // Perform skill attack with EmberWitch
                    res[i] -= 5; // Deduct resources
                } else if (i == 2) {
                    current.skill(res[i], opponent.getCurrentCharacter()); // Perform skill attack with ShadowStrider
                    res[i] -= 5; // Deduct resources
                }
                break;

            case 3: // Ultimate attack
                if (i == 0) {
                    current.ult(res[i], opponent.getCurrentCharacter()); // Perform ultimate attack with General
                    res[i] -=8;
                } else if (i == 1) {
                    current.ult(res[i], opponent.getCurrentCharacter()); // Perform ultimate attack with EmberWitch
                    res[i] -=8;
                } else if (i == 2) {
                    current.ult(res[i], opponent.getCurrentCharacter()); // Perform ultimate attack with ShadowStrider
                    res[i] -=8;
                }
                break;
            default: // Invalid choice
                System.out.println("Invalid choice for attack."); // Print error message
                break;
        }
        return damage; // Return damage dealt
    }

    // Display text with a delay for dramatic effect
    public void displayWithDelay(String text, int delayInMillis) {
        String[] words = text.split(" "); // Split text into words
        for (String word : words) {
            System.out.print(word + " "); // Print each word
            try {
                Thread.sleep(delayInMillis); // Delay between words
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        System.out.println(); // Print a newline after the text
    }
}
