import java.util.Arrays;

public class Wolf extends Canine implements Comparable<Wolf>{
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

    @Override
    public void groom() {
        System.out.println("lick");
    }

    @Override
    public int compareTo(Wolf anotherWolf) {
        return -(rank - anotherWolf.rank);
    }

    @Override
    public String toString() {
        return ("Rank " + rank + ", Size " + size);
    }

    public static void main(String[] args) {
        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(3, 10),
            new Wolf(9.2, 7),
            new Wolf(9.1, 8),
            new Wolf(17.1, 3),
            new Wolf(16.2, 1),
            new Wolf(16, 4),
            new Wolf(16, 5),
            new Wolf(10, 6),
            new Wolf(5, 9)
        };
        System.out.println("Unsorted Pack: " + Arrays.toString(pack));
        Arrays.sort(pack);
        System.out.println("=================");
        System.out.println("sorted Pack: " + Arrays.toString(pack));
    }
}
