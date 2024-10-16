import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Combat combat = new Combat();
        Story s1 = new Story();
        WarriorLore w1 = new WarriorLore();
        MageLore m1 = new MageLore();
        ChoicesPVE c1 = new ChoicesPVE();
        RangerLore r1 = new RangerLore();
        Scanner scan = new Scanner(System.in);
        String mc;
        String warrior = "Guardian";
        String ranger = "Arcane Musketeer";
        String mage = "Ember Witch";
        String kingdom = "Camelot";

        int loreChoice, skip, chooseMode;

        System.out.println("Echoes of War: The Guardian's Path");
        System.out.println("Enter your name: ");
        mc = scan.nextLine();
        System.out.print("Choose mode (1-pvp/2-pve): ");
        chooseMode = scan.nextInt();
    

        if (chooseMode == 1) {
            System.out.println("You have chosen player versus player!");
        } else if (chooseMode == 2) {
            System.out.println("You have chosen player vs environment!");
            c1.characterSelection();
            c1.selectCharacters(); 
            c1.displayCharacters(c1.getChosenCharacters());
            //combat.wish();
            // After this, the battle starts
        }

        System.out.print("Do you want to read the story? (1-YES/2-NO): ");
        skip = scan.nextInt();

        if (skip == 1) {
            Thread.sleep(1000);
            s1.tellStoryIntro(mc);
            Thread.sleep(1000);
            s1.tellStoryKingdom(kingdom, mc, warrior, ranger, mage);
            Thread.sleep(1000);
            s1.tellStoryEnd(mc);
        }
        System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
        loreChoice = scan.nextInt();
        // add lang ta og invalid selection dre
        if (loreChoice == 1) {
            System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
            char classChoice = scan.next().charAt(0);
            switch (classChoice) {
                case 'W': {
                    w1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    w1.tellCharLoreSupport();
                    break;
                }
                case 'M': {
                    m1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    m1.tellCharLoreSupport();
                    break;
                }
                case 'R': {
                    r1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    r1.tellCharLoreSupport();
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please enter M, R, or W.");
                }
            }
        }
        scan.close(); // Close the scanner to prevent resource leaks
    }
}
