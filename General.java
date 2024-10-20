
public class General extends Character {
    private int health = 100;
    private int defence = 7;
    private int roll;
    private String type = "Stamina";

    public void getStats() {
        Stats stats = new Stats(100, 7);
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
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public int getHealth(){
        return health;
    }


    // TODO skills ult chare 
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
    public int basicAttack(String chars,int res){
        if(res < 0){
            res = 0;
        }
        int damage = getRandomBetween(0, 4);
        if (res < 2) {
            System.out.println("Insufficient Stamina or Energy! Please Switch Character or END TURN!");
            return 0;
        } else {
            res -=2;
            displayWithDelay(chars + " charges towards the enemies with a swift basic attack!", 150);
            displayWithDelay("They hit the enemies, dealing " + damage + " damage.", 150);
            displayWithDelay("You now have " + res + " stamina/energy left.", 150);
        }
        return damage;
    }



    @Override
    public int skill(String chars, int res) {
        int damage = getRandomBetween(11, 15);
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
            return 0;
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



