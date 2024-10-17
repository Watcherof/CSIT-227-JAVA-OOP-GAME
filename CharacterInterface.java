public interface CharacterInterface{
    public void setHealth(int health);
    public int getHealth();
    public void setRolls(int roll);
    public int getRolls();
    public void setType(String type);
    public String getType();
    public void setDefence(int defence);
    public int takeDamage(int damage);
    public int getDefence();
    public int basicAttack();
    public int skill(int roll);
    public int ult(int roll);
    public int switchCharacter(int roll);
    public int getRandomBetween(int min, int max);
}