public interface CharacterInterface{
    public int health(int damageTaken);
    public void damage();
    public int defence(int damageTaken);
    public void basicAttack(String type, int roll);
    public void skill(String type, int roll);
    public void ult();
    public void switchCharacter();
}