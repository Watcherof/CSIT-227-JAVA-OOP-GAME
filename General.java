
public class General extends Characters{

    public General(){
        super("General",100,7,"Stamina");
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {        
            if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(0, 13);
        if (res < 2) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 2;
            displayWithDelay(super.getName()+ " charges towards the enemies with a swift basic attack!", 150);
            displayWithDelay("They hit the enemies, dealing " + damage + " damage.", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " stamina left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " stamina left.", 150);
            }
            
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void skill( int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = getRandomBetween(13, 25) - enemyDefence;
        if (res < 5) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 5;
            displayWithDelay(super.getName() + " focuses intensely, channeling a devastating skill!", 150);
            displayWithDelay("Critical damage is inflicted upon the enemies dealing " + damage + " damage!", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " stamina left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " stamina left.", 150);
            }
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void ult( int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = getRandomBetween(25,30) - enemyDefence;
        if (res < 8) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
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
        System.out.println("1) Basic Attack (Cost: 2 Stamina | Raw Damage: 0 - 13)");
        System.out.println("2) Skill (Cost: 5 Stamina | Raw Damage: 13 - 25)");
        System.out.println("3) Ultimate Skill (Cost: 8 Stamina | Raw Damage: 25 - 30)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");

        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
 

 
    
}