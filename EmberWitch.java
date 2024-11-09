import java.util.Random;
public class EmberWitch extends Characters{

    public EmberWitch() {
        super("Ember Witch", 75, 5, "Mana");
    }

    @Override
    public void basicAttack(int res, Characters opponent,int gameMode) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(0, 10); // Higher range for magic damage
        if (res < 2) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
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
    public void skill(int res, Characters opponent,int gameMode) {
        int damage = getRandomBetween(10, 20);
        if (res < 0) {
            res = 0;
        }
        if (res < 5) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
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
    public void ult(int res, Characters opponent,int gameMode) {
        int damage = getRandomBetween(20, 30);
        if (res < 0) {
            res = 0;
        }
        if (res < 8) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
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
        System.out.println("1) Basic Attack (Cost: 2 Mana | Damage: 0 - 10)");
        System.out.println("2) Skill (Cost: 5 Mana | Damage: 10 - 20)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana | Damage 20 - 30)");
        System.out.println("4) Switch Character");
        System.out.println("5) Show All Character Statuses");
        System.out.println("6) End Turn");
        
        if(gameMode == 1){
            System.out.print("\nYour Choice: ");
        }
    }
}