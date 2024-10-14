public class Story implements Stories {
    // this lets you input a string of text and splits text into words and adds delay in MilliSeconds
    @Override
    public void displayWithDelay(String text, int delayInMillis) {
        String[] words = text.split(" ");  // Split text into words
        for (String word : words) {
            System.out.print(word + " ");   // Print each word followed by a space
            try {
                Thread.sleep(delayInMillis); // Delay between each word
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); 
            }
        }
        System.out.println(); 
    }

    // New method to handle the pause
    @Override
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void tellStoryIntro(String name) {
        // Intro
        displayWithDelay("One day in Cebu, a game developer had not slept or eaten for three days", 250);
        displayWithDelay("because he was busy coding a game that was set to release soon.", 250);
        pause(1000); // Additional pause between dialogues

        displayWithDelay("He was responsible for finalizing the game before handing it over to the QA tester,", 250);
        displayWithDelay("ensuring there would be fewer bugs on launch day.", 250);
        pause(1000);

        displayWithDelay("But while coding, exhaustion overcame him, and he suddenly passed out.", 250);
        displayWithDelay("When he woke up, he found himself on a hill overlooking two massive armies locked in battle.", 250);
        pause(1000);

        // Character dialogue
        displayWithDelay(name + ": Where am I?", 300); // Faster delay
        pause(500);

        displayWithDelay("Mysterious Creature: Hello there, " + name + ".", 300);
        displayWithDelay("I am a guardian of this world, and I have summoned you here to help us.", 300);
        pause(500);

        displayWithDelay(name + ": What are you?", 300);
        displayWithDelay("Why are they fighting over there? Take me back!", 300);
        pause(500);

        displayWithDelay("Mysterious Creature: Calm down, " + name + ".", 300);
        displayWithDelay("I will explain the situation before answering your questions, so listen carefully.", 300);
        pause(1000);

        ///////////////////// WORLD SETTING /////////////
        displayWithDelay("Thousands of years ago, when the world was fractured and untamed,", 150);
        displayWithDelay("wars raged across every corner of the land.", 150);
        pause(300);

        displayWithDelay("Kingdoms rose and fell under the rule of brutal warlords,", 150);
        displayWithDelay("and the earth was soaked in the blood of countless battles.", 150);
        displayWithDelay("It was a time when savage rulers held dominion over their realms,", 150);
        displayWithDelay("caring little for unity or peace.", 150);
        pause(300);

        displayWithDelay("But amidst this chaos, two legendary figures emerged,", 150);
        displayWithDelay("men of great power and vision, destined to alter the course of history.", 150);
        displayWithDelay("They hailed from opposite ends of the known world,", 150);
        displayWithDelay("yet their fates would intertwine to shape a new era.", 150);
        pause(300);

        displayWithDelay("From the west came Arthur, known as 'King of Knights.'", 150);
        displayWithDelay("He rose in the war-torn lands of Albion, leading his people", 150);
        displayWithDelay("to repel the marauding barbarians that plagued the western kingdoms.", 150);
        pause(300);

        displayWithDelay("Under his leadership, the mighty kingdom of Camelot was founded,", 150);
        displayWithDelay("a bastion of chivalry and order amidst the darkness.", 150);
        displayWithDelay("Arthur was not just a king but a symbol,", 150);
        displayWithDelay("a leader destined to guide his people toward peace,", 150);
        displayWithDelay("wielding the legendary sword Excalibur to unite the western tribes.", 150);
        pause(300);

        displayWithDelay("In the far east, the 'Old Man of the Mountain' Ziusudra ruled with wisdom and strength.", 150);
        displayWithDelay("He led his people against the vicious pirate fleets that terrorized the coastal lands,", 150);
        displayWithDelay("creating the indomitable kingdom of Asura.", 150);
        pause(300);

        displayWithDelay("His people revered him as a sage-warrior,", 150);
        displayWithDelay("a ruler who balanced martial prowess with deep knowledge.", 150);
        displayWithDelay("Under Ziusudra’s guidance, Asura became a prosperous land,", 150);
        displayWithDelay("renowned for its disciplined armies and enlightened philosophy.", 150);
        pause(300);

        displayWithDelay("Though separated by vast distances and different cultures,", 150);
        displayWithDelay("both Arthur and Ziusudra shared a vision of peace and stability.", 150);
        displayWithDelay("They understood that the unrelenting conflict between their lands", 150);
        displayWithDelay("could only be resolved through unity.", 150);
        pause(300);

        displayWithDelay("Thus, the two kings formed an alliance,", 150);
        displayWithDelay("joining their forces in a historic campaign to drive out the enemies from their regions.", 150);
        displayWithDelay("Together, they forged a monumental empire,", 150);
        displayWithDelay("uniting the western and eastern lands under a single banner—the great empire of Avalon.", 150);
        pause(300);

        displayWithDelay("In their joint reign, Arthur and Ziusudra established a diarchy,", 150);
        displayWithDelay("ruling as equal sovereigns.", 150);
        displayWithDelay("Avalon flourished under their combined leadership.", 150);
        pause(300);

        displayWithDelay("The people spoke of a golden age,", 150);
        displayWithDelay("where knights and scholars, warriors and philosophers,", 150);
        displayWithDelay("worked together to build a civilization that surpassed all others.", 150);
        displayWithDelay("The empire stretched from the mountains of the west to the shores of the east,", 150);
        displayWithDelay("and peace reigned for the first time in centuries.", 150);
        pause(300);

        displayWithDelay("However, no kingdom lasts forever.", 150);
        displayWithDelay("When Arthur and Ziusudra passed away, Avalon’s foundation began to crack.", 150);
        displayWithDelay("Without their guiding hands, ambition and greed festered among their successors.", 150);
        pause(300);

        displayWithDelay("The once-unified lands of Avalon splintered,", 150);
        displayWithDelay("as the western kingdom of Camelot and the eastern realm of Asura vied for dominance.", 150);
        displayWithDelay("The harmony that Arthur and Ziusudra had painstakingly built was forgotten,", 150);
        displayWithDelay("and the two great kingdoms plunged into bitter conflict.", 150);
        pause(300);

        displayWithDelay("For thousands of years, Camelot and Asura clashed in an endless struggle for supremacy,", 150);
        displayWithDelay("each claiming the legacy of Avalon while seeking to impose its will on the other.", 150);
        pause(300);

        displayWithDelay("The scars of that ancient diarchy remained etched into the fabric of both nations,", 150);
        displayWithDelay("as neither could fully conquer the other,", 150);
        displayWithDelay("and the dream of a unified world became a distant memory.", 150);
        pause(300);

        //////////////////////////
        // Character Dialogue
        displayWithDelay("Mysterious Creature: And you have been summoned as the Great Chosen One.", 150);
        displayWithDelay("It is your duty to choose which empire to side with in order to end the war.", 150);
        pause(500);

        displayWithDelay(name + ": So, you're saying I am the one who is supposed to end this war?", 150);
        pause(500);

        displayWithDelay("Mysterious Creature: Yes, exactly. That is why you were summoned, O Great One.", 300);
        pause(500);

        displayWithDelay(name + ": But I can’t fight!", 300);
        pause(500);

        displayWithDelay("Mysterious Creature: The kingdoms have gathered their elite warriors,", 300);
        displayWithDelay("ready to engage in the impending battles.", 300);
        displayWithDelay("Your duty is to select a side and lead these champions to triumph.", 300);
        displayWithDelay("However, time is no longer on my side.", 300);
        displayWithDelay("I shall inscribe a symbol upon your arm, a testament to your loyalty and a mark of the trust I place in you.", 300);
        displayWithDelay("With this emblem, I entrust you with the weighty responsibility of guiding our forces to victory.", 300);
        pause(500);

        displayWithDelay(name + ": Wait, I still have more questions!", 300);
        pause(500);

        displayWithDelay("Mysterious Creature: fades away", 300);
        pause(500);
    }


    @Override
    public void tellStoryKingdom(String kingdom, String name, String warrior, String ranger, String mage) {
        displayWithDelay("The main character " + name + " stands before the generals, having chosen a side.", 300);
        displayWithDelay("He explains his purpose to them.", 300);
        pause(500);
    
        displayWithDelay(name + ": I have been sent by a higher being, a mysterious creature,", 300);
        displayWithDelay("to aid in bringing an end to this war.", 300);
        pause(500);
    
        displayWithDelay("General: So, you are here to assist us at the behest of the true beings?", 300);
        pause(500);
    
        displayWithDelay(name + ": Yes, that is the essence of my mission.", 300);
        pause(500);
    
        displayWithDelay("General: How do you intend to prove that you were sent by the higher beings?", 300);
        pause(500);
    
        displayWithDelay("You reveal the mark engraved on your arm.", 300);
        pause(500);
    
        displayWithDelay("General: It seems the prophecy was true. You are the chosen one.", 300);
        displayWithDelay("Follow me; I will escort you to the king.", 300);
        pause(500);
    
        displayWithDelay(warrior + " (Warrior class): \"O great chosen one, I, " + warrior + ",", 300);
        displayWithDelay("from the " + kingdom + ", pledge my unwavering loyalty to you.", 300);
        displayWithDelay("With my sword and shield, I shall fight fiercely by your side until victory is ours in this war.\"", 300);
        pause(500);
    
        displayWithDelay(ranger + " (Ranger class): \"O great chosen one, I, " + ranger + ",", 300);
        displayWithDelay("from the " + kingdom + ", vow to be your eyes and ears in the wild.", 300);
        displayWithDelay("My arrows shall strike true, and no enemy will escape my keen sight.", 300);
        displayWithDelay("Together, we will move swiftly and silently to bring triumph in this battle.\"", 300);
        pause(500);
    
        displayWithDelay(mage + " (Mage class): \"O great chosen one, I, " + mage + ",", 300);
        displayWithDelay("from the " + kingdom + ", offer you the power of the ancient elements.", 300);
        displayWithDelay("With the forces of fire, ice, and lightning at my command,", 300);
        displayWithDelay("I will shatter the enemies that stand in our way.", 300);
        displayWithDelay("Let magic guide our path to victory.\"", 300);
        pause(500);
    
        displayWithDelay("The King steps forward, his demeanor commanding yet regal.", 300);
        pause(500);
    
        // Adjusting based on chosen kingdom
        displayWithDelay("King of " + kingdom + ": You claim to be a harbinger of hope in these dark times.", 300);
        displayWithDelay("I shall place my trust in you.", 300);
        displayWithDelay("I will entrust you with my finest warriors; they will be under your command", 300);
        displayWithDelay("as we strive to secure victory in this conflict.", 300);
        pause(500);
    
        displayWithDelay("The King gestures to the warriors, ready and eager to fight.", 300);
        pause(500);
    
        displayWithDelay("King of " + kingdom + ": Now go, and lead us to triumph in this war.", 300);
        pause(500);
    
        displayWithDelay("The MC departs, accompanied by the warriors he has selected,", 300);
        displayWithDelay("determined to face the challenges that lie ahead.", 300);
        pause(500);
    }
    


    @Override 
    public void tellStoryEnd(String name) {
        displayWithDelay(name + ": Finally, it’s over! We did it, guys!", 300);
        pause(500);
    
        displayWithDelay("Mysterious Creature: Well done, " + name + ".", 300);
        displayWithDelay("You have done well for the task and hardships that I have given you.", 300);
        displayWithDelay("With this, I can now safely send you back to your world.", 300);
        pause(500);
    
        displayWithDelay(name + ": Thank you! I didn't know if I could make it through,", 300);
        displayWithDelay("but we pushed through together. I am ready to go home now!", 300);
        pause(500);
    
        displayWithDelay("Mysterious Creature casts a spell that sends the MC back home.", 300);
        displayWithDelay("MC wakes up and looks around the house.", 300);
        pause(500);
    
        displayWithDelay(name + ": Man, what a crazy day! But at least I did something valuable from that trip.", 300);
        pause(500);
    
        displayWithDelay("QA Tester calls for the code.", 300);
        pause(500);
    
        displayWithDelay(name + ": Oh no, I forgot I still have projects to finish!", 300);
        displayWithDelay("I better hurry up, or I might get fired!", 300);
        pause(500);
    }
    

       /*
        displayWithDelay("",300);
        pause(500);

        displayWithDelay("",150);
        pause(300);
        
        */

    @Override
    public void tellCharLoreAttack() {
       //
    }

    @Override
    public void tellCharLoreSupport() {
        //
    }

    

}
