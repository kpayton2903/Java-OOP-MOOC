public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        int timeTaken;

        if (droolRate < 3.5) {
            timeTaken = (int) Math.ceil((getPainLevel()*2) / getHealth());
        }
        else if (3.5 <= droolRate && droolRate <= 7.5) {
            timeTaken = (int) Math.ceil(getPainLevel() / getHealth());
        }
        else {
            timeTaken = (int) Math.ceil(getPainLevel() / (getHealth()*2));
        }
        heal();
        
        return timeTaken;
    }

    @Override
    public void speak() {
        super.speak();
        String printLine = "";

        for (int i=0; i < getPainLevel(); i++) {
            printLine += "bark";
            if (i < getPainLevel() - 1)
                printLine += " ";
        }

        if (getPainLevel() > 5)
            printLine = printLine.toUpperCase();

        System.out.println(printLine);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog compareDog = (Dog) o;
            return super.equals(compareDog) && droolRate == compareDog.droolRate;
        }
        return false;
    }
}