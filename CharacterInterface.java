public interface CharacterInterface{
    public void setHealth(int health);
    public int getHealth(int damageTaken);
    public void setRolls(int roll);
    public int getRolls();
    public void setType(String type);
    public String getType();
    public void setDefence(int defence);
    public int takeDamage(int damage);
    public int getDefence(int damageTaken);
    public int basicAttack();
    public int skill(int roll);
    public int ult(int roll);
    public int switchCharacter(int roll);
}