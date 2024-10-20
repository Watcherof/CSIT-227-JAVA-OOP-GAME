public interface StoryInterface {
    void tellStoryIntro(String text);
    void tellStoryKingdom(String kingdom,String name,String warrior,String ranger,String mage);
    void tellStoryEnd(String name);
    void displayWithDelay(String name,int mili);
    void pause(int milli);
    void tellCharLoreAttack();
    void tellCharLoreSupport();

}
