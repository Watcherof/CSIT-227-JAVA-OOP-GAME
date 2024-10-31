public abstract class Characters {
    protected String name;      // Character's name
    protected int health;       // Character's health points
    protected int defence;      // Character's defence points
    protected String type;      // Type of character (e.g., Mage, Warrior)
    protected int shield;       // Shield value 


    // Constructor to initialize character attributes
    public Characters(String name, int health, int defence, String type) {
        this.name = name;       // Set character's name
        this.health = health;   // Set character's initial health
        this.defence = defence; // Set character's defence value
        this.type = type;       // Set character's type
    }

    // Getter for character's name
    public String getName() {
        return name;
    }

    // Getter for character's type
    public String getType() {
        return type;
    }

    // Getter for character's health
    public int getHealth() {
        return health;
    }

    // Getter for character's defence
    public int getDefence() {
        return defence;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getShield() {
        return shield;
    }



    // Method to check if the character is alive
    public boolean isAlive() {
        return health > 0; // Returns true if health is greater than 0
    }

    // Method to take damage, applying defence
    public int takeDamage(int damage) {
        //int damageTaken = Math.max(damage - defence, 0); // Calculate damage after defence
        if (shield > 0) {
            if (shield > damage) {
                shield -= damage;
                System.out.println("Shield blocked the attack!");
                damage = 0;
            } else {
                damage -= shield;
                shield = 0;
                health -= damage;
                System.out.println("Shield broken!");
            }
        } else {
            this.health -= damage; // Subtract damage taken from healt
        }

        if (health < 0) {
            health = 0; // Ensure health does not drop below 0
        }
        return damage; // Return the amount of damage taken
    }

    // Abstract methods for character actions to be implemented by subclasses
    public abstract void basicAttack(int res, Characters opponent,int gameMode);
    public abstract void skill(int res, Characters opponent,int gameMode);
    public abstract void ult(int res, Characters opponent,int gameMode);
    public abstract void switchCharacter(int res);
    public abstract int getRandomBetween(int min, int max);
    public abstract void choices(int res,int gameMode);

    // Method to display text with a delay between words
    public void displayWithDelay(String text, int delayInMillis) {
        String[] words = text.split(" ");  // Split text into words
        for (String word : words) {
            System.out.print(word + " ");   // Print each word followed by a space
            try {
                Thread.sleep(delayInMillis); // Pause for the specified delay
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Restore interrupt status if interrupted
            }
        }
        System.out.println(); // Print a newline after the text
    }

    public void heal(int healAmount) {
        this.health += healAmount;
    }
}
