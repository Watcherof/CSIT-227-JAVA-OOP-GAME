public class Guardian extends Character{
    private int health = 150;
    private int defence = 10;
    private String[] type;
    @Override
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public int getHealth(int damageTaken) {
        return health;
    }

    @Override
    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public int getDefence(int damageTaken) {
        return defence;
    }

}