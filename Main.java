import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        //Combat combat = new Combat();
        Story s1 = new Story();
        WarriorLore w1 = new WarriorLore();
        MageLore m1 = new MageLore();
        ChoicesPVE c1 = new ChoicesPVE();
        RangerLore r1 = new RangerLore();
        Combat combat = new Combat();
        Scanner scan = new Scanner(System.in);
        int loreChoice, skip, chooseMode;
        String mc = "okarun";
        String warrior = "Guardian";
        String ranger = "Arcane Musketeer";
        String mage = "Ember Witch";
        String kingdom = "Camelot";

        System.out.println("Echoes of War: The Guardian's Path");
  
        System.out.print("Choose mode (1-PVP/2-PVE): ");
        chooseMode = scan.nextInt();

        if (chooseMode == 1) {
            System.out.println("You have chosen player versus player!");
        } else if (chooseMode == 2) {
            System.out.println("You have chosen player vs environment!");
            c1.characterSelection();
            c1.selectCharacters(); 
            c1.displayCharacters(c1.getChosenCharacters());
            // after ani kay start battle na 
            combat.wish();
        }

        System.out.print("Do you want to read the story? (1-YES/2-NO): ");
        skip = scan.nextInt();
        // put try catch once we finalize things
        if (skip == 1) {
            // If skips, then go to method that lets you choose the char and the kingdom
            Thread.sleep(1000);
            s1.tellStoryIntro(mc);
            Thread.sleep(1000);
            // dre na part naay choosing method before mo continue and story
            //s1.chooseKingdom(etc,etc,etc)
            s1.tellStoryKingdom(kingdom, mc, warrior, ranger, mage);
            Thread.sleep(1000);
            s1.tellStoryEnd(mc);
            // TOTAL STORY TIME FROM START TO FINISH IS 5:37 minutes 
            // I change lang ni nato ang delay time kung maka finalize nata sa tanan
        }
        System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
        loreChoice = scan.nextInt();
        // DILI PANI FINAL
        if (loreChoice == 1) {
            System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
            char classChoice = scan.next().charAt(0);

            switch ((classChoice)) {
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
        } else {
            // Do you want to play the game?
        }

        

        scan.close(); // Close the scanner to prevent resource leaks
    }
}
