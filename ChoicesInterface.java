public interface ChoicesInterface {
    // Validate if the chosen character is valid
    boolean isValidCharacter(String choice);
    void characterSelectionPVE(String name);
    void characterSelectionPVP1();
    void characterSelectionPVP2();
    Characters[] selectCharacters();
    void setChosenCharacter(String chosenCharacter);
    String[] getChosenCharacters();
    boolean isClassAlreadyChosen(String character);
    boolean isMageCharacter(String character);
    boolean isWarriorCharacter(String character);
    boolean isRangerCharacter(String character);
    void displayCharacters(String[] characters,int gamemode);
}
