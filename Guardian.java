
import java.util.Random;

public class Guardian extends Character{
    private int health = 150;
    private int defence = 10;
    private int roll;
    private String[] type;

    @Override
    public void setHealth(int health){
        this. health = health;
    }

    @Override
    public int getHealth(int damageTaken){
        return health;
    }

    @Override
    public void setDefence(int defence){
        this.defence = defence;
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

    public int takeDamage(int damage){
        return 0;
    }

    public int basicAttack() {
        Random r = new Random();
        return r.nextInt(5); 
    }
    


}