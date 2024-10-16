public interface CharacterInterface{
    public void setHealth();
    public int getHealth(int damageTaken);
    public void damage();
    public int defence(int damageTaken);
    public void basicAttack(String type, int roll);
    public void skill(String type, int roll);
    public void ult();
    public void switchCharacter();
}