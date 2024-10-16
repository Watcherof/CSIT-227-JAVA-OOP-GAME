import java.util.*;
import java.util.Scanner;
public class Combat implements CombatInterface {
    @Override
    public void wish() {
        System.out.println("Press Enter key to wish...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int[] result = generateNumbers();
        System.out.println("Your received: ");
        System.out.println("Stamina: " + result[0] + ", Mana: " + result[1] + ", Spirit: " + result[2] + ", Energy: " + result[3]);
        scan.close();
    }

    private int[] generateNumbers() {
        Random random = new Random();
        int[] numbers = new int[4];
        int sum = 8; // We want the sum of the four numbers to be exactly 8

        // Generate three random numbers between 0 and 8
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(Math.min(sum + 1, 9)); // Ensure sum does not exceed 8
            sum -= numbers[i]; // Subtract the generated number from the sum
        }

        // The fourth number should be the remainder of the sum to ensure total sum is 8
        numbers[3] = sum;

        return numbers;
    }
}
