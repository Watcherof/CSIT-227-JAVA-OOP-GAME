import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Player player1 = new Player(1);
        //Player player2 = new Player(2);  
        Combat player1Combat = new Combat();
        Combat player2Combat = new Combat();
        Choices c1 = new Choices(1);
        Choices c2 = new Choices(2);
        Story s1 = new Story();
        WarriorLore w1 = new WarriorLore();
        MageLore m1 = new MageLore();
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
            c1.characterSelectionPVP1();
            c1.selectCharacters();
            c1.displayCharacters(c1.getChosenCharacters());

            System.out.println("Player 1 has chosen. Press Enter for Player 2 to choose.");
            scan.nextLine(); 
            scan.nextLine(); 

            c2.characterSelectionPVP2();
            c2.selectCharacters();
            c2.displayCharacters(c2.getChosenCharacters());
        } else if (chooseMode == 2) {
            System.out.println("You have chosen player vs environment!");
            c1.characterSelectionPVE(mc);
            c1.selectCharacters();
            c1.displayCharacters(c1.getChosenCharacters());
        }

        // Option to read the story
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

        // BATTLE SECTION (PVP/PVE)

        // TEMp
            if (chooseMode == 1) {
                System.out.println("Combat starts!");
                boolean gameOver = false;
                int currentPlayer = 1;
                int player1Damage,player2Damage;
                    while (!gameOver) {
                        if (currentPlayer == 1) {
                            System.out.println("Player 1's turn:");
                            player1Damage = player1Combat.combat(c1.getChosenCharacters());
                            if (player1Damage == -21) {
                                System.out.println("Player 1's characters are all defeated! Player 2 wins!");
                                gameOver = true;
                                break;
                            }else{
                                player2Combat.damageTaken(c2.getChosenCharacters(), player1Damage);
                                ++currentPlayer;
                            } 
                        } 
                        if(currentPlayer == 2) {
                            System.out.println("Player 2's turn:");
                            player2Damage = player2Combat.combat(c2.getChosenCharacters());
                            if (player2Damage == -21) {
                                System.out.println("Player 2's characters are all defeated! Player 1 wins!");
                                gameOver = true;
                                break;
                            }else{
                                player1Combat.damageTaken(c1.getChosenCharacters(), player2Damage);
                                --currentPlayer;
                            }
                        }
                    }
                }else if (chooseMode == 2) {
                    System.out.println("PVE mode. Player 1 fights!");
                    int player1Damage = player1Combat.combat(c1.getChosenCharacters());
                    if (player1Damage == -21) {
                        System.out.println("Player 1's characters are all defeated! Game over.");
                    }
                }

        // Option to read the character lore
        System.out.print("Do you want to read the lores of the characters? (1-YES/2-NO): ");
        loreChoice = scan.nextInt();
        if (loreChoice == 1) {
            System.out.print("Enter corresponding letters [M-mage, R-Ranger, W-Warrior]: ");
            char classChoice = scan.next().charAt(0);
            switch (classChoice) {
                case 'W':
                    w1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    w1.tellCharLoreSupport();
                    break;
                case 'M':
                    m1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    m1.tellCharLoreSupport();
                    break;
                case 'R':
                    r1.tellCharLoreAttack();
                    Thread.sleep(1000);
                    r1.tellCharLoreSupport();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter M, R, or W.");
                    break;
            }
        }

        scan.close(); // Close the scanner to prevent resource leaks
    }
}
