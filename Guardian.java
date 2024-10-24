
public class Guardian extends Characters{

    public Guardian(int res) {
        super("Guardian", 150, 10, "Stamina", res);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void basicAttack(int res, Characters opponent) {
        int damage = getRandomBetween(1, 4); // Damage dealt by the basic attack
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 2; // Cost for the basic attack
           
    
            // Display the supportive action message
            displayWithDelay(super.getName() + " swings their weapon to strike the enemy while shielding allies!", 150);
            displayWithDelay("They deal " + damage + " damage to the enemy and provide a protective stance for allies!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        opponent.takeDamage(damage + 4);
    }

    @Override
    // TODO IMPLEMENT SHIDEL SYSTEM
    public void skill(int res, Characters opponent) {
        int damage = 2;
        if (res < 3) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
                res -= 3;
            displayWithDelay(super.getName() + " focuses intensely, channeling a devastating skill!", 150);
            displayWithDelay("Critical damage is inflicted upon the enemies dealing " + damage + " damage!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void ult(int res, Characters opponent) {
        int damage = getRandomBetween(16, 25);
        if (res < 8) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return;
        } else {
            res -= 8;
            displayWithDelay(super.getName() + "unsheathes dual swords, unleashing their ultimate technique!", 150);
            displayWithDelay("The skill's damage is doubled as the dual swords tear through the battlefield, dealing " + damage + " damage!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        opponent.takeDamage(damage);
    }

    @Override
    public void switchCharacter(int res) {
        if (res < 1) {
            displayWithDelay("Insufficient Stamina or Energy to switch! Please END TURN!", 150);
        } else {
            res -=1;
            displayWithDelay(super.getName() + " calls for reinforcements! A new character is ready to fight!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
    }
   

    @Override
    public int getRandomBetween(int min, int max) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

        @Override
        public void choices( int res,int damage,int h) {
        System.out.println("\nYour current character: " + super.getName() + " (Health: " + h + " | Defence: " + defence + " | " + type + ": " + this.res + ")");
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Stamina)");
        System.out.println("2) Skill (Cost: 3 Stamina)");
        System.out.println("3) Ultimate Skill (Cost: 5 Stamina)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll (For demonstration)");
        System.out.println("6) End Turn");
        System.out.print("\nYour Choice: ");
        }

}
