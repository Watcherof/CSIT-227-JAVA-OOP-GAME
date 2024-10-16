public class Guardian extends Character{
    private int health = 150;
    private int defence = 10;

    @Override
    public void setHealth(int health){
        this.health = health;
    }


    @Override
    public void setDefence(int defence){
        this.defence = defence;
    }

    
}