import java.util.*;
public class Combat implements CombatInterface {
    Scanner scan = new Scanner(System.in);
    ChoicesPVE unit = new ChoicesPVE();

    @Override
    public void wish() {
        System.out.print("Press Enter key to wish...");
        scan.nextLine();
        int[] result = generateNumbers();
        System.out.println("You have received: ");
        System.out.println("Stamina: " + result[0] + ", Mana: " + result[1] + ", Spirit: " + result[2] + ", Energy: " + result[3]);
    }

    private int combatUI(){
        System.out.println("Current Character: Guardian" ); //default (need pa i-dynamic(Guardian for now))
        System.out.println("Choose move:");
        System.out.println("    1) Basic Attack");
        System.out.println("    2) Skill");
        System.out.println("    3) Ultimate");
        System.out.println("    4) Switch Character");
        System.out.print("Your move: ");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    @Override
    public void startBattle(){
        int choice;
        do {
            wish();
            while(true){
                choice = combatUI();
                if(choice == 1){
                    //basic attk
                    break;
                } else if (choice == 2){
                    // skill attk
                    break;
                } else if (choice == 3){
                    // ultimate
                    break;
                } else if (choice == 4){
                    // character switch
                    break;
                } else {
                    System.out.println("INVALID OPTION!");
                }
            }

        } while (false); // check if all characters can still fight (false for now)
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
