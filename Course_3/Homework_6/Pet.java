public class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet (String name, double health, int painLevel) {
        this.name = name;

        if (health > 1.0) {
            this.health = 1.0;
        }
        else if (health < 0.0) {
            this.health = 0.0;
        }
        else
            this.health = health;
        
        if (painLevel > 10) {
            this.painLevel = 10;
        }
        else if (painLevel < 1) {
            this.painLevel = 1;
        }
        else
            this.painLevel = painLevel;
    }

    public 
}