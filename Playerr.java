
public class Playerr  {
    // add things here imagine player 2 ni or 1
    private Combat combat;
    private Choices c1 = new Choices(1);
    private String[] chosenCharacters = c1.getChosenCharacters();

    public Playerr(int player) {
        
    }

    

    public void chooseCharacters(Choices choices) {
        choices.selectCharacters();
        chosenCharacters = choices.getChosenCharacters();
    }

    public String[] getChosenCharacters() {
        return chosenCharacters;
    }

}
