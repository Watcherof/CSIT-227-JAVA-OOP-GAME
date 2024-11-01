import java.util.*;
public class Guardian extends Characters{

    public Guardian() {
        super("Guardian", 150, 10, "Stamina");
        //TODO Auto-generated constructor stub
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode) {
        int damage = getRandomBetween(1, 4); // Damage dealt by the basic attack
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 2; // Cost for the basic attack
            // Display the supportive action message
            displayWithDelay(super.getName() + " swings their weapon to strike the enemy while shielding allies!", 150);
            displayWithDelay("They deal " + damage + " damage to the enemy and provide a protective stance for allies!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " stamina left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " stamina left.", 150);
            }
            
        }
        opponent.takeDamage(damage);
    }

    @Override
    // TODO IMPLEMENT SHIDEL SYSTEM
    public void skill(int res, Characters opponent,int gameMode) {
        if (res < 5) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
        } else {
            System.out.println("Which character do you want to be shielded? ");
        }
    }

    @Override
    // AOE SHIELD NI 
    public void ult(int res, Characters opponent,int gameMode) {
        int damage = getRandomBetween(16, 25);
        if (res < 8) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 8;
            displayWithDelay(super.getName() + " unsheathes dual swords, unleashing their ultimate technique!", 150);
            displayWithDelay("The skill's damage is doubled as the dual swords tear through the battlefield, dealing " + damage + " damage!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " stamina left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " stamina left.", 150);
            }
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void switchCharacter(int res) {
            displayWithDelay(super.getName() + " calls for reinforcements! A new character is ready to fight!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);

    }
   

    @Override
    public int getRandomBetween(int min, int max) {
       if (min > max) {
           throw new IllegalArgumentException("Min should be less than or equal to Max");
       }
       Random random = new Random();
       // Generate random number between min (inclusive) and max (inclusive)
       return random.nextInt((max - min) + 1) + min;
   }

     @Override
     public void choices( int res,int gameMode) {
            if(gameMode == 1){
                if (super.getShield() > 0) {
                    System.out.println("\nYour current character: " + super.getName() + " (Health: " + super.getHealth() + " | Defence: " + super.getDefence() + " | " + this.type + ": " + res + " | Shield: " + super.getShield() + ")");
                } else {
                    System.out.println("\nYour current character: " + super.getName() + " (Health: " + super.getHealth() + " | Defence: " + super.getDefence() + " | " + this.type + ": " + res + ")");
                }
            }else{
                if (super.getShield() > 0) {
                    System.out.println("\nComputer current character: " + super.getName() + " (Health: " + super.getHealth() + " | Defence: " + super.getDefence() + " | " + this.type + ": " + res + " | Shield: " + super.getShield() + ")");
                } else {
                    System.out.println("\nComputer current character: " + super.getName() + " (Health: " + super.getHealth() + " | Defence: " + super.getDefence() + " | " + this.type + ": " + res + ")");
                }
            }
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Stamina)");
        System.out.println("2) Skill (Cost: 5 Stamina)");
        System.out.println("3) Ultimate Skill (Cost: 8 Stamina)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll (For demonstration)");
        System.out.println("6) End Turn");

        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
        }

}
