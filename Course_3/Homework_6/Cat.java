public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel){
        this(name, health, painLevel, 0);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        int timeTaken;

        if (miceCaught < 4) {
            timeTaken = (int) Math.ceil((getPainLevel()*2) / getHealth());
        }
        else if (4 <= miceCaught && miceCaught <= 7) {
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
            printLine += "meow";
            if (i < getPainLevel() - 1)
                printLine += " ";
        }

        if (getPainLevel() > 5)
            printLine = printLine.toUpperCase();

        System.out.println(printLine);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat compareCat = (Cat) o;
            return super.equals(compareCat) && miceCaught == compareCat.miceCaught;
        }
        return false;
    }
}