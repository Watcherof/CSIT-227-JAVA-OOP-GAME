public class General extends Character {
    private int health = 100;
    private int defence = 7;

    @Override
    public void setHealth(int health){
        this.health = health;
    }


    @Override
    public void setDefence(int defence){
        this.defence = defence;
    }
}
