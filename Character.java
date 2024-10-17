import java.util.Random;

public class Character implements CharacterInterface{
    private String type;

    @Override
    public void setHealth(int health) {
      //
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setType(String type) {
      //
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setDefence(int defence) {
      //
    }

    @Override
    public int getDefence() {
      return 0;
    }

    @Override
    public int basicAttack() {
       return 0;
    }

    @Override
    public int skill(int roll) {
      return 0;
    }

    @Override
    public int ult(int roll) {
        return 0;
    }

    @Override
    public int switchCharacter(int roll) {
        return 0;
    }

    @Override
    public int takeDamage(int damage) {
       return damage;
    }

    @Override
    public void setRolls(int roll) {
       //
    }

    @Override
    public int getRolls() {
      return 0;    
    }

    @Override
    public int getRandomBetween(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min should be less than or equal to Max");
        }
        Random random = new Random();
        // Generate random number between min (inclusive) and max (inclusive)
        return random.nextInt((max - min) + 1) + min;
    }
    
}