public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUESPEED = 5.0;

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if(age > 1 && age < 7) {
            this.isFroglet = true;
        }
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        int ageInMonths = (int) (ageInYears * 12);
        this.name = name;
        this.age = ageInMonths;
        this.tongueSpeed = tongueSpeed;
        if(age > 1 && age < 7) {
            this.isFroglet = true;
        }
    }

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
    }

    public void grow(int months) {
        while(months > 0) {
            if (age < 12) {
                tongueSpeed++;
            }
            else if (age >= 30 && tongueSpeed > 5) {
                tongueSpeed--;
            }
            age++;
            months--;
        }

        if(isFroglet != true && age > 1 && age < 7) {
            this.isFroglet = true;
        }
    }

    public void grow() {
        this.grow(1);
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        }
        else if (tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() > (0.5 * age)) {
                
            }
        }
    }
}
