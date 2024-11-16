
public class ShadowStrider extends Characters{

    public ShadowStrider() {
        super("Shadow Strider", 65, 2, "Spirit");
    }

    
    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {     
        if (res < 0) {
        res = 0;
    }
        int damage =getRandomBetween(0,18);// ensures that if damage is negative ex(1 - 10 = -9) then it would just return 0
        if (res < 2) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
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
    public void skill(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 0) {
            res = 0;
        }
    
        int damage = getRandomBetween(18,30) - enemyDefence; // Higher damage range for a ranger/archer type
        if (res < 5) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
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
    public void ult(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(30, 35) - enemyDefence;
        if (res < 8) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
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
        System.out.println("1) Basic Attack (Cost: 2 Spirit | Damage: 0 - 18 )");
        System.out.println("2) Skill (Cost: 5 Spirit | Damage: 18 - 30 )");
        System.out.println("3) Ultimate Skill (Cost: 8 Spirit | Damage: 30 - 35)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");             
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
    
}