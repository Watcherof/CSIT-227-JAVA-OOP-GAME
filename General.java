
public class General extends Character {
    private int health = 100;
    private int defence = 7;
    private int roll;
    private String type = "Stamina";

    public void getStats() {
        Stats stats = new Stats(100, 7);
    }


    @Override
    public int basicAttack() {
        int damage = getRandomBetween(0, 4);
        System.out.println("You used basic attack and dealth " + damage + " damage.");

        return damage;
    }

    // TODO skills ult chare 

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

  
    

}



