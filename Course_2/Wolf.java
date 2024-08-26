public class Wolf extends Canine {
    protected int rank;

    public Wolf(double size, int rank) {
        super(size);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public void bark() {
        for (int i = 1; i <= 3; i++) {
            super.bark();
        }
    }

    public void bark(int barkMultiple) {
        for (int i=1; i<=barkMultiple; i++)
            super.bark();
    }

    public void groom() {
        System.out.println("lick");
    }

    public static void main(String[] args) {
        Wolf alpha = new Wolf(17.1, 1);
        alpha.bark();
    }
}
