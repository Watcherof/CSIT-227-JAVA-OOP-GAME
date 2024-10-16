public class Character implements CharacterInterface{
    private String[] type;
    @Override
    public void setHealth(int health) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getHealth(int damageTaken) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int damage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setType(String[] type) {
       this.type = type;
    }

    @Override
    public String[] getType() {
       return type;
    }

    @Override
    public void setDefence(int defence) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDefence(int damageTaken) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void basicAttack(String type, int roll) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void skill(String type, int roll) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void switchCharacter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}