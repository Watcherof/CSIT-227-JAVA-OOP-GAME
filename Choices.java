import java.util.Scanner;

public class Choices implements ChoicesInterface {

    // Arrays to store valid character names for each class
    private final String[] validMageCharacters = {"Ember Witch", "Aquamancer"};
    private final String[] validWarriorCharacters = {"Guardians", "General"};
    private final String[] validRangerCharacters = {"Shadow Strider", "Verdant Warden"};
    
    public final String[] chosenCharacters = new String[3]; // Array to store selected characters
    private final boolean[] classChosen = new boolean[3]; // Track if a class has already been chosen

    // Getter for chosen characters as strings
    @Override
    public String[] getChosenCharacters() {
        return chosenCharacters;
    }

    // Setter for chosen characters
    @Override
    public void setChosenCharacter(String chosenCharacter) {
        // Check if the chosen character is valid
        if (isValidCharacter(chosenCharacter)) {
            // Check if a character from the same class has already been chosen
            if (isClassAlreadyChosen(chosenCharacter)) {
                throw new IllegalArgumentException("A character from the same class has already been chosen: " + chosenCharacter);
            }
            // Find the first empty slot to add the character
            for (int i = 0; i < chosenCharacters.length; i++) {
                if (chosenCharacters[i] == null) { // Check for an empty slot
                    this.chosenCharacters[i] = chosenCharacter; // Add character to that slot
                    markClassAsChosen(chosenCharacter); // Mark the class as chosen
                    return;
                }
            }
            throw new IllegalArgumentException("All character slots are filled."); // Handle case when all slots are filled
        } else {
            throw new IllegalArgumentException("Invalid character choice: " + chosenCharacter); // Handle invalid character choice
        }
    }

    // Check if the character choice is valid
    @Override
    public boolean isValidCharacter(String choice) {
        // Valid if the character belongs to any of the defined classes
        return isWarriorCharacter(choice) || isMageCharacter(choice) || isRangerCharacter(choice);
    }

    // Check if a character from the same class has already been chosen
    @Override
    public boolean isClassAlreadyChosen(String character) {
        // Determine if a character from the same class has already been chosen
        return (isMageCharacter(character) && classChosen[1]) ||
               (isWarriorCharacter(character) && classChosen[0]) ||
               (isRangerCharacter(character) && classChosen[2]);
    }

    // Mark the class as chosen based on the selected character
    private void markClassAsChosen(String character) {
        if (isMageCharacter(character)) {
            classChosen[1] = true; // Mark Mage class as chosen
        } else if (isWarriorCharacter(character)) {
            classChosen[0] = true; // Mark Warrior class as chosen
        } else if (isRangerCharacter(character)) {
            classChosen[2] = true; // Mark Ranger class as chosen
        }
    }

    // Check if the character is a valid Mage character
    @Override
    public boolean isMageCharacter(String character) {
        for (String validCharacter : validMageCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true; // Return true if a valid Mage character is found
            }
        }
        return false; // Return false if no valid character matches
    }

    // Check if the character is a valid Warrior character
    @Override
    public boolean isWarriorCharacter(String character) {
        for (String validCharacter : validWarriorCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true; // Return true if a valid Warrior character is found
            }
        }
        return false; // Return false if no valid character matches
    }

    // Check if the character is a valid Ranger character
    @Override
    public boolean isRangerCharacter(String character) {
        for (String validCharacter : validRangerCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true; // Return true if a valid Ranger character is found
            }
        }
        return false; // Return false if no valid character matches
    }

    // Getter for chosen Character objects
    // to be erased if not used
    public Characters[] getChosenChars() {
        return selectCharacters(); // Return the selected character instances
    }

    // Returns a character instance based on the character name
    public Characters getCharacter(String characterName) {
        // Logic to create a character instance based on the name
        if (characterName.equalsIgnoreCase("General")) {
            return new General(0); // Return a new General character
        } else if (characterName.equalsIgnoreCase("Guardians")) {
            return new Guardian(0); // Return a new Guardian character
        } else if (characterName.equalsIgnoreCase("Ember Witch")) {
            return new EmberWitch(0); // Return a new Ember Witch character
        } else if (characterName.equalsIgnoreCase("Aquamancer")) {
            return new Aquamancer(0); // Return a new Aquamancer character
        } else if (characterName.equalsIgnoreCase("Shadow Strider")) {
            return new ShadowStrider(0); // Return a new Shadow Strider character
        } else if (characterName.equalsIgnoreCase("Verdant Warden")) {
            // return new VerdantWarden // Uncomment and return the Verdant Warden character
        }
        // Return null if no matching character is found
        return null;
    }

    @Override
    public Characters[] selectCharacters() {
        Scanner scanner = new Scanner(System.in);
        Characters[] selectedCharacters = new Characters[3]; // Array to hold the selected character instances
    
        // Loop through classes in order: Warrior, Mage, Ranger
        String[] classes = {"Warrior", "Mage", "Ranger"};
        for (int i = 0; i < classes.length; i++) {
            while (true) {
                System.out.print("Choose a character from " + classes[i] + ": ");
                String choice = scanner.nextLine(); // Read user input for character choice
                try {
                    if (i == 0 && isWarriorCharacter(choice)) { // If selecting a Warrior
                        selectedCharacters[i] = getCharacter(choice); // Get and store the character instance
                        setChosenCharacter(choice); // Track the chosen character
                        break; // Exit the loop if valid
                    } else if (i == 1 && isMageCharacter(choice)) { // If selecting a Mage
                        selectedCharacters[i] = getCharacter(choice);
                        setChosenCharacter(choice);
                        break; // Exit the loop if valid
                    } else if (i == 2 && isRangerCharacter(choice)) { // If selecting a Ranger
                        selectedCharacters[i] = getCharacter(choice);
                        setChosenCharacter(choice);
                        break; // Exit the loop if valid
                    } else {
                        throw new IllegalArgumentException("Please select a valid " + classes[i] + " character."); // Handle invalid choice
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Please try again."); // Display error message and prompt again
                }
            }
        }
       
        return selectedCharacters; // Return the array of character instances
    }

    @Override
    public void displayCharacters(String[] characters) {
        System.out.println("You have chosen the following characters:\n");
        for (String character : characters) { // Iterate over chosen characters
            if (character != null) {
                System.out.println("- " + character); // Print each chosen character
            }
        }
        System.out.println(); // Add an empty line for formatting
    }

    @Override
    public void characterSelectionPVE(String name) {
        System.out.println("======================= Player " + name + " ========================");
        displayCharacterMenu(); // Display the character selection menu
    }

    @Override
    public void characterSelectionPVP1() {
        System.out.println("========================= Player 1 =============================");
        displayCharacterMenu(); // Display the character selection menu
    }

    @Override
    public void characterSelectionPVP2() {
        System.out.println("========================= Player 2 =============================");
        displayCharacterMenu(); // Display the character selection menu
    }

    // Helper method to display the character menu
    private void displayCharacterMenu() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                CHOOSE YOUR CHARACTERS                        ║");
        System.out.println("╠═════════════╦══════════════════════════╦═════════════════════╣");
        System.out.println("║    CLASS    ║          ATTACK          ║        SUPPORT      ║");
        System.out.println("╠═════════════╬══════════════════════════╬═════════════════════╣");
        System.out.println("║   Warrior   ║  1 - General             ║  2 - Guardians      ║");
        System.out.println("╠═════════════╬══════════════════════════╬═════════════════════╣");
        System.out.println("║    Mage     ║  3 - Ember Witch         ║  4 - Aquamancer     ║");
        System.out.println("╠═════════════╬══════════════════════════╬═════════════════════╣");
        System.out.println("║   Ranger    ║  5 - Shadow Strider      ║  6 - Verdant Warden ║");
        System.out.println("╚═════════════╩══════════════════════════╩═════════════════════╝");
        System.out.println(); // Add an empty line for formatting
    }
}
