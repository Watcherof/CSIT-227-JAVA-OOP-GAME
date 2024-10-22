public interface ChoicesInterface{
    boolean isValidCharacter(String choice);
    void characterSelectionPVE(String name);
    void characterSelectionPVP1();
    void characterSelectionPVP2();
    void selectCharacters();
    void setChosenCharacter(String chosenCharacter);
    void displayCharacters(String[] characters);
    String[] getChosenCharacters();
    boolean isClassAlreadyChosen(String character);
    boolean isMageCharacter(String character);
    boolean isWarriorCharacter(String character);
    boolean isRangerCharacter(String character);
}