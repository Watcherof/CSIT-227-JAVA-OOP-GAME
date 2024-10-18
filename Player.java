public class Player {
    int player = 0;
    int[] points;

    public Player(int player) {
        this.player = player;
    }

    public void chars() {
        ChoicesPVE choicesPVE = new ChoicesPVE(player);
        String[] chars = choicesPVE.getChosenCharacters();

        Characters[] characters = new Characters[3];

        for (int i = 0; i < 3; i++) {
            if ("Guardians".equals(chars[i])) {  // Use equals() for string comparison
                characters[i] = (Characters) new Guardian();  // Store Guardian object in the array
            } else if ("General".equals(chars[i])) {
                characters[i] = (Characters) new General();   // Store General object in the array
            }
        }
    }   

    

    public void wish() {
        System.out.println("============== Player: " + player + "=============");
        Combat combat = new Combat();
        points = combat.wish();
    }

    public void getPoints() {
        Combat combat = new Combat();
        points = combat.getPoints();
    }

    public void displayPoints(String character) {
        
        System.out.println("You currently have: ");
        System.out.println("Mana: " + points[0] + ", Stamina: " + points[1] + ", Spirit: " + points[2] + ", Energy: " + points[3]);
    }
}
