public class MageLore extends Story{
    @Override
    // Ember witch
    public void tellCharLoreAttack(){
         displayWithDelay("HELLO WORLD",250);
         pause(1000);
    }
 
    @Override
    //Aquamancer
    public void tellCharLoreSupport(){
         displayWithDelay("abcd", 100);
         pause(100);
    }
}