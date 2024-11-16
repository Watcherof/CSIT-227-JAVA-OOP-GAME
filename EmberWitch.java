public class EmberWitch extends Characters{

    public EmberWitch() {
        super("Ember Witch", 75, 5, "Mana");
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode,int enemyDefence) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(0, 15); // ensures that if damage is negative ex(1 - 10 = -9) then it would just return 0
        if (res < 2) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 2;
            displayWithDelay(super.getName() + " conjures a powerful spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " mana left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " mana left.", 150);
            }
            
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void skill(int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = getRandomBetween(15,25) - enemyDefence;
        if (res < 0) {
            res = 0;
        }
        if (res < 5) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 5;
            displayWithDelay(super.getName() + " conjures a stunning spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);            
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " mana left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " mana left.", 150);
            }
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void ult(int res, Characters opponent,int gameMode,int enemyDefence) {
        int damage = getRandomBetween(25, 35) - enemyDefence;
        if (res < 0) {
            res = 0;
        }
        if (res < 8) {
            displayWithDelay("Insufficient Stamina or Energy! Please Switch Character or END TURN!", 150);
            return;
        } else {
            res -= 8;
            displayWithDelay(super.getName() + " channels a powerful surge of magic, unleashing it in a massive explosion that engulfs all enemies!", 150);
            displayWithDelay("The spell hits all enemies, dealing " + damage + " magic damage to each.", 150);            
            if(gameMode == 1){
                displayWithDelay("You now have " + res + " mana left.", 150);
            }else{
                displayWithDelay("Computer has " + res + " mana left.", 150);
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
        System.out.println("1) Basic Attack (Cost: 2 Mana | Damage: 0 - 15)");
        System.out.println("2) Skill (Cost: 5 Mana | Damage: 15 - 25)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana | Damage 25 - 35)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");
        
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
}