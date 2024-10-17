public interface ChoicesInterface{
    boolean isValidCharacter(String choice);
    void characterSelection();
    void selectCharacters();
    void setChosenCharacter(String chosenCharacter);
    void displayCharacters(String[] characters);
    String[] getChosenCharacters();
    boolean isClassAlreadyChosen(String character);
    boolean isMageCharacter(String character);
    boolean isWarriorCharacter(String character);
    boolean isRangerCharacter(String character);
}