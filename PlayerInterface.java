public interface PlayerInterface{
    String getName();
    Characters getCurrentCharacter();
    Characters[] getAllCharacters();
    Characters[] getChosenChar();
    boolean switchCharacter(int index);
    boolean hasAliveCharacters();
    void printAllCharacterStatus(int[] res);
    boolean switchToNextAliveCharacter();
    int[] generateNumbers();
    int[] wish();
    int[] wishAI();
    void combat(Player current, Player opponent);
    void computerCombat(Player current, Player opponent);
    void skillSpecialCases(int i,  int[] res, int choice, Characters opponent,Characters current,int gameMode);
} 