import java.util.*;
public class Aquamancer extends Characters {

    public Aquamancer() {
        super("Aquamancer", 80, 5, "Mana");
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return;
        }
        res -=2;
        int damage = getRandomBetween(0, 3); // Damage dealt by the attack
        // Display the attack message
        displayWithDelay(super.getName() + " conjures a concentrated energy blast and launches it at the enemies!", 150);
        displayWithDelay("The blast strikes the enemies, dealing " + damage + " magic damage.", 150);
        if(gameMode == 1){
            displayWithDelay("You now have " + res + " mana left.", 150);
        }else{
            displayWithDelay("Computer has " + res + " mana left.", 150);
        }
        
        opponent.takeDamage(damage);
    }

    @Override
    //TODO    
    // implement the healing shit here ty
    public void skill(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
    
        if (res < 5) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return;
        }
        res -= 5;
       
        int healAmount = getRandomBetween(1, 3); // Amount of shield provided to an ally
        // Display the attack and support messages
        displayWithDelay(super.getName() + " weaves a healing spell and releases it to soothe the wounds of an ally!", 150);
        displayWithDelay("The spell restores " + healAmount + " health, bringing them back from the brink of defeat.", 150);
        displayWithDelay("In addition, " + super.getName() + " provides a burst of rejuvenation, replenishing the ally's strength!", 150);
        if(gameMode == 1){
            displayWithDelay("You now have " + res + " mana left.", 150);
        }else{
            displayWithDelay("Computer has " + res + " mana left.", 150);
        }
        //healAlly() or something
    }

    @Override
    // TODO
    // IMPLEMENT THE AOE ULT which is heal
    public void ult(int res, Characters opponent,int gameMode) {
        if (res < 8) { 
            displayWithDelay("Insufficient Mana or Energy to perform the AoE Heal! Please END TURN!", 150);
            return;
        }
    
        // Display the AoE heal message
        displayWithDelay(super.getName() + "channels their power and releases a wave of healing energy!", 150);
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
        System.out.println("1) Basic Attack (Cost: 2 Mana | Damage: 0 - 3)");
        System.out.println("2) Skill (Cost: 5 Mana | Heal(Single Ally): 0 - 10)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana| Heal(All ally):10 - 25)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");
        
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
  
    
}
