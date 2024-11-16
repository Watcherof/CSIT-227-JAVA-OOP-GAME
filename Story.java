public class Story implements StoryInterface {
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
    //test 
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
        displayWithDelay("\nOne day in Cebu, a game developer had not slept or eaten for three days", 150);
        displayWithDelay("because he was busy coding a game that was set to release soon.", 150);
        pause(650); // Additional pause between dialogues

        displayWithDelay("\nHe was responsible for finalizing the game before handing it over to the QA tester,", 150);
        displayWithDelay("ensuring there would be fewer bugs on launch day.", 150);
        pause(650);

        displayWithDelay("\nBut while coding, exhaustion overcame him, and he suddenly passed out.", 150);
        displayWithDelay("When he woke up, he found himself on a hill overlooking two massive armies locked in battle.", 150);
        pause(650);

        // Character dialogue
        displayWithDelay("\n"+name + ": Where am I?", 150); // Faster delay
        pause(350);

        displayWithDelay("\nMysterious Creature: Hello there, " + name + ".", 150);
        displayWithDelay("I am a guardian of this world, and I have summoned you here to help us.", 150);
        pause(350);

        displayWithDelay("\n"+name + ": What are you?", 150);
        displayWithDelay("Why are they fighting over there? Take me back!", 150);
        pause(350);

        displayWithDelay("\nMysterious Creature: Calm down, " + name + ".", 150);
        displayWithDelay("I will explain the situation before answering your questions, so listen carefully.", 150);
        pause(650);

        ///////////////////// WORLD SETTING /////////////
        displayWithDelay("\nThousands of years ago, when the world was fractured and untamed,", 100);
        displayWithDelay("wars raged across every corner of the land.", 100);
        pause(300);

        displayWithDelay("\nKingdoms rose and fell under the rule of brutal warlords,", 100);
        displayWithDelay("and the earth was soaked in the blood of countless battles.", 100);
        displayWithDelay("It was a time when savage rulers held dominion over their realms,", 100);
        displayWithDelay("caring little for unity or peace.", 100);
        pause(300);

        displayWithDelay("\nBut amidst this chaos, two legendary figures emerged,", 100);
        displayWithDelay("men of great power and vision, destined to alter the course of history.", 100);
        displayWithDelay("They hailed from opposite ends of the known world,", 100);
        displayWithDelay("yet their fates would intertwine to shape a new era.", 100);
        pause(300);

        displayWithDelay("\nFrom the west came Arthur, known as 'King of Knights.'", 100);
        displayWithDelay("He rose in the war-torn lands of Albion, leading his people", 100);
        displayWithDelay("to repel the marauding barbarians that plagued the western kingdoms.", 100);
        pause(300);

        displayWithDelay("\nUnder his leadership, the mighty kingdom of Camelot was founded,", 100);
        displayWithDelay("a bastion of chivalry and order amidst the darkness.", 100);
        displayWithDelay("Arthur was not just a king but a symbol,", 100);
        displayWithDelay("a leader destined to guide his people toward peace,", 100);
        displayWithDelay("wielding the legendary sword Excalibur to unite the western tribes.", 100);
        pause(300);

        displayWithDelay("\nIn the far east, the 'Old Man of the Mountain' Ziusudra ruled with wisdom and strength.", 100);
        displayWithDelay("He led his people against the vicious pirate fleets that terrorized the coastal lands,", 100);
        displayWithDelay("creating the indomitable kingdom of Asura.", 100);
        pause(300);

        displayWithDelay("\nHis people revered him as a sage-warrior,", 100);
        displayWithDelay("a ruler who balanced martial prowess with deep knowledge.", 100);
        displayWithDelay("Under Ziusudra’s guidance, Asura became a prosperous land,", 100);
        displayWithDelay("renowned for its disciplined armies and enlightened philosophy.", 100);
        pause(300);

        displayWithDelay("\nThough separated by vast distances and different cultures,", 100);
        displayWithDelay("both Arthur and Ziusudra shared a vision of peace and stability.", 100);
        displayWithDelay("They understood that the unrelenting conflict between their lands", 100);
        displayWithDelay("could only be resolved through unity.", 100);
        pause(300);

        displayWithDelay("\nThus, the two kings formed an alliance,", 100);
        displayWithDelay("joining their forces in a historic campaign to drive out the enemies from their regions.", 100);
        displayWithDelay("Together, they forged a monumental empire,", 100);
        displayWithDelay("uniting the western and eastern lands under a single banner—the great empire of Avalon.", 100);
        pause(300);

        displayWithDelay("\nIn their joint reign, Arthur and Ziusudra established a diarchy,", 100);
        displayWithDelay("ruling as equal sovereigns.", 100);
        displayWithDelay("Avalon flourished under their combined leadership.", 100);
        pause(300);

        displayWithDelay("\nThe people spoke of a golden age,", 100);
        displayWithDelay("where knights and scholars, warriors and philosophers,", 100);
        displayWithDelay("worked together to build a civilization that surpassed all others.", 100);
        displayWithDelay("The empire stretched from the mountains of the west to the shores of the east,", 100);
        displayWithDelay("and peace reigned for the first time in centuries.", 100);
        pause(300);

        displayWithDelay("\nHowever, no kingdom lasts forever.", 100);
        displayWithDelay("When Arthur and Ziusudra passed away, Avalon’s foundation began to crack.", 100);
        displayWithDelay("Without their guiding hands, ambition and greed festered among their successors.", 100);
        pause(300);

        displayWithDelay("\nThe once-unified lands of Avalon splintered,", 100);
        displayWithDelay("as the western kingdom of Camelot and the eastern realm of Asura vied for dominance.", 100);
        displayWithDelay("The harmony that Arthur and Ziusudra had painstakingly built was forgotten,", 100);
        displayWithDelay("and the two great kingdoms plunged into bitter conflict.", 100);
        pause(300);

        displayWithDelay("\nFor thousands of years, Camelot and Asura clashed in an endless struggle for supremacy,", 100);
        displayWithDelay("each claiming the legacy of Avalon while seeking to impose its will on the other.", 100);
        pause(300);

        displayWithDelay("\nThe scars of that ancient diarchy remained etched into the fabric of both nations,", 100);
        displayWithDelay("as neither could fully conquer the other,", 100);
        displayWithDelay("and the dream of a unified world became a distant memory.", 100);
        pause(300);

        //////////////////////////
        // Character Dialogue
        displayWithDelay("Mysterious Creature: And you have been summoned as the Great Chosen One.", 100);
        displayWithDelay("It is your duty to choose which empire to side with in order to end the war.", 100);
        pause(350);

        displayWithDelay(name + ": So, you're saying I am the one who is supposed to end this war?", 100);
        pause(350);

        displayWithDelay("\nMysterious Creature: Yes, exactly. That is why you were summoned, O Great One.", 300);
        pause(350);

        displayWithDelay(name + ": But I can’t fight!", 300);
        pause(350);

        displayWithDelay("\nMysterious Creature: The kingdoms have gathered their elite warriors,", 300);
        displayWithDelay("ready to engage in the impending battles.", 300);
        displayWithDelay("Your duty is to select a side and lead these champions to triumph.", 300);
        displayWithDelay("However, time is no longer on my side.", 300);
        displayWithDelay("I shall inscribe a symbol upon your arm, a testament to your loyalty and a mark of the trust I place in you.", 300);
        displayWithDelay("With this emblem, I entrust you with the weighty responsibility of guiding our forces to victory.", 300);
        pause(350);

        displayWithDelay(name + ": Wait, I still have more questions!", 300);
        pause(350);

        displayWithDelay("\nMysterious Creature: fades away", 300);
        pause(350);
    }


    @Override
    public void tellStoryKingdom(String kingdom, String name, String warrior, String ranger, String mage) {
        displayWithDelay("The main character " + name + " stands before the generals, having chosen a side.", 300);
        displayWithDelay("He explains his purpose to them.", 300);
        pause(350);
    
        displayWithDelay(name + ": I have been sent by a higher being, a mysterious creature,", 300);
        displayWithDelay("to aid in bringing an end to this war.", 300);
        pause(350);
    
        displayWithDelay("General: So, you are here to assist us at the behest of the true beings?", 300);
        pause(350);
    
        displayWithDelay(name + ": Yes, that is the essence of my mission.", 300);
        pause(350);
    
        displayWithDelay("General: How do you intend to prove that you were sent by the higher beings?", 300);
        pause(350);
    
        displayWithDelay("You reveal the mark engraved on your arm.", 300);
        pause(350);
    
        displayWithDelay("General: It seems the prophecy was true. You are the chosen one.", 300);
        displayWithDelay("Follow me; I will escort you to the king.", 300);
        pause(350);
    
        displayWithDelay(warrior + " (Warrior class): \"O great chosen one, I, " + warrior + ",", 300);
        displayWithDelay("from the " + kingdom + ", pledge my unwavering loyalty to you.", 300);
        displayWithDelay("With my sword and shield, I shall fight fiercely by your side until victory is ours in this war.\"", 300);
        pause(350);
    
        displayWithDelay(ranger + " (Ranger class): \"O great chosen one, I, " + ranger + ",", 300);
        displayWithDelay("from the " + kingdom + ", vow to be your eyes and ears in the wild.", 300);
        displayWithDelay("My arrows shall strike true, and no enemy will escape my keen sight.", 300);
        displayWithDelay("Together, we will move swiftly and silently to bring triumph in this battle.\"", 300);
        pause(350);
    
        displayWithDelay(mage + " (Mage class): \"O great chosen one, I, " + mage + ",", 300);
        displayWithDelay("from the " + kingdom + ", offer you the power of the ancient elements.", 300);
        displayWithDelay("With the forces of fire, ice, and lightning at my command,", 300);
        displayWithDelay("I will shatter the enemies that stand in our way.", 300);
        displayWithDelay("Let magic guide our path to victory.\"", 300);
        pause(350);
    
        displayWithDelay("The King steps forward, his demeanor commanding yet regal.", 300);
        pause(350);
    
        // Adjusting based on chosen kingdom
        displayWithDelay("King of " + kingdom + ": You claim to be a harbinger of hope in these dark times.", 300);
        displayWithDelay("I shall place my trust in you.", 300);
        displayWithDelay("I will entrust you with my finest warriors; they will be under your command", 300);
        displayWithDelay("as we strive to secure victory in this conflict.", 300);
        pause(350);
    
        displayWithDelay("The King gestures to the warriors, ready and eager to fight.", 300);
        pause(350);
    
        displayWithDelay("King of " + kingdom + ": Now go, and lead us to triumph in this war.", 300);
        pause(350);
    
        displayWithDelay("The MC departs, accompanied by the warriors he has selected,", 300);
        displayWithDelay("determined to face the challenges that lie ahead.", 300);
        pause(350);
    }
    



    @Override 
    public void tellStoryEnd(String name) {
        displayWithDelay(name + ": Finally, it’s over! We did it, guys!", 300);
        pause(350);
    
        displayWithDelay("Mysterious Creature: Well done, " + name + ".", 300);
        displayWithDelay("You have done well for the task and hardships that I have given you.", 300);
        displayWithDelay("With this, I can now safely send you back to your world.", 300);
        pause(350);
    
        displayWithDelay(name + ": Thank you! I didn't know if I could make it through,", 300);
        displayWithDelay("but we pushed through together. I am ready to go home now!", 300);
        pause(350);
    
        displayWithDelay("Mysterious Creature casts a spell that sends the MC back home.", 300);
        displayWithDelay("MC wakes up and looks around the house.", 300);
        pause(350);
    
        displayWithDelay(name + ": Man, what a crazy day! But at least I did something valuable from that trip.", 300);
        pause(350);
    
        displayWithDelay("QA Tester calls for the code.", 300);
        pause(350);
    
        displayWithDelay(name + ": Oh no, I forgot I still have projects to finish!", 300);
        displayWithDelay("I better hurry up, or I might get fired!", 300);
        pause(350);
    }
    @Override
    public void tellCharLoreAttack() {
       
    }

    @Override
    public void tellCharLoreSupport() {
        
    }



    

}
