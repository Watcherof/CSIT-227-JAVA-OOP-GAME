import java.util.*;
public class Combat extends Character implements CombatInterface {
    
    public void displayWithDelay(String text, int delayInMillis) {
        String[] words = text.split(" ");  // Split text into words
        for (String word : words) {
            System.out.print(word + " ");   // Print each word followed by a space
            try {
                Thread.sleep(delayInMillis); // Delay between each word
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); 
            }
        }
        System.out.println(); 
    }
    @Override
    public int[] wish() {
        System.out.println("\nPress Enter key to wish...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int[] result = generateNumbers();
        System.out.println("You received: ");
        System.out.println("Stamina: " + result[0] + ", Mana: " + result[1] + ", Spirit: " + result[2] + ", Energy: " + result[3]);


        return result;
    }

     

    @Override
    // need pani i change
    public void display(String[] chars, int health, int defence) {
        int[] res = wish();  // Assume res[0] is stamina
        Scanner scan = new Scanner(System.in);
        int choice;
        General g1 = new General();
        String type = " ";
        int i = 0;
        

    
        do {
            System.out.println("Your current character: " + chars[i] + " (Health: " + health + " | Defence: " + defence + " | " + type + ": " + res[0] + ")");
            System.out.println("\nChoose Attack: ");
            System.out.println("1) Basic Attack (Cost: 2 Stamina)");
            System.out.println("2) Skill (Cost: 3 Stamina)");
            System.out.println("3) Ultimate Skill (Cost: 5 Stamina)");
            System.out.println("4) Switch Character");
            System.out.println("5) Reroll(For demonstration)");
            System.out.println("6) End Turn");
            System.out.print("\nYour Choice: ");
    
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    if (res[i] < 2) {
                        System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");  
                    } else {
                        res[i] -= 2;  
                        displayWithDelay(chars[i] + " charges towards the enemies with a swift basic attack!", 150); 
                        displayWithDelay("They hit the enemies, dealing " + g1.basicAttack() + " damage.", 150);  // 0-10 damage range
                        displayWithDelay("You now have " + res[i] + " stamina/energy left.", 150);
                    }
                    break;
            
                case 2:
                    if (res[i] < 3) {
                        System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!"); 
                    } else {
                        res[i] -= 3; 
                        displayWithDelay(chars[i] + " focuses intensely, channeling a devastating skill!", 150); 
                        displayWithDelay("Critical damage is inflicted upon the enemies dealing " + getRandomBetween(11,15) + " to tne enemies!", 150);
                        displayWithDelay("You now have " + res[i] + " stamina/energy left.", 150);
                    }
                    break;
            
                case 3:
                    if (res[i] < 5) {
                        System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
                    } else {
                        res[i] -= 5;  
                        displayWithDelay(chars[i] + " unsheathes dual swords, unleashing their ultimate technique!", 150);  
                        displayWithDelay("The skill's damage is doubled as the dual swords tear through the battlefield, dealing " + getRandomBetween(16,25 ) , 150);
                        displayWithDelay("You now have " + res[i] + " stamina/energy left.", 150);
                    }
                    break;
            
                case 4:
                    if (res[i] < 1) {
                        displayWithDelay("Insufficient Stamina or Energy to switch! Please END TURN!", 150); 
                    } else {
                        res[i] -= 1;
                        displayWithDelay(chars[i] + " calls for reinforcements! A new character is ready to fight!", 150); 
                        displayWithDelay("You now have " + res[i] + " stamina/energy left.", 150);
                      
                    }
                    break;
                case 5:
                    res = wish(); 
                    break;
                default:
                    displayWithDelay(chars[i] + " decides to regroup and ends their turn.", 150);  
                    break;
            }
            
            
        } while (choice != 6);

    }
    

    private int[] generateNumbers() {
        Random random = new Random();
        int[] numbers = new int[4];
        int sum = 10; // We want the sum of the four numbers to be exactly 10

        // Generate three random numbers between 0 and the remaining sum
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(Math.min(sum + 1, 11)); // Ensure sum does not exceed 10
            sum -= numbers[i]; // Subtract the generated number from the sum
        }

        // The fourth number should be the remainder of the sum to ensure total sum is 8
        numbers[3] = sum;
        return numbers;
    }

    int[] getPoints() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

