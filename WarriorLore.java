 public class WarriorLore extends Story{
   @Override
   // GUARDIANS
   public void tellCharLoreAttack(){
        displayWithDelay("HELLO WORLD",250);
        pause(1000);
   }

   @Override
   //GENERAL
   public void tellCharLoreSupport(){
        displayWithDelay("abcd", 100);
        pause(100);
   }
 }  