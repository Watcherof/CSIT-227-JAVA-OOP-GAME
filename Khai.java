import java.util.*;
public class Khai extends Characters{

    public Khai() {
        super("Khai", 1000000, 1000000, "Stamina");
       
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = 1111111; // Damage dealt by the basic attack
        if (res < 0) {
            res = 0;
        }
        if (res < 4) {
            System.out.println(super.getName() + " clenches his palm creating the required energy.");
        }
            // Display the supportive action message
        displayWithDelay(super.getName() + " rewrites the enemies HP into a fourth.", 150);
        displayWithDelay(super.getName() + " takes 1/4 of the enemy manipulating its HP to its likeness.", 150);  
        opponent.takeDamage(damage);
    }

    @Override
    // TODO IMPLEMENT SHIDEL SYSTEM
    public void skill(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 5) {
            displayWithDelay(super.getName()+ " gathers energy around his whole body.", 150);
        }
        displayWithDelay(super.getName() + " takes 1/2 of the enemy. \"Half\" he murmured.", 150);  
        int damage = 9999999;
        opponent.takeDamage(damage);
    }

    @Override
    // AOE SHIELD NI 
    public void ult(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 10) {
            displayWithDelay("With a mere flick of their fingers, the air around them shimmered as a ball of pure, crackling energy", 150);
            displayWithDelay("materialized out of nothing, growing larger with every heartbeat as the very fabric of reality bent to", 150);
            displayWithDelay("their will.", 150);
        } 
        int damage = 10101010;
        displayWithDelay("A small orb of bug appeared, drifting toward the enemy. Upon impact, it expanded and", 150);
        displayWithDelay("swallowed them whole vanishing as if the bug itself had consumed them.", 150);
        displayWithDelay(super.getName() + "deletes the java class.", 150);
        opponent.takeDamage(damage);
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
        System.out.println("1) Basic Attack (Cost: 4 Stamina | Damage: [One-Fourth])"); 
        System.out.println("2) Skill (Cost: 8 Stamina | Damage: [Half])");
        System.out.println("3) Ultimate Skill (Cost: 8 Stamina| Damage: [Whole])");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");

        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }

}

