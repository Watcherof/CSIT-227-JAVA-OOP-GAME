import java.util.Random; 
import java.util.Scanner;

public class Player extends Choices { 
    private String name;
    private final Characters[] chosenCharacters = new Characters[3]; // Array to store selected Characters
    private final Characters[] characters; // Array of available characters
    private int index; // Index of the currently active character
    private final String[] type = {"Stamina","Mana","Spirit"};
  
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
        return characters[this.index]; // Return the currently active character
    }

    public Characters[] getAllCharacters() {
        return characters;
    }

    // Method to return chosen Characters
    public Characters[] getChosenChar() {
        return this.characters; // Return the array of chosen Characters
    }


    // Switch character if valid
    public boolean switchCharacter(int index) {
        if (index == this.index) {
            displayWithDelay("Cannot change to the same character!", 100);
            return false;  // Return false as the character hasn't changed
        }
        if(index == 4){
            return false;
        }
        // Check if the index is valid and the character is alive
        if (index >= 0 && index < characters.length && characters[index].isAlive()) {
            String currentCharacterName = getCurrentCharacter().getName();
            String newCharacterName = characters[index].getName();
            displayWithDelay("\nSwitching character from " + currentCharacterName + " to " + newCharacterName + "...", 150);
            this.index = index; 
            return true; 
        } 
        // Check if the index is out of range (not 1, 2, or 3)
        else if (index < 0 || index > 2) {
            displayWithDelay("Invalid input! Please enter valid choices (1, 2, or 3).", 100);
        } 
        else {
            displayWithDelay("Cannot switch to character because the character is dead!", 100);
        }
        return false;
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

    public void printAllCharacterStatus(int[] res) {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i].isAlive()) {
                // If character is alive, print health, defense, resource, and shield
                if (characters[i].getShield() > 0) {
                    System.out.println((i + 1) + ". " + characters[i].getName() + ": " 
                        + characters[i].getHealth() + " HP, Defense: " + characters[i].getDefence() 
                        + ", " + this.type[i] + ": " + res[i] 
                        + ", Shield: " + characters[i].getShield());
                } else {
                    System.out.println((i + 1) + ". " + characters[i].getName() + ": " 
                        + characters[i].getHealth() + " HP, Defense: " + characters[i].getDefence() 
                        + ", " + this.type[i] + ": " + res[i]);
                }
            } else {
                // If character is dead, print "Dead" instead of health
                System.out.println((i + 1) + ". " + characters[i].getName() + ": Dead, " + this.type[i] + ": " + res[i]);
            }
        }
    }

    // Switch to the next alive character in the opponent's team
    public boolean switchToNextAliveCharacter() {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i].isAlive()) {
                index = i; // Switch to the next alive character
                displayWithDelay("\nEnemy Character is Switching to " + characters[i].getName(),150);
                return true; // Successful switch
            }
        }
        return false; // No alive characters left
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Generate random numbers that sum up to 10
    public int[] generateNumbers() {
        Random random = new Random(); // Create a Random object
        int[] numbers = new int[3]; // Array to hold three numbers
        int sum = 10; // We want the sum of the three numbers to be exactly 10
    
        // Generate two random numbers between 0 and the remaining sum
        for (int i = 0; i < 2; i++) {
            numbers[i] = random.nextInt(Math.min(sum + 1, 11)); // Ensure number does not exceed remaining sum or 10
            sum -= numbers[i]; // Subtract the generated number from the sum
        }
    
        // The third number should be the remainder of the sum to ensure total sum is 10
        numbers[2] = sum; // Assign remaining sum to the third number
    
        return numbers; // Return the generated numbers
    }
    

    // Wish method to receive random resources
    public int[] wish() {
        displayWithDelay("\nPress Enter key to wish...",100); // Prompt for user input
        Scanner scan = new Scanner(System.in); // Create a Scanner for input
        scan.nextLine(); // Wait for user to press Enter
        int[] result = generateNumbers(); // Generate random resource numbers
        System.out.println("You received: "); // Print received resources
        System.out.println("Stamina: " + result[0] + ", Mana: " + result[1] + ", Spirit: " + result[2]);

        return result; // Return the generated resources
    }

    // Combat method to manage player vs opponent combat
    public void combat(Player current, Player opponent) {
        int[] res = wish();  // Assume res[0] is stamina or energy
        Scanner scan = new Scanner(System.in); // Create a Scanner for user input
        Characters opponentCurrent = opponent.getCurrentCharacter(); // Get the opponent's current character
        Characters mc; // Get the current character of the player
        int choice = 0;
        int a = this.index; // like this because if we end turn the res will not be updated together with the current player
       do{
              mc = current.getCurrentCharacter(); // Get the current character of the player
            while(true){
                try{
                    System.out.println("\n===================================");
                    System.out.println(opponent.getName() + " (Enemy) Current Character");
                    System.out.println("Name   : " + opponentCurrent.getName());
                    System.out.println("Health : " + opponentCurrent.getHealth());
                    System.out.println("Defence: " + opponentCurrent.getDefence());
                    
                    if (opponentCurrent.getShield() > 0) {
                        System.out.println("Shield : " + opponentCurrent.getShield());
                        System.out.println("===================================");
                    } else {
                        System.out.println("===================================");
                    }
                    mc.choices(res[this.index],1); // Display choices for current character
                    // Get the player's choice
                    choice = scan.nextInt(); // Read user input for choice
                    if(choice >= 1 && choice<=7){
                        break;
                    }else{
                        System.out.println("Invalid choice. Enter a number from 1 - 6!!!");
                    }
                }catch(Exception e){
                    System.out.println("Invalid choice. Enter a number!!!");
                    scan.next();
                }
            }
            // Perform the attack based on the choice
            if (choice < 4) {
                  performAttack(a, res, choice, opponentCurrent,opponent, mc,1); // Perform the attack
                // Check if the opponent's character is dead
                if (!opponentCurrent.isAlive()) {
                    displayWithDelay("\n" + opponentCurrent.getName() + " has been defeated!",150);
                    // Automatically switch to the next alive opponent character
                    boolean switched = opponent.switchToNextAliveCharacter();
                    // if !switched = if characters are dead
                    if (!switched) {
                        // No more alive characters, opponent loses
                        displayWithDelay("\n" + opponent.getName() + " has no characters left!",150);
                        return; // Return 1 to indicate win
                    }
                    opponentCurrent = opponent.getCurrentCharacter(); // Update the opponent's current character
                }
            }
            // Handle switching characters and other choices
            switch (choice) {
                case 4: // Switch character
                    boolean isEnabled = true;
                    while(isEnabled){
                        try {
                        System.out.println("\nChoose a character to switch to: ");
                        current.printAllCharacterStatus(res);
                        System.out.print("Your choice: ");
                        a = scan.nextInt() - 1;
                        if(a < 3 && a > -1){
                        isEnabled = false; 
                         }      
                         if(current.switchCharacter(a) == false){//para mo loop balik if mo pili same char in choosing like if user choose to switch to guardian while iyang current char kay guardian mo loop sya balik asking to choose other chars
                                isEnabled = true;
                         } 
                        } catch (Exception e) {
                            System.out.println("Invalid choice! Please try again");
                            scan.next();
                        }
                    }
                    break;
                case 5: // print all character status
                    //res = wish(); // Reroll resources
                      System.out.println("\n════════════════════════════════════════════════════════════════════");
                      System.out.println("All Character Statuses:");
                      current.printAllCharacterStatus(res);
                     System.out.println("════════════════════════════════════════════════════════════════════");

                    break;
                case 6: // End turn
                    displayWithDelay(mc.getName() + " decides to regroup and ends their turn.", 150);
                    return; // Return to end turn
                case 7:
                    //res = wish(); // Reroll resources
                    res[0] = res[1] = res[2] = 10;
                    break;
                default:
                    if (choice < 1 || choice > 6) {
                        displayWithDelay("Invalid choice. Please select an action.", 300); // Error message for invalid choice
                    }
                    break;
            }   
            boolean resourcesExhausted = true;
            // Check if all characters have resources below 2
            for (int r : res) {
                if (r >= 2) {
                    resourcesExhausted = false;
                    break;
                }
            }
            if (resourcesExhausted) {
                displayWithDelay(current.getName() + " has exhausted all resources now it is " + opponent.getName() + " turn",250);
                return ; // End turn if all resources are used up
            }
        } while(current.hasAliveCharacters() && opponent.hasAliveCharacters() || choice == 6);
    }


    
    // current kay AI ; Opponent kay user
    public void computerCombat(Player current, Player opponent) {
        Random rand = new Random();
        int[] res = wish();  // Generate resources (e.g., stamina/energy for each character)
        Characters currentCharacter;
        Characters opponentCurrent = opponent.getCurrentCharacter(); // Get the opponent's current character
        int currentCharacterIndex = this.index; // Track current character index for resources
        int lastCharacterIndex = -1; // Track the last character index used
        boolean actionPerformed = false;
    
        while (current.hasAliveCharacters() && opponent.hasAliveCharacters()) {
            System.out.println("\n===================================");
            System.out.println(opponent.getName() + " (User/You) Current Character");
            System.out.println("Name   : " + opponentCurrent.getName());
            System.out.println("Health : " + opponentCurrent.getHealth());
            System.out.println("Defence: " + opponentCurrent.getDefence());

            if (opponentCurrent.getShield() > 0) {
                System.out.println("Shield : " + opponentCurrent.getShield());
                System.out.println("===================================");
            } else {
                System.out.println("===================================");
            }
    
            currentCharacter = current.getCurrentCharacter();
            int availableResource = res[currentCharacterIndex]; // Use local index to get resources for current character
            currentCharacter.choices(res[currentCharacterIndex], 2);
            // Determine the attack based on available resources and use performAttack
            if (availableResource >= 8) {
                displayWithDelay("Computer chooses ultimate attack!", 250);
                performAttack(currentCharacterIndex, res, 3, opponentCurrent,opponent, currentCharacter,2); // Ultimate attack
                actionPerformed = true;
            } else if (availableResource >= 5) {
                displayWithDelay("Computer chooses a skill!", 250);
                performAttack(currentCharacterIndex, res, 2, opponentCurrent,opponent, currentCharacter,2); // Skill attack
                actionPerformed = true;
            } else if (availableResource >= 2) {
                displayWithDelay("Computer chooses basic attack!", 250);
                performAttack(currentCharacterIndex, res, 1,  opponentCurrent,opponent, currentCharacter,2); // Basic attack
                actionPerformed = true;
            }
            // Add a 2-second pause after each attack
            try {
                Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  

            if (!opponentCurrent.isAlive()) {
                displayWithDelay("\n" + opponentCurrent.getName() + " has been defeated!",150);
                // Automatically switch to the next alive opponent character
                boolean switched = opponent.switchToNextAliveCharacter();
                if (!switched) {
                    // No more alive characters, opponent loses
                    displayWithDelay("\n" + opponent.getName() + " has no characters left!",150);
                   return;
                }
                opponentCurrent = opponent.getCurrentCharacter(); // Update the opponent's current character
            }
            // If the current character can't act, switch to the next alive character
            if (!actionPerformed) {
                boolean switched = false;
                // Attempt to switch characters
                for (int i = 0; i < 3; i++) {
                    // Generate a random index (1, 2, or 3)
                    int newIndex = rand.nextInt(3); // Generates 0, 1, or 2
                    // Ensure the new index is not the same as the last character index
                    if (newIndex != lastCharacterIndex) {
                        if (current.switchCharacter(newIndex)) { // Switch character
                            currentCharacterIndex = newIndex; // Update index to match the new character
                            lastCharacterIndex = currentCharacterIndex; // Update the last used character
                            switched = true;
                            break;
                        }
                    }
                }
                if (!switched) {
                    System.out.println(current.getName() + " has no more characters with resources to act.");
                    return; // End turn if no action was possible
                }
            }
            // Reset actionPerformed for the next character's turn and check resource exhaustion
            actionPerformed = false;
            boolean resourcesExhausted = true;
            // Check if all characters have resources below 2
            for (int r : res) {
                if (r >= 2) {
                    resourcesExhausted = false;
                    break;
                }
            }
            if (resourcesExhausted) {
                displayWithDelay(current.getName() + " has exhausted all resources now it is " + opponent.getName() + " turn",250);
                return; // End turn if all resources are used up
            }
        }
      
    }


    // Method to perform the chosen attack
    private void performAttack(int i,  int[] res, int choice, Characters opponent,Player oppo,Characters current,int gameMode) {
        switch (choice) {
            case 1: 
                    current.basicAttack(res[i], opponent,gameMode,opponent.getDefence()); 
                    if(res[i] >= 2){
                        res[i] -= 2; 
                    }
                break;
            case 2: // Skill attack
                    current.skill(res[i], opponent,gameMode,opponent.getDefence());
                    if(res[i] >= 5){
                        skillSpecialCases(i, res, choice, opponent, current,gameMode);
                        res[i] -= 5; 
                    }
                break;
            case 3: // Ultimate attack
                    current.ult(res[i], opponent,gameMode,opponent.getDefence());
                    if(res[i] >= 8){
                        ultSpecialCases(i, res, choice, oppo, current, gameMode);
                        res[i] -=8; 
                    }
                break;
            default: // Invalid choice
                System.out.println("Invalid choice for attack.");
                break;
        }
    }

    private void skillSpecialCases(int i,  int[] res, int choice, Characters opponent,Characters current,int gameMode) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean isEnabled = true,isEnabled2 = true,isEnabled3 = true;
        if (current.getName().equals("Guardian")) { // naa diri ang heal sa aquamancer gi implement
            int shieldAmount = current.getRandomBetween(5, 15);
            int shieldChoice = 0;
            if(gameMode == 1){
                while(isEnabled2){
                    try{
                        System.out.println("Which character do you want to be shielded? ");
                        printAllCharacterStatus(res);
                        System.out.println();
                        System.out.print("Your Choice: ");
                        shieldChoice = scan.nextInt() - 1;
                        if(shieldChoice < 0 || shieldChoice > 2){
                            displayWithDelay("\nInvalid Choice! Please enter (1 ,2 ,3 only!)",100);
                        }else{
                            isEnabled2 = false;
                        }
                    }catch(Exception e){
                        displayWithDelay("\nPlease Enter a number!\n",100);
                        scan.next();
                    }
                }
            }else if(gameMode == 2){
                System.out.println("Which character do you want to be shielded? ");
                printAllCharacterStatus(res);
                System.out.println();
                shieldChoice = rand.nextInt(3);
            }
            characters[shieldChoice].setShield(shieldAmount + characters[shieldChoice].getShield());
            displayWithDelay(current.getName() + " focuses intensely, channeling a protective shield!", 150);
            if(gameMode == 1){
                displayWithDelay(characters[shieldChoice].getName() + " is protected by a shield that has " + shieldAmount + " health points.", 150);
                displayWithDelay("You now have " + (res[i]-5) + " stamina left.", 150);
            }else{
                displayWithDelay("Computer chose to shield " + characters[shieldChoice].getName() + " for " + shieldAmount + "health points",150);
                displayWithDelay("Computer has " + (res[i]-5) + " stamina left.", 150);
            } 
        }
        if (current.getName().equals("Verdant Warden")) {
            int healAmount = current.getRandomBetween(0, 8);
            int damage = current.getRandomBetween(10,15) - opponent.getDefence();
            int healChoice = 0;
            if(gameMode == 1){
                while(isEnabled){
                    try{
                        System.out.println("Choose Character to heal: ");
                        printAllCharacterStatus(res);
                        System.out.println();
                        System.out.print("Your Choice: ");
                        healChoice = scan.nextInt() - 1;
                        if(healChoice < 0 || healChoice > 2){
                          displayWithDelay("\nInvalid Choice! Please enter (1 ,2 ,3 only!)",100);
                        }else{
                            isEnabled = false;
                        }
                    }catch(Exception e){
                        displayWithDelay("\nPlease Enter a number!\n",100);
                        scan.next();
                    }
                }
            }else if (gameMode == 2){
                System.out.println("Choose Character to heal: ");
                printAllCharacterStatus(res);
                System.out.println();
                healChoice = rand.nextInt(3);
            }
            characters[healChoice].heal(healAmount);
            opponent.takeDamage(damage);
            displayWithDelay(current.getName() + " channels nature's energy, creating a healing aura!", 150);
            displayWithDelay(characters[healChoice].getName() + " receives " + healAmount + " health from the soothing energy!", 150);
            if (gameMode == 1) {
                displayWithDelay("The enemy's " + opponent.getName() + " has been blasted by nature's fierce power, taking " + damage + " damage!", 150);
                displayWithDelay("You now have " + (res[i] - 5) + " spirit left.", 150);
            } else {
                displayWithDelay("The " + current.getName() + " (user's character) has blasted " + opponent.getName() + " with nature's fierce power, taking " + damage + " damage!", 150);
                displayWithDelay("Computer has " + (res[i] - 5) + " spirit left.", 150);
            }
        }
        if (current.getName().equals("Aquamancer")) {
            int healAmount = current.getRandomBetween(5, 12);
            int healChoice = 0;
            if(gameMode == 1){
                while(isEnabled3){
                    try {        
                    System.out.println("Which character do you want to be healed?");
                    printAllCharacterStatus(res);
                    System.out.println();
                    System.out.print("Your Choice: ");
                     healChoice = scan.nextInt() - 1;
                     if(healChoice < 0 || healChoice > 2){
                        displayWithDelay("\nInvalid Choice! Please enter (1 ,2 ,3 only!)",100);
                      }else{
                          isEnabled3 = false;
                      }
                    } catch (Exception e) {
                        displayWithDelay("\nPlease Enter a number!\n",100);
                        scan.next();
                    }
                }
            }else if(gameMode == 2){
                System.out.println("Which character do you want to be healed?");
                printAllCharacterStatus(res);
                System.out.println();
                healChoice = rand.nextInt(3);
            }
            characters[healChoice].heal(healAmount);
            if(gameMode == 1){
                displayWithDelay(current.getName() + " weaves a healing spell and releases it to soothe the wounds of an ally!", 150);
                displayWithDelay("The spell provides a burst of rejuvenation and restores " + healAmount + " health, replenishing the ally's strength!", 150);
                displayWithDelay("You now have " + (res[i]-5) + " mana left.", 150);
            }else{
                displayWithDelay("Computer chose to heal " + characters[healChoice].getName() + " for " + healAmount + "health points",150);
                displayWithDelay("Computer has " + (res[i]-5) + " mana left.", 150);
            } 
        }
    }

    private void ultSpecialCases(int i,  int[] res, int choice, Player opponent,Characters current, int gameMode) {
        if (current.getName().equals("Aquamancer")) { // naa diri ang heal sa aquamancer gi implement
            int healAmount = current.getRandomBetween(10, 15);
            displayWithDelay(current.getName() + " channels their power and releases a wave of healing energy!", 150);
            healAllCharacters(healAmount);
            displayWithDelay("All allies are healed for " + healAmount + " health points!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + (res[i]-8) + " mana left.", 150);
            }else{
                displayWithDelay("Computer has " + (res[i]-8) + " mana left.", 150);
            } 
        }
        if (current.getName().equals("Verdant Warden")) {
            int healAmount = current.getRandomBetween(8, 12);
            int damage = current.getRandomBetween(15, 17);
            displayWithDelay(current.getName() + " channels nature's energy, unleashing a flurry of arrows!", 150);
            displayWithDelay("Each enemy takes " + damage + " damage from the barrage!", 150);
            displayWithDelay("In, addition, all allies receive " + healAmount + " health!", 150);
            healAllCharacters(healAmount);
            damageAllEnemies(damage, opponent);
            if(gameMode == 1){
                displayWithDelay("You now have " + (res[i]-8) + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + (res[i]-8) + " spirit left.", 150);
            } 
        }
        if (current.getName().equals("Guardian")) {
            int shieldAmount = current.getRandomBetween(5, 10);
            shieldAllAllies(shieldAmount);
            displayWithDelay(current.getName() + " raises their shield, protecting all allies with unwavering resolve!", 150);
            displayWithDelay("All allies receive " + shieldAmount + " sheild!", 150);
            displayWithDelay("The shield deflects incoming attacks, ensuring the safety of the entire team!", 150);     
            if(gameMode == 1){
                displayWithDelay("You now have " + (res[i]-8) + " stamina left.", 150);
            }else{
                displayWithDelay("Computer has " + (res[i]-8) + " stamina left.", 150);
            } 
        } 
    }

    public void damageAllEnemies(int damage, Player opponent) {
        Characters[] chars = opponent.getAllCharacters();
        for (Characters character : chars) {
            if (character.isAlive()) {
                character.takeDamage(damage);
            }
        }
    }

    public void shieldAllAllies(int shieldAmount) {
        for (Characters character : characters) {
            if (character.isAlive()) {
                character.setShield(shieldAmount + character.getShield());
            }
        }
    }

    public void healAllCharacters(int healAmount) {
        for (Characters character : characters) {
            if (character.isAlive()) {
                character.heal(healAmount);
            }
        }
    }
}
