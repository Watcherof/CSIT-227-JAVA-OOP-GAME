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
    public int basicAttack(String chars, int res) {
       return 0;
    }

    @Override
    public int skill(String chars, int res) {
      // generate rng 
      // return dmg
      return 0;
    }

    @Override
    public int ult(String chars,int res) {
        return 0;
    }

    @Override
    public int switchCharacter(String chars,int roll) {
        return 0;
    }

    @Override
    public int takeDamage(int damage) {
       return 0;
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

    

    @Override
    public void displayWithDelay(String text, int delayInMillis) {
      String[] words = text.split(" ");  // Split text into words
      for (String word : words) {
          System.out.print(word + " ");   // Print each word followed by a space
          try {
              Thread.sleep(delayInMillis); // Delay between each word
          } catch (InterruptedException ex) {
              Thread.currentThread().interrupt(); 
          }
      }
      System.out.println(); 
  }

    @Override
    public void choices(String chars, int res,int damage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}