import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Story s1 = new Story();
        WarriorLore w1 = new WarriorLore();
        MageLore m1 = new MageLore();
        RangerLore r1 = new RangerLore();
        Scanner scan = new Scanner(System.in);
        int loreChoice, skip;
        String mc = "okarun";
        String warrior = "Guardian";
        String ranger = "Arcane musketeer";
        String mage = "Ember witch";
        String kingdom = "Camelot";
        System.out.println("Echoes of War: The Guardian's Path");
        System.out.print("Do you want to read the story?(1-YES/2-NO): ");
        skip = scan.nextInt();

        // put invalid things once we finalize 
        if(skip == 1){
        // if skips then go to method that lets you chooses the char and the kingdom
        Thread.sleep(1000);
        //s1.tellStoryIntro(mc);
        Thread.sleep(1000);
        // dre na part naay choosing method before mo continue and story
        //s1.chooseKingdom(etc,etc,etc)
        s1.tellStoryKingdom(kingdom,mc,warrior,ranger,mage);
        Thread.sleep(1000);
        s1.tellStoryEnd(mc);
        // TOTAL STORY TIME FROM START TO FINISH IS 5:37 minutes 
        // I change lang ni nato ang delay time kung maka finalize nata sa tanan
        }else{
            System.out.print("Do you want to read the lores of the characters?(1-YES/2-NO): ");
            loreChoice = scan.nextInt();
            // DILI PANI FINAL
            if(loreChoice == 1){
                char classChoice;

                System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
                classChoice = Character.toUpperCase(scan.next().charAt(0));
            
                switch(classChoice) {
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
            }else{
                //do you wnat to play the game
            }
        }
    }
}
