public class Aquamancer extends Characters {

    public Aquamancer() {
        super("Aquamancer", 80, 5, "Mana");
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        }
        
        int damage = getRandomBetween(0, 4); // ensures that if damage is negative ex(1 - 10 = -9) then it would just return 0
        // Display the attack message
        res -= 2;
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
    public void skill(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 0) {
            res = 0;
        }
    
        if (res < 5) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
        }

        //healAlly() or something
    }

    @Override
    // TODO
    // IMPLEMENT THE AOE ULT which is heal
    public void ult(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 8) { 
            displayWithDelay("Insufficient Mana or Energy to perform the AoE Heal! Please END TURN!", 150);
        }
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
        System.out.println("1) Basic Attack (Cost: 2 Mana | Damage: 0 - 4)");
        System.out.println("2) Skill (Cost: 5 Mana | Heal(Single Ally): 5 - 12)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana| Heal(All ally):10 - 25)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");
        
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
  
    
}
