import java.util.Scanner;

public class Choices implements Choose {
    private final String[] validMageCharacters = {"Ember Witch", "Aquamancer"};
    private final String[] validWarriorCharacters = {"Guardians", "General"};
    private final String[] validRangerCharacters = {"Shadow Strider", "Arcane Musketeer"};

    private final String[] chosenCharacters = new String[3]; // Array to store selected characters

    // Getter for chosen characters
    public String[] getChosenCharacters() {
        return chosenCharacters;
    }

    public void setChosenCharacter(String character) {
        if (isValidCharacter(character)) {
            if (isClassAlreadyChosen(character)) {
                throw new IllegalArgumentException("A character from the same class has already been chosen: " + character);
            }
            for (int i = 0; i < chosenCharacters.length; i++) {
                if (chosenCharacters[i] == null) { // Find the first empty slot
                    chosenCharacters[i] = character; // Add character to that slot
                    return; // Exit the method once added
                }
            }
            throw new IllegalStateException("All character slots are filled."); // Handle case when array is full
        } else {
            throw new IllegalArgumentException("Invalid character choice: " + character);
        }
    }

    // Check if the character choice is valid
    @Override
    public boolean isValidCharacter(String choice) {
        for (String character : validMageCharacters) {
            if (character.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        for (String character : validWarriorCharacters) {
            if (character.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        for (String character : validRangerCharacters) {
            if (character.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        return false;
    }

    // Check if a character from the same class has already been chosen
    private boolean isClassAlreadyChosen(String character) {
        if (isMageCharacter(character)) {
            for (String chosenCharacter : chosenCharacters) {
                if (isMageCharacter(chosenCharacter)) {
                    return true; // Mage character already chosen
                }
            }
        } else if (isWarriorCharacter(character)) {
            for (String chosenCharacter : chosenCharacters) {
                if (isWarriorCharacter(chosenCharacter)) {
                    return true; // Warrior character already chosen
                }
            }
        } else if (isRangerCharacter(character)) {
            for (String chosenCharacter : chosenCharacters) {
                if (isRangerCharacter(chosenCharacter)) {
                    return true; // Ranger character already chosen
                }
            }
        }
        return false;
    }

    // Helper methods to check character classes
    private boolean isMageCharacter(String character) {
        for (String validCharacter : validMageCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWarriorCharacter(String character) {
        for (String validCharacter : validWarriorCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRangerCharacter(String character) {
        for (String validCharacter : validRangerCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void characterSelection() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║               CHOOSE YOUR CHARACTERS           ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║   ATTACK              ║           SUPPORT      ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║   Guardians           ║           General      ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║   Ember Witch         ║         Aquamancer     ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║   Shadow Strider      ║     Arcane Musketeer   ║");
        System.out.println("╚═══════════════════════╩════════════════════════╝");
    }

    @Override
    public void selectCharacters() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        for (int i = 0; i < 3; i++) {
            System.out.print("Choose character " + (i + 1) + ": ");
            String choice = scanner.nextLine(); // Read character choice

            try {
                setChosenCharacter(choice); // Set chosen character using setter
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage()); // Print error message if invalid
                i--; // Decrement i to retry the same index
            }
        }

        // Display chosen characters after selection
        System.out.println("You have chosen the following characters:");
        for (String character : chosenCharacters) {
            if (character != null) {
                System.out.println("- " + character);
            }
        }
    }
}
