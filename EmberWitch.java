

public class EmberWitch extends Character {
    private int health = 75;
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
        int damage = getRandomBetween(0, 15); // Higher range for magic damage
        if (res < 2) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return 0;
        } else {
            displayWithDelay(chars + " conjures a powerful spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        return damage;
    }


    @Override
    public int skill(String chars,int res){
        int damage = getRandomBetween(0, 10);

        if (res < 0) {
            res = 0;
        }
        if (res < 5) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return 0;
        } else {
            displayWithDelay(chars + " conjures a stunning spell and launches it at the enemies!", 150);
            displayWithDelay("The spell strikes the enemies, dealing " + damage + " magic damage.", 150);
            res -= 5;
            // Guaranteed stun
            displayWithDelay("The enemies are stunned and unable to move!", 150);
            
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        return damage;
    }


    @Override
    public int ult(String chars, int res) {
        int damage = getRandomBetween(15, 25);
        if (res < 0) {
            res = 0;
        }
        if (res < 8) {
            System.out.println("Insufficient Mana! Please Switch Character or END TURN!");
            return 0;
        } else {
            displayWithDelay(chars + " channels a powerful surge of magic, unleashing it in a massive explosion that engulfs all enemies!", 150);
            displayWithDelay("The spell hits all enemies, dealing " + damage + " magic damage to each.", 150);
            res -= 8;
            // Guaranteed stun
            displayWithDelay("The enemies are caught in the blast and are stunned, unable to retaliate!", 150);
            
            displayWithDelay("You now have " + res + " mana left.", 150);
        }
        return damage;
    }


    @Override
    public int switchCharacter(String chars,int res){
        if (res < 1) {
            displayWithDelay("Insufficient Mana or Energy to switch! Please END TURN!", 150);
        } else {
            res -=1;
            displayWithDelay(chars + " calls for reinforcements! A new character is ready to fight!", 150);
            displayWithDelay("You now have " + res + " mana/energy left.", 150);
        }
        return 0;
    }
    
    @Override
    public void choices(String chars,  int res,int damage){
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
