import java.util.Scanner;
public class ChoicesPVE implements Choose {
    private final String[] validMageCharacters = {"Ember Witch", "Aquamancer"};
    private final String[] validWarriorCharacters = {"Guardians", "General"};
    private final String[] validRangerCharacters = {"Shadow Strider", "Arcane Musketeer"};
    private final String[] chosenCharacters = new String[3]; // Array to store selected characters
    private final boolean[] classChosen = new boolean[3]; // Track if a class has already been chosen
    //private final String[] validClass = {"Warrior", "Mage", "Ranger"};

    /* 
    public ChoicesPVE(int player) {
        this.player = player;
    }*/

    // Getter for chosen characters
    @Override
    public String[] getChosenCharacters() {
        return chosenCharacters;
    }
    // Setter 
    @Override
    public void setChosenCharacter(String chosenCharacter) {
        if (isValidCharacter(chosenCharacter)) {
            if (isClassAlreadyChosen(chosenCharacter)) {
                System.out.println("A character from the same class has already been chosen: " + chosenCharacter);
                System.out.println("Class already chosen");
            }
            for (int i = 0; i < chosenCharacters.length; i++) {
                if (chosenCharacters[i] == null) { // Find the first empty slot
                    this.chosenCharacters[i] = chosenCharacter; // Add character to that slot
                    markClassAsChosen(chosenCharacter); // Mark the class as chosen
                    return;
                }
            }
            System.out.println("All character slots are filled."); // Handle case when array is full
        } else {
            System.out.println("Invalid character choice: " + chosenCharacter);
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
    @Override
    public boolean isClassAlreadyChosen(String character) {
        if (isMageCharacter(character) && classChosen[1]) {
            return true; // Mage character already chosen
        } else if (isWarriorCharacter(character) && classChosen[0]) {
            return true; // Warrior character already chosen
        } else if (isRangerCharacter(character) && classChosen[2]) {
            return true; // Ranger character already chosen
        }
        return false;
    }

    // Mark the class as chosen
    private void markClassAsChosen(String character) {
        if (isMageCharacter(character)) {
            classChosen[1] = true;
        } else if (isWarriorCharacter(character)) {
            classChosen[0] = true;
        } else if (isRangerCharacter(character)) {
            classChosen[2] = true;
        }
    }

    @Override
    public boolean isMageCharacter(String character) {
        for (String validCharacter : validMageCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isWarriorCharacter(String character) {
        for (String validCharacter : validWarriorCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isRangerCharacter(String character) {
        for (String validCharacter : validRangerCharacters) {
            if (validCharacter.equalsIgnoreCase(character)) {
                return true;
            }
        }
        return false;
    }


    @Override
    // Enforce class selection in order: Warrior -> Mage -> Ranger
    public void selectCharacters() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Enforce order: Warrior first
        System.out.print("Choose character from Warrior: ");
        while (true) {
            String choice = scanner.nextLine();
            try {
                setChosenCharacter(choice);
                break; // Exit loop if valid
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }

        // Enforce order: Mage second
        System.out.print("Choose character from Mage: ");
        while (true) {
            String choice = scanner.nextLine();
            try {
                setChosenCharacter(choice);
                break; // Exit loop if valid
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
        // Enforce order: Ranger third
        System.out.print("Choose character from Ranger: ");
        while (true) {
            String choice = scanner.nextLine();
            try {
                setChosenCharacter(choice);
                break; // Exit loop if valid
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
    }

    @Override
    public void displayCharacters(String[] characters) {
        System.out.println("You have chosen the following characters:");
        for (String character : chosenCharacters) {
            if (character != null) {
                System.out.println("- " + character);
            }
        }
    }

    @Override
    public void characterSelection() {
                                                /*player*/
        System.out.println("==============Player =================");
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║               CHOOSE YOUR CHARACTERS           ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║   ATTACK              ║           SUPPORT      ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║  1 - Guardians        ║  2 - General           ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║  3 - Ember Witch      ║  4 - Aquamancer        ║");
        System.out.println("╠═══════════════════════╬════════════════════════╣");
        System.out.println("║  5 - Shadow Strider   ║  6 - Arcane Musketeer  ║");
        System.out.println("╚═══════════════════════╩════════════════════════╝");
    }

}
