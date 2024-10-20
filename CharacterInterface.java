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
    public int basicAttack(String chars, int res);
    public int skill(String chars,int res);
    public int ult(String chars,int res);
    public int switchCharacter(String chars,int res);
    public int getRandomBetween(int min, int max);
    public void choices(String chars, int res);
    void displayWithDelay(String name,int mili);
}