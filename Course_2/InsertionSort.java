public class InsertionSort {
    public static void InsertionSort(int[] list) {
        for (int unsortedStart = 1; unsortedStart < list.length; unsortedStart++) {
            int nextInsert = list[unsortedStart];
            int currentIndex = unsortedStart - 1;

            while (currentIndex >= 0 && list[currentIndex] > nextInsert) {
                list[currentIndex + 1] = list[currentIndex];
                currentIndex--;
            }

            list[currentIndex + 1] = nextInsert;
        }
    }
}
