import java.util.*;
public class Combat implements CombatInterface {
    @Override
    public void wish() { 
        System.out.println("Press Enter key to wish...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int[] result = generateNumbers();
        System.out.println("Your received: ");
        System.out.println("Mana: " + result[0] + ", Stamina: " + result[1] + ", Spirit: " + result[2] + ", Energy: " + result[3]);
    
        scan.close();
    }

    private int[] generateNumbers() {
        Random random = new Random();
        int[] numbers = new int[4];

        // Generate three random numbers between 0 and 8
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(9);  // generates numbers from 0 to 8
        }

        // Calculate the last number so the sum equals 8
        int sum = numbers[0] + numbers[1] + numbers[2];
        numbers[3] = 8 - sum;

        // If the last number goes out of range, regenerate
        while (numbers[3] < 0 || numbers[3] > 8) {
            for (int i = 0; i < 3; i++) {
                numbers[i] = random.nextInt(9);
            }
            sum = numbers[0] + numbers[1] + numbers[2];
            numbers[3] = 8 - sum;
        }

        return numbers;
    }
} 
