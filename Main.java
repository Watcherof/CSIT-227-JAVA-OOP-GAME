import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Combat combat = new Combat();
        Story s1 = new Story();
        General g1 = new General();
        WarriorLore w1 = new WarriorLore();
        MageLore m1 = new MageLore();
        int player = 9;
        ChoicesPVE c1 = new ChoicesPVE(player);
        RangerLore r1 = new RangerLore();
        Scanner scan = new Scanner(System.in);
        String mc;
        String warrior = "Guardian";
        String ranger = "Arcane Musketeer";
        String mage = "Ember Witch";
        String kingdom = "Camelot";

        int loreChoice, skip, chooseMode;

        System.out.println("Echoes of War: The Guardian's Path");
        System.out.print("Enter your name: ");
        mc = scan.nextLine();

        System.out.print("Choose mode (1-PVP/2-PVE): ");
        chooseMode = scan.nextInt();
    

        if (chooseMode == 1) {
            System.out.println("You have chosen player versus player!");
            c1.characterSelection();
            c1.selectCharacters();
            c1.displayCharacters(c1.getChosenCharacters());
            player1.chars();
            player1.wish();
            player2.wish();
        } else if (chooseMode == 2) {
            System.out.println("You have chosen player vs environment!");
            c1.characterSelection();
            c1.selectCharacters();
            c1.displayCharacters(c1.getChosenCharacters());
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
        //BATTLE
        //////////////////////
        combat.display(c1.getChosenCharacters(),g1.getHealth(),g1.getDefence() );
        //////////////////

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
