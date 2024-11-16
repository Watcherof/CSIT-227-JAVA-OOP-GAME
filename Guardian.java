public class Guardian extends Characters{

    public Guardian() {
        super("Guardian", 150, 10, "Stamina");
        //TODO Auto-generated constructor stub
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = getRandomBetween(0, 7);// ensures that if damage is negative ex(1 - 10 = -9) then it would just return 0
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 2; // Cost for the basic attack
            // Display the supportive action message
            displayWithDelay(super.getName() + " swings their weapon to strike the enemy!", 150);
            displayWithDelay("They deal " + damage + " damage to the enemy!", 150);
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
    public void skill(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 5) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
        }
    }

    @Override
    // AOE SHIELD NI 
    public void ult(int res, Characters opponent,int gameMode,int enemyDefence) {
        // int damage = getRandomBetween(16, 25);
        if (res < 8) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
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
        System.out.println("1) Basic Attack (Cost: 2 Stamina | Damage: 0 - 7)");
        System.out.println("2) Skill (Cost: 5 Stamina | Shield(Single Ally): 5 - 15)");
        System.out.println("3) Ultimate Skill (Cost: 8 Stamina | Shield(All Allies): 5 - 10)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");

        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }

}
