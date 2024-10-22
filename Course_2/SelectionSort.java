public class SelectionSort {
    public static void Sorter(Comparable[] myArray) {
        for (int j=0; j < myArray.length - 1; j++) {
            int smallestIndex = j;

            for (int i=j + 1; i < myArray.length; i++) {
                if (myArray[i].compareTo(myArray[smallestIndex]) < 0) {
                    smallestIndex = i;
                }
            }

            Comparable temp = myArray[j];
            myArray[j] = myArray[smallestIndex];
            myArray[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        
    }
}