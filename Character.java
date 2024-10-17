public class Character implements CharacterInterface{
    private String type;

    @Override
    public void setHealth(int health) {
      //
    }

    @Override
    public int getHealth(int damageTaken) {
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
    public int getDefence(int damageTaken) {
      return 0;
    }

    @Override
    public int basicAttack(int roll) {
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

    
}