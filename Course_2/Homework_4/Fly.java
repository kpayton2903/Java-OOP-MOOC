public class Fly {
    private double mass;
    private double speed;

    public static final double DEFAULT_MASS = 5.0;
    public static final double DEFAULT_SPEED = 10.0;

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public final double getMass() {
        return mass;
    }

    public final void setMass(double mass) {
        this.mass = mass;
    }

    public final double getSpeed() {
        return speed;
    }

    public final void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (mass == 0){
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", 
            speed);
        }
        else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.",
            speed, mass);
        }
    }

    public void grow(int newMass) {
        int i;
        for (i = newMass; i > 0; i--){
            if (mass < 20) {
                setSpeed(speed + 1);
                setMass(mass + 1);
            }

            else {
                setSpeed(speed - 0.5);
                setMass(mass + 1);
            }
        }
    }

    public boolean isDead() {
        return (mass == 0);
    }
}
