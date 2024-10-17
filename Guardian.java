import java.util.Random;

public class Guardian implements Skills {
    
    public void getStats() {
        Stats stats = new Stats(150, 7);
    }

    @Override
    public int basicAtk() {
        int damage = getRandomBetween(0, 4);
        System.out.println("You used basic attack and dealth " + damage + " damage.");

        return damage;
    }

    private int getRandomBetween(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min should be less than or equal to Max");
        }
        Random random = new Random();
        // Generate random number between min (inclusive) and max (inclusive)
        return random.nextInt((max - min) + 1) + min;
    }
}
