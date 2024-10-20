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


        @Override
        // need pani i change
        public void display(String[] chars) {
            int[] res = wish();  // Assume res[0] is stamina
            Scanner scan = new Scanner(System.in);
            int choice;
            Character g1 = null;
            int i, track = 0;
            if (chars[0].equalsIgnoreCase("guardians")) {
                g1 = new Guardian();
            } else if (chars[0].equalsIgnoreCase("general")) {
                g1 = new General();
            }
            Character m1 = null;

            if (chars[1].equalsIgnoreCase("ember witch")) {
                m1 = new EmberWitch();
            } else if (chars[1].equalsIgnoreCase("aquamancer")) {
                m1 = new Aquamancer();
            }
            Character r1 = null;
            if (chars[2].equalsIgnoreCase("shadow strider")) {
                r1 = new ShadowStrider();
            } else if (chars[2].equalsIgnoreCase("verdant warden")) {
                r1 = new VerdantWarden();
            }


            do {
                //String[] types = {g1.getType(), m1.getType(), r1.getType()};
                switch (track) {
                    case 0:
                        i = 0;
                        g1.choices(chars[i],  res[i]);
                        break;
                    case 1:
                        i = 1;
                        m1.choices(chars[i], res[i]);
                        break;
                    case 2:
                        i = 2;
                        r1.choices(chars[i], res[i]);
                        break;
                    default:
                        i = 0;
                        track = 0;
                        g1.choices(chars[i], res[i]);
                        break;
                }

                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                            if(i == 0){
                                g1.basicAttack(chars[i], res[i]);
                            }else if(i == 1){
                                m1.basicAttack(chars[i], res[i]);
                            }else if(i == 3){
                                r1.basicAttack(chars[i], res[i]);
                            }
                            res[i] -= 2;
                        break;
                    case 2:
                            if(i ==0){
                                g1.skill(chars[i], res[i]);
                                res[i]-=3;
                            }else if(i == 1){
                                m1.skill(chars[i],res[i]);
                                res[i]-=5;
                            }else if(i == 3){
                                r1.skill(chars[i], res[i]);
                                res[i] -= 5;
                            }
                        break;
                    case 3:
                        if(i == 0){       
                        g1.ult(chars[i], res[i]);
                        res[i]-=5;
                        }else if(i == 1){
                            m1.ult(chars[i],res[i]);
                            res[i] -= 8;
                        }else if(i == 3){
                            r1.ult(chars[i], res[i]);
                            res[i] -= 8;
                        }
                        break;
                    case 4:
                        // naay bug sa verdant warden dili ma switch
                        if(i == 0){
                            g1.switchCharacter(chars[i], res[i]);
                        }else if(i == 1){
                            m1.switchCharacter(chars[i], res[i]);
                        }else{
                            r1.switchCharacter(chars[i], res[i]);
                           }    
                        track++;
                        break;
                    case 5:
                        res = wish(); // Reroll stamina/energy
                        break;
                    default:
                        displayWithDelay(chars[i] + " decides to regroup and ends their turn.", 150);
                        break;
                }
            } while (choice != 6);
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

