
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

   

    @Override
    public int getDefence(int damageTaken){
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

  
    

}



