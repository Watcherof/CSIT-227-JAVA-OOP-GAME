public interface CharacterInterface{
    public void setHealth(int health);
    public int getHealth(int damageTaken);
    public int damage();
    public void setType(String[] type);
    public String[] getType();
    public void setDefence(int defence);
    public int getDefence(int damageTaken);
    public void basicAttack(int roll);
    public void skill(int roll);
    public void ult();
    public void switchCharacter();
}