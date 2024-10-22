import java.util.*;
public class Combat extends Character implements CombatInterface {

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


    ///// TEMP
 
    public void damageTaken(String[] chars, int damage) {
        Character currentCharacter = null;
        // Determine which character is currently active for the player taking damage
        if (chars[0].equalsIgnoreCase("general")) {
            currentCharacter = new General();
        } else{
            currentCharacter = new Guardian();
        }
        // Check if the current character is not null before taking damage
          currentCharacter.takeDamage(damage);
    }
    @Override
    // DILI PANI FINAL 
    public int combat(String[] chars) {
        int[] res = wish();  // Assume res[0] is stamina or energy
        Scanner scan = new Scanner(System.in);
        Character g1 = null, m1 = null, r1 = null;
        int i = 0, track = 0, choice, damage = 0,a = 0;

        // Initialize characters based on the chosen characters
        if (chars[0].equalsIgnoreCase("guardians")) {
            g1 = new Guardian();
        } else if (chars[0].equalsIgnoreCase("general")) {
            g1 = new General();
        }

        if (chars[1].equalsIgnoreCase("ember witch")) {
            m1 = new EmberWitch();
        } else if (chars[1].equalsIgnoreCase("aquamancer")) {
            m1 = new Aquamancer();
        }

        if (chars[2].equalsIgnoreCase("shadow strider")) {
            r1 = new ShadowStrider();
        } else if (chars[2].equalsIgnoreCase("verdant warden")) {
            r1 = new VerdantWarden();
        }

        do {
            switch (track) {
                case 0:
                    i = 0;
                    g1.choices(chars[i], res[i],damage);
                    break;
                case 1:
                    i = 1;
                    m1.choices(chars[i], res[i],damage);
                    break;
                case 2:
                    i = 2;
                    r1.choices(chars[i], res[i],damage);
                    break;
                default:
                    i = 0;
                    track = 0;
                    g1.choices(chars[i], res[i],damage);
                    break;
            }

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    // Basic attack
                    if (i == 0) {
                        damage = g1.basicAttack(chars[i], res[i]);
                    } else if (i == 1) {
                        damage = m1.basicAttack(chars[i], res[i]);
                    } else if (i == 2) {
                        damage = r1.basicAttack(chars[i], res[i]);
                    }
                    res[i] -= 2;
                    break;
                case 2:
                    // Skill attack
                    if (i == 0) {
                        damage = g1.skill(chars[i], res[i]);
                        res[i] -= 3;
                    } else if (i == 1) {
                        damage = m1.skill(chars[i], res[i]);
                        res[i] -= 5;
                    } else if (i == 2) {
                        damage = r1.skill(chars[i], res[i]);
                        res[i] -= 5;
                    }
                    break;

                case 3:
                    // Ultimate attack
                    if (i == 0) {
                        damage = g1.ult(chars[i], res[i]);
                        res[i] -= 5;
                    } else if (i == 1) {
                        damage = m1.ult(chars[i], res[i]);
                        res[i] -= 8;
                    } else if (i == 2) {
                        damage = r1.ult(chars[i], res[i]);
                        res[i] -= 8;
                    }
                    break;

                case 4:
                    // Switch character
                    if (i == 0) {
                        g1.switchCharacter(chars[i], res[i]);
                    } else if (i == 1) {
                        m1.switchCharacter(chars[i], res[i]);
                    } else {
                        r1.switchCharacter(chars[i], res[i]);
                    }
                    track++;  // Move to the next character
                    break;

                case 5:
                    // Reroll stamina/energy
                    res = wish();
                    break;

                case 6:
                    // End turn
                    displayWithDelay(chars[i] + " decides to regroup and ends their turn.", 150);
                    return 0;

                default:
                    displayWithDelay("Invalid choice. Please select an action.", 300);
                    break;
                
            }
        } while (g1.getHealth() > 0 || m1.getHealth() > 0 || r1.getHealth() > 0 || choice == 6);
        if (g1.getHealth() == 0 && m1.getHealth() == 0 && r1.getHealth() == 0) {
            return -21;  // Indicate player has lost
        }

        return damage;
    }

    
    
    

    
    @Override
    public int[] generateNumbers() {
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

