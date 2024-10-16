public interface CharacterInterface{
    public void setHealth(int health);
    public int getHealth(int damageTaken);
    public int numberOfRolls(int roll);
    public void setType(String type);
    public String getType();
    public void setDefence(int defence);
    public int getDefence(int damageTaken);
    public int basicAttack(int roll);
    public int skill(int roll);
    public int ult(int roll);
    public int switchCharacter(int roll);
}