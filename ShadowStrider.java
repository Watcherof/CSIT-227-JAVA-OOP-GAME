
public class ShadowStrider extends Character {
    private int health = 65;
    private int defence = 2;
    private int roll;
    private String type = "Spirit";

    @Override
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public int getHealth(){
        return health;
    }

    @Override
    public void setDefence(int defence){
        this.defence = defence;
    }
    @Override
    public int getDefence(){
        return defence;
    }

    @Override
    public void setRolls(int roll){
        this.roll = roll;
    }

    @Override
    public int getRolls(){
        return roll;
    }
    
    @Override
    public void setType(String type) {
      this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int takeDamage(int damage){
        return health-=damage;
    }

    @Override
    public int basicAttack(String chars, int res) {
        if (res < 0) {
            res = 0;
        }
        int damage = getRandomBetween(5, 20); // Higher damage range for a ranger/archer type
        if (res < 2) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");

        } else {
            res -= 2;
            displayWithDelay(chars + " swiftly draws their bow and aims for a precise shot!", 150);
            displayWithDelay("They unleash the arrow, dealing " + damage + " damage to the enemies.", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
    
        return damage; // Return the damage dealt
    }
    



    @Override
    //TODO IMPLEMENT AOE EFFECTs
    public int skill(String chars, int res) {
        int damage = getRandomBetween(15, 25); //
        
    
        if (res < 5) {
            System.out.println("Insufficient Spirit or Energy! Please Switch Character or END TURN!");
          
        } else {
            res -= 5;
    
            // Display the AoE attack messages
            displayWithDelay(chars + " unleashes a flurry of arrows, striking multiple enemies!", 150);
            displayWithDelay("Each enemy takes " + damage + " damage from the barrage!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
    
        return damage;
    }
    


    @Override
    public int ult(String chars, int res) {
        int damage = getRandomBetween(20, 35);
    
        if (res < 8) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return 0; 
        } else {
            res -= 8;
    
        
            displayWithDelay(chars + " unsheathes their dual swords, preparing for a powerful strike!", 150);
            displayWithDelay("With a swift motion, they unleash their ultimate technique, dealing " + damage + " damage to a single target!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
    
        return damage; 
    }
    

    @Override
    public int switchCharacter(String chars,int res){
        if (res < 1) {
            displayWithDelay("Insufficient Spirit or Energy to switch! Please END TURN!", 150);
            return 0;
        } else {
            res -=1;
            displayWithDelay(chars + " calls for reinforcements! A new character is ready to fight!", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        return 0;
    }

    @Override
    public void choices(String chars,  int res,int damage){
        System.out.println("\nYour current character: " + chars + " (Health: " + health + " | Defence: " + defence + " | " + type + ": " + res + ")");
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Spirits or energy)");
        System.out.println("2) Skill (Cost: 5 Spirits or energy");
        System.out.println("3) Ultimate Skill (Cost: 8 spirits or energy)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll(For demonstration)");
        System.out.println("6) End Turn");
        System.out.print("\nYour Choice: ");
        
    }
}
