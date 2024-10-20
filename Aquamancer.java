
public class Aquamancer extends Character {
    private int health = 80;
    private int defence = 5;
    private int roll;
    private String type = "Mana";

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
        if (res < 2) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return 0; // No damage if not enough mana
        }
    
        res -= 2; // Cost for the basic attack
        int damage = getRandomBetween(0, 5); // Damage dealt by the attack
    
        // Display the attack message
        displayWithDelay(chars + " conjures a concentrated energy blast and launches it at the enemies!", 150);
        displayWithDelay("The blast strikes the enemies, dealing " + damage + " magic damage.", 150);
        displayWithDelay("You now have " + res + " mana left.", 150);
    
        return damage; // Return the damage dealt
    }
    
    

    @Override
    public int skill(String chars,int res){
        if (res < 0) {
            res = 0;
        }
    
        if (res < 5) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return 0; // No damage if not enough mana
        }
    
        res -= 5; // Cost for the basic attack
        int damage = 1; // Damage dealt by the attack
        int shieldAmount = getRandomBetween(1, 3); // Amount of shield provided to an ally
    
        // Display the attack and support messages
        displayWithDelay(chars + " weaves a magical spell and launches it at the enemies!", 150);
        displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
        displayWithDelay("In addition, " + chars + " grants a protective shield of " + shieldAmount + " points to an ally!", 150);
        displayWithDelay("You now have " + res + " mana left.", 150);
    
        // Implement additional logic to apply the shieldAmount to an ally's shield here
    
        return damage; // Return the damage dealt
    }


    @Override
    // TODO IMPLEMENT HEALING SYSTEM 
    public int ult(String chars, int res) {

        if (res < 8) { 
            displayWithDelay("Insufficient Mana or Energy to perform the AoE Heal! Please END TURN!", 150);
            return 0;
        }
    
        res -= 8;
        int healAmount = getRandomBetween(3, 6); 
    
        // Display the AoE heal message
        displayWithDelay(chars + " channels their power and releases a wave of healing energy!", 150);
        displayWithDelay("All allies are healed for " + healAmount + " health points!", 150);
        displayWithDelay("You now have " + res + " mana/energy left.", 150);
    
        return 0; 
    }



    
    
    @Override
    public void choices(String chars,  int res){
        System.out.println("\nYour current character: " + chars + " (Health: " + health + " | Defence: " + defence + " | " + type + ": " + res + ")");
        System.out.println("\nChoose Attack: ");
        System.out.println("1) Basic Attack (Cost: 2 Mana or Energy)");
        System.out.println("2) Skill (Cost: 5 Mana or Energy)");
        System.out.println("3) Ultimate Skill (Cost: 8 Mana or Energy)");
        System.out.println("4) Switch Character");
        System.out.println("5) Reroll(For demonstration)");
        System.out.println("6) End Turn");
        System.out.print("\nYour Choice: ");
    }
        
    
    
}
