import java.util.*;
public class Combat implements CombatInterface {

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
    public void display(String[] chars,int health,int defence) {
        int[]res = wish();
        Scanner scan = new Scanner(System.in);
        int choice;
            General g1 = new General();
        String type = " ";
        int i = 0;
            if(i == 0){
            type = g1.getType();
            }

        do { 
            
            System.out.println("You current character: " + chars[i] + " (Health: " + health + "|Defence: " + defence + "|" + type + ": " + res[0] + ")");
            System.out.println("\nChoose Attack: ");
            System.out.println("1) Basic Attack");
            System.out.println("2) Skill");
            System.out.println("3) Ultimate SKill");
            System.out.println("4) Switch Character");
            System.out.println("5) End Turn");
            System.out.println("\nYour Choice: ");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(chars[i]+" uses basic attack!");
                    break;
                case 2:
                    System.out.println(chars[i]+" uses a skill!");
                    break;
                case 3:
                    System.out.println(chars[i]+" uses an ULTIMATE SKILL!");
                    break;
                case 4:
                    System.out.println(chars[i]+" calls for backup.");
                    break;
                default:
                    System.out.println(chars[i]+" ends its turn.");
                    break;
            }
        } while (choice != 5);
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

