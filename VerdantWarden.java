import java.util.*;
public class VerdantWarden extends Characters {
    public VerdantWarden() {
        super("Verdant Warden", 85, 3, "Spirit");
    }

    @Override
    // TODO 
    // ADD HEALING MECHANICS ON THIS HERO
    public void basicAttack(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(0, 7); // Adjusted damage range for a support type with an attack
        if (res < 2) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");
            return; // No damage if not enough resources
        } else {
            // Display the attack message
            res -= 2;
            displayWithDelay(super.getName() + " calls upon nature's strength, drawing their bow to unleash a vibrant arrow!", 150);
            displayWithDelay("The arrow flies true, dealing " + damage + " damage to the enemies.", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
            
        }
        opponent.takeDamage(damage);
    }

    @Override
    // TODO
    // HEAL MECHANICS 
    public void skill(int res, Characters opponent,int gameMode) {
        int damage = 15; // Fixed damage for enemies
        int healAmount = 10; // Fixed healing for allies
    
        if (res < 5) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 5; // Cost for the skill
    
            // Display the AoE attack and healing messages
            displayWithDelay(super.getName() + " channels nature's energy, unleashing a flurry of arrows!", 150);
            displayWithDelay("Each enemy takes " + damage + " damage from the barrage!", 150);
            displayWithDelay("All allies receive " + healAmount + " health from the soothing energy!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
        }
        opponent.takeDamage(damage);
    }

    @Override
    // TODO 
    // IMPLEMENT HEALING SHIT HERE TY
    // attack all && heal all
    public void ult(int res, Characters opponent,int gameMode) {
        int damage = getRandomBetween(10,20); // Damage range for the ultimate skill
        int healAmount = 20; // Fixed healing for allies
        int shieldAmount = 1; // Fixed shield amount

        if (res < 8) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            // Display the ultimate attack and healing messages
            res -= 8;
            displayWithDelay(super.getName() + " calls upon the power of nature, preparing their ultimate technique!", 150);
            displayWithDelay("They unleash a devastating strike, dealing " + damage + " damage to a single target!", 150);
            displayWithDelay("In addition, all allies receive " + healAmount + " health and gain a shield of " + shieldAmount + " points!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
        }  
        opponent.takeDamage(damage);
    }


    @Override
     public int getRandomBetween(int min, int max) {
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
        System.out.println("1) Basic Attack (Cost: 2 Spirit )");
        System.out.println("2) Skill (Cost: 5 Spirit)");
        System.out.println("3) Ultimate Skill (Cost: 8 Spirit)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll (For demonstration)");
        System.out.println("6) End Turn");       
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }

    }
    
}
