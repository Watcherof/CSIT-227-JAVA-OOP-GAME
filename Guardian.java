
public class Guardian extends Character{
    
    public void getStats() {
        Stats stats = new Stats(150, 7);
    }

    @Override
    public int basicAttack() {
        int damage = getRandomBetween(0, 4);
        System.out.println("You used basic attack and dealth " + damage + " damage.");

        return damage;
    }

    @Override
    public int takeDamage(int damage){
        int health = getHealth(damage);
        return health-=damage;
    }

}
