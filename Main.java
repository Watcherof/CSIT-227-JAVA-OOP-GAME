
public class Main {
    public static void main(String[] args) throws Exception {
        Story s1 = new Story();
        String mc = "okarun";
        String warrior = "guardian";
        String ranger = "arcane musketeer";
        String mage = "Ember withch";
        String kingdom = "CAMELOt";
        System.out.println("Echoes of War: The Guardian's Path");
        // if skips then go to method that lets you chooses the char and the kingdom
        Thread.sleep(1000);
        s1.tellStoryIntro(mc);
        Thread.sleep(1000);
        // dre na part naay choosing method before mo continue and story
        //s1.chooseKingdom(etc,etc,etc)
        s1.tellStoryKingdom(kingdom,mc,warrior,ranger,mage);
        Thread.sleep(1000);
        s1.tellStoryEnd(mc);

        // TOTAL STORY TIME FROM START TO FINISH IS 5:37 minutes 
        // I change lang ni nato ang delay time kung maka finalize nata sa tanan
    }
}
