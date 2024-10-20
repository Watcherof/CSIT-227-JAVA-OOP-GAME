
public class Guardian extends Character{
    private int health = 150;
    private int defence = 10;
    private String type = "Stamina";
    
    
    public void getStats() {
        Stats stats = new Stats(150, 7);
    }



    @Override
    public int takeDamage(int damage){
        int health = getHealth();
        return health-=damage;
    }



    @Override
    public int basicAttack(String chars, int res) {
        int damage = getRandomBetween(1, 4); // Damage dealt by the basic attack
        if (res < 0) {
            res = 0;
        }
        if (res < 2) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return 0;
        } else {
            res -= 2; // Cost for the basic attack
           
    
            // Display the supportive action message
            displayWithDelay(chars + " swings their weapon to strike the enemy while shielding allies!", 150);
            displayWithDelay("They deal " + damage + " damage to the enemy and provide a protective stance for allies!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        return damage; // Return the damage dealt
    }
    



    @Override
    // TODO implement shield method
    public int skill(String chars, int res) {
        int damage = 2;
        if (res < 3) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return 0;
        } else {
                res -= 3;
            displayWithDelay(chars + " focuses intensely, channeling a devastating skill!", 150);
            displayWithDelay("Critical damage is inflicted upon the enemies dealing " + damage + " damage!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
      return damage;
    }


    @Override
    //TODO SAME WITH THE SKILL IMPLEMENT SHIELD METHOD 
    public int ult(String chars,int res){
        int damage = getRandomBetween(16, 25);
        if (res < 8) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return 0;
        } else {
            res -= 8;
            displayWithDelay(chars + "unsheathes dual swords, unleashing their ultimate technique!", 150);
            displayWithDelay("The skill's damage is doubled as the dual swords tear through the battlefield, dealing " + damage + " damage!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        return damage;
    }

    @Override
    public int switchCharacter(String chars,int res){
        if (res < 1) {
            displayWithDelay("Insufficient Stamina or Energy to switch! Please END TURN!", 150);
        } else {
            res -=1;
            displayWithDelay(chars + " calls for reinforcements! A new character is ready to fight!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        return 0;
    }
    @Override
    public void choices(String chars, int res){
        System.out.println("\nYour current character: " + chars + " (Health: " + health + " | Defence: " + defence + " | " + type + ": " + res + ")");
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Stamina)");
        System.out.println("2) Skill (Cost: 3 Stamina)");
        System.out.println("3) Ultimate Skill (Cost: 5 Stamina)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll(For demonstration)");
        System.out.println("6) End Turn");
        System.out.print("\nYour Choice: ");

    }

    

}
