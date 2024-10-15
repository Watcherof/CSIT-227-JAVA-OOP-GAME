public interface Choose{
    boolean isValidCharacter(String choice);
    public void characterSelection();
    public void selectCharacters();
    boolean isClassAlreadyChosen(String character);
    boolean isMageCharacter(String character);
    boolean isWarriorCharacter(String character);
    boolean isRangerCharacter(String character);
}