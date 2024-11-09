import java.util.Random;

public class ShadowStrider extends Characters{

    public ShadowStrider() {
        super("Shadow Strider", 65, 2, "Spirit");
    }

    
    @Override
    public void basicAttack(int res, Characters opponent,int gameMode) {     
        if (res < 0) {
        res = 0;
    }
        int damage = getRandomBetween(5, 15); // Higher damage range for a ranger/archer type
        if (res < 2) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -=2;
            displayWithDelay(super.getName() + " swiftly draws their bow and aims for a precise shot!", 150);
            displayWithDelay("They unleash the arrow, dealing " + damage + " damage to the enemies.", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
            
        }
        opponent.takeDamage(damage);
    }


    @Override
    public void skill(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
    
        int damage = getRandomBetween(15, 25); // Higher damage range for a ranger/archer type
        if (res < 5) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 5;
            displayWithDelay(super.getName() + " readies their bow, swiftly nocking multiple arrows at once!", 150);
            displayWithDelay("They release a flurry of arrows, each one striking enemies across the battlefield!", 150);
            displayWithDelay("A rain of arrows falls upon the enemies, dealing " + damage + " damage to each of them.", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
        }
        opponent.takeDamage(damage);
    }
    

    @Override
    public void ult(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(30, 35);
        if (res < 8) {
            System.out.println("Insufficient Spirit or Energy! Please switch character or END TURN!");
            return;
        } else {
            res -=8;
            displayWithDelay(super.getName() + " harnesses the power of the storm, nocking arrows imbued with fury!", 150);
            displayWithDelay("A barrage of arrows rains down, each striking true and dealing " + damage + " damage to all enemies!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " spirit left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " spirit left.", 150);
            }
        }
        opponent.takeDamage(damage); // Assuming opponent represents all enemies for simplicity
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
        System.out.println("1) Basic Attack (Cost: 2 Spirit | Damage: 5 - 15 )");
        System.out.println("2) Skill (Cost: 5 Spirit | Damage: 15 - 25 )");
        System.out.println("3) Ultimate Skill (Cost: 8 Spirit | Damage: 30 - 35)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");             
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
    
}