import java.util.Random;
public class EmberWitch extends Characters{

    public EmberWitch(int res) {
        super("Ember Witch", 75, 5, "Mana", res);
    }

    @Override
    public void basicAttack(int res, Characters opponent) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(0, 10); // Higher range for magic damage
        if (res < 2) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return;
        } else {
            displayWithDelay(super.getName() + " conjures a powerful spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void skill(int res, Characters opponent) {
        int damage = getRandomBetween(0, 15);

        if (res < 0) {
            res = 0;
        }
        if (res < 5) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return;
        } else {
            displayWithDelay(super.getName() + " conjures a stunning spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
            res -= 5;
            // Guaranteed stun
            displayWithDelay("The enemies are stunned and unable to move!", 150);
            
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void ult(int res, Characters opponent) {
        int damage = getRandomBetween(15, 25);
        if (res < 0) {
            res = 0;
        }
        if (res < 8) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return;
        } else {
            displayWithDelay(super.getName() + " channels a powerful surge of magic, unleashing it in a massive explosion that engulfs all enemies!", 150);
            displayWithDelay("The spell hits all enemies, dealing " + damage + " magic damage to each.", 150);
            res -= 8;
            // Guaranteed stun
            displayWithDelay("The enemies are caught in the blast and are stunned, unable to retaliate!", 150);
            
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void switchCharacter(int res) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchCharacter'");
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
    public void choices( int res,int damage,int h) {
        System.out.println("\nYour current character: " + super.getName() + " (Health: " + h + " | Defence: " + defence + " | " + type + ": " + res + ")");
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Mana )");
        System.out.println("2) Skill (Cost: 5 Mana)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll (For demonstration)");
        System.out.println("6) End Turn");
        System.out.print("\nYour Choice: ");
    }
}