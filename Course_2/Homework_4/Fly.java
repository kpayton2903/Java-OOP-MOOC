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
        if(isLegalMass(mass)) {
            this.mass = mass;
        }
    }

    private boolean isLegalMass(double mass) {
        return (mass >= 0);
    }

    public final double getSpeed() {
        return speed;
    }

    public final void setSpeed(double speed) {
        if(isLegalSpeed(speed)) {
            this.speed = speed;
        }
    }

    private boolean isLegalSpeed(double speed) {
        return (speed >= 0);
    }
    
    public String toString() {
        if (mass == 0){
            return String.format("I'm dead, but I used to be a fly with a speed of %f.", 
            speed);
        }
        else {
            return String.format("I'm a speedy fly with %f speed and %f mass.",
            speed, mass);
        }
    }

    public void grow(int mass) {
        int i;
        for (i = mass; i > 0; i--){
            if (mass < 20) {
                speed++;
                mass++;
            }
            else {
                speed = speed - 0.5;
                mass++;
            }
        }
    }

    public boolean isDead() {
        return (mass == 0);
    }
}
