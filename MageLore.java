public class MageLore extends Story{
    @Override
    // Ember witch
    public void tellCharLoreAttack() {
        displayWithDelay("\nForged in the heart of a dying volcano, the Ember Witches draw their power from the ancient flames of the earth.", 100);
        pause(300);
        
        displayWithDelay("\nTrained in the art of destructive fire magic, they command the fury of molten lava and searing embers,", 100);
        displayWithDelay("unleashing devastating attacks that reduce their enemies to ash.", 100);
        pause(300);

        displayWithDelay("\nThe Ember Witch is known for their relentless power, capable of summoning infernos that consume everything in their path.", 100);
        pause(300);

        displayWithDelay("\nWhile feared for their destructive force, they are driven by a singular purpose:", 100);
        displayWithDelay("to purge the world of darkness through fire,", 100);
        displayWithDelay("believing that only through destruction can true rebirth begin.", 100);
        pause(300);

        displayWithDelay("\nThey move through battlefields like a wildfire,", 100);
        displayWithDelay("leaving nothing but scorched earth in their wake.", 100);
        pause(300);
    }

    @Override
    //Aquamancer
    public void tellCharLoreSupport() {
        displayWithDelay("\nBorn from the ancient waters of the Everspring, the Aquamancers are gifted with the power to control water's healing and protective abilities.", 100);
        pause(300); 

        displayWithDelay("\nTrained in the art of restoration, they are revered as the guardians of balance,", 100);
        displayWithDelay("using their hydro magic to support and safeguard their allies in battle.", 100);
        pause(300);

        displayWithDelay("\nTheir connection to water allows them to summon tides to shield,", 100);
        displayWithDelay("rain to rejuvenate, and mist to obscure.", 100);
        pause(300);

        displayWithDelay("\nWhile they rarely engage in direct combat, Aquamancers are essential to any force,", 100);
        displayWithDelay("as their presence can turn the tide of war,", 100);
        displayWithDelay("ensuring that hope flows even in the darkest times.", 100);
        pause(300);
    }
    
    
}