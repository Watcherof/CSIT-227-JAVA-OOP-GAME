public class Story implements Stories {
    @Override
    public void tellStoryIntro(String name) {
        //////////////
        displayWithDelay("One day in Cebu, a game developer had not slept or eaten for three days because he was busy coding a game that was set to release soon.", 250);
        pause(1000); // Additional pause between dialogues

        displayWithDelay("He was responsible for finalising the game before handing it over to the QA tester, ensuring there would be fewer bugs on launch day.", 250);
        pause(1000); // Additional pause between dialogues

        displayWithDelay("But while coding, exhaustion overcame him, and he suddenly passed out. When he woke up, he found himself on a hill overlooking two massive armies locked in battle.", 250);
        pause(1000); // Additional pause between dialogues

        displayWithDelay(name + ": Where am I?", 300); // Faster delay
        pause(500);

        displayWithDelay("Mysterious Creature: Hello there, "+ name + ". I am a guardian of this world, and I have summoned you here to help us.", 300); // Faster delay
        pause(500);

        displayWithDelay(name + ": What are you? Why are they fighting over there? Take me back!", 300); // Faster delay
        pause(500);

        displayWithDelay("Mysterious Creature: Calm down, " + name + ". I will explain the situation before answering your questions, so listen carefully.", 300); // Faster delay
        pause(1000);
        
        ////////////////////////

            
        ///////////////////// WORLD SETTING /////////////
        displayWithDelay("Thousands of years ago, when the world was fractured and untamed, wars raged across every corner of the land. ",150);
        pause(300);


        displayWithDelay("Kingdoms rose and fell under the rule of brutal warlords, and the earth was soaked in the blood of countless battles. It was a time when savage rulers held dominion over their realms, caring little for unity or peace.",150);
        pause(300);


        displayWithDelay("But amidst this chaos, two legendary figures emerged—men of great power and vision, destined to alter the course of history. They hailed from opposite ends of the known world, yet their fates would intertwine to shape a new era.",150);
        pause(300);


        displayWithDelay("From the west came Arthur, known as “King of Knights.” He rose in the war-torn lands of Albion, leading his people to repel the marauding barbarians that plagued the western kingdoms.",150);
        pause(300);

        displayWithDelay("Under his leadership, the mighty kingdom of Camelot was founded, a bastion of chivalry and order amidst the darkness. Arthur was not just a king but a symbol,a leader destined to guide his people toward peace, wielding the legendary sword Excalibur to unite the western tribes.",150);
        pause(300);


        displayWithDelay("In the far east, the \"Old Man of the Mountain\" Ziusudra ruled with wisdom and strength. He led his people against the vicious pirate fleets that terrorised the coastal lands, creating the indomitable kingdom of Asura.", 150);
        pause(300);

        displayWithDelay("His people revered him as a sage-warrior, a ruler who balanced martial prowess with deep knowledge. Under Ziusudra’s guidance, Asura became a prosperous land, renowned for its disciplined armies and enlightened philosophy.",150);
        pause(300);
        
        displayWithDelay("Though separated by vast distances and different cultures, both Arthur and Ziusudra shared a vision of peace and stability. They understood that the unrelenting conflict between their lands could only be resolved through unity.",150);
        pause(300);

        displayWithDelay(" Thus, the two kings formed an alliance, joining their forces in a historic campaign to drive out the enemies from their regions. Together, they forged a monumental empire, uniting the western and eastern lands under a single banner—the great empire of Avalon.",150);
        pause(300);


        displayWithDelay("n their joint reign, Arthur and Ziusudra established a diarchy, ruling as equal sovereigns. Avalon flourished under their combined leadership",150);
        pause(300);


        displayWithDelay("The people spoke of a golden age were knights and scholars, warriors and philosophers worked together to build a civilization that surpassed all others. The empire stretched from the mountains of the west to the shores of the east, and peace reigned for the first time in centuries.",150);
        pause(300);


        displayWithDelay("However, no kingdom lasts forever. When Arthur and Ziusudra passed away from the world, Avalon’s foundation began to crack. Without their guiding hands, ambition and greed festered among their successors.",150);
        pause(300);

        displayWithDelay("The once-unified lands of Avalon splintered, as the western kingdom of Camelot and the eastern realm of Asura vied for dominance. The harmony that Arthur and Ziusudra had painstakingly built was forgotten, and the two great kingdoms plunged into bitter conflict.",150);
        pause(300);

        displayWithDelay("For thousands of years, Camelot and Asura clashed in an endless struggle for supremacy, each claiming the legacy of Avalon while seeking to impose its will on the other.",150);
        pause(300);

        displayWithDelay("The scars of that ancient diarchy remained etched into the fabric of both nations, as neither could fully conquer the other, and the dream of a unified world became a distant memory.",150);
        pause(300);

        //////////////////////////
        displayWithDelay("Mysterious Creature: And you have been summoned as the Great Chosen One. It is your duty to choose which empire to side with in order to end the war.", 150); // Faster delay
        pause(500);


        displayWithDelay(name + ": So, you're saying I am the one who is supposed to end this war?", 150);
        pause(500);

        
        displayWithDelay("Mysterious Creature: Yes, exactly. That is why you were summoned, O Great One. ",300);
        pause(500);

        displayWithDelay(name + ": But I can’t fight!",300);
        pause(500);

        displayWithDelay("Mysterious Creature: The kingdoms have gathered their elite warriors, ready to engage in the impending battles. Your duty is to select a side and lead these champions to triumph. However, time is no longer on my side. I shall inscribe a symbol upon your arm, a testament to your loyalty and a mark of the trust I place in you. With this emblem, I entrust you with the weighty responsibility of guiding our forces to victory.",300);
        pause(500);

        
        displayWithDelay(name + ": Wait, I still have more questions!",300);
        pause(500);


        displayWithDelay("Mysterious Creature: fades away",300);
        pause(500);

    }

    @Override
    public void tellStoryKingdom(String kingdom, String name,String warrior,String ranger,String mage){
        displayWithDelay("The main character " + name + " stands before the generals, having chosen a side. He explains his purpose to them.",300);
        pause(500);

        displayWithDelay(name +": I have been sent by a higher being a mysterious creature to aid in bringing an end to this war.",300);
        pause(500);

        displayWithDelay("General: So, you are here to assist us at the behest of the true beings?",300);
        pause(500);

    
        displayWithDelay(name + ": Yes, that is the essence of my mission",300);
        pause(500);


        displayWithDelay("General: How do you intend to prove that you were sent by the higher beings?",300);
        pause(500);


        displayWithDelay("You reveal the mark engraved on your arm.",300);
        pause(500);

        displayWithDelay("General: It seems the prophecy was true. You are the chosen one. Follow me; I will escort you to the king.",300);
        pause(500);

        displayWithDelay(warrior + " (Warrior class): \"O great chosen one, I, "+ warrior +", from the [place of the chosen warrior], pledge my unwavering loyalty to you. With my sword and shield, I shall fight fiercely by your side until victory is ours in this war.\"", 300);
        pause(500);
        
        displayWithDelay(ranger + " (Ranger class): \"O great chosen one, I, "+ ranger +", from the [place of the chosen ranger], vow to be your eyes and ears in the wild. My arrows shall strike true, and no enemy will escape my keen sight. Together, we will move swiftly and silently to bring triumph in this battle.\"", 300);
        pause(500);

        displayWithDelay(mage + " (Mage class): \"O great chosen one, I, " + mage + ", from the [place of the chosen mage], offer you the power of the ancient elements. With the forces of fire, ice, and lightning at my command, I will shatter the enemies that stand in our way. Let magic guide our path to victory.\"", 300);
        pause(500);

        displayWithDelay("The King steps forward, his demeanour commanding yet regal.",300);
        pause(500);


        // change this  parts cause the identity of the king will depend on the kingdom that the mc chooses
        displayWithDelay("King of (Asura/Camelot): You claim to be a harbinger of hope in these dark times. I shall place my trust in you. I will entrust you with my finest warriors; they will be under your command as we strive to secure victory in this conflict.",300);
        pause(500);


        displayWithDelay("The King gestures to the warriors, ready and eager to fight.",300);
        pause(500);

        displayWithDelay("King of (Asura/Camelot): Now go, and lead us to triumph in this war.",300);
        pause(500);

        displayWithDelay("The MC departs, accompanied by the warriors he has selected, determined to face the challenges that lie ahead.",300);
        pause(500);
 
    }


    @Override 
    public void tellStoryEnd(String name){

        displayWithDelay(name + ": Finally, it’s over! We did it, guys!",300);
        pause(500);

        displayWithDelay("Mysterious Creature: Well done, " + name + ". You have done well for the task and hardships that I have given you. With this, I can now safely send you back to your world.",300);
        pause(500);


        displayWithDelay(name + ": Thank you! I didn't know if I could make it through, but we pushed through together. I amm ready to go home now!",300);
        pause(500);

        displayWithDelay(" Mysterious Creature casts a spell that sends the MC back home\nMC wakes up and looks around the house.",300);
        pause(500);

        displayWithDelay(name + ": Man, what a crazy day! But at least I did something valuable from that trip.",300);
        pause(500);

        displayWithDelay("QA Tester calls for the code.",300);
        pause(500);

        displayWithDelay("MC: Oh no, I forgot I still have projects to finish! I better hurry up, or I might get fired!",300);
        pause(500);

    }

       /*
        displayWithDelay("",300);
        pause(500);

        displayWithDelay("",150);
        pause(300);
        
        */
    
    private void displayWithDelay(String text, int delayInMillis) {
        String[] words = text.split(" ");  // Split text into words
        for (String word : words) {
            System.out.print(word + " ");   // Print each word followed by a space
            try {
                Thread.sleep(delayInMillis); // Delay between each word
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Handle interruptions
            }
        }
        System.out.println(); // Move to the next line after the text is displayed
    }

    // New method to handle the pause
    private void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); // Handle interruptions
        }
    }
}
