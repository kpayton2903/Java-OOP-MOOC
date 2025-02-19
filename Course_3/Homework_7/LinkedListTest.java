public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> newList = new LinkedList<>();
        newList.add(3);
        newList.add(4);
        System.out.println(newList.toString());
        newList.add(0, 2);
        System.out.println(newList.toString());
        System.out.println(newList.remove(0));
        System.out.println(newList.size());
        System.out.println(newList.toString());
        newList.add(4);
        newList.add(5);
        System.out.println(newList.toString());
        newList.remove((Object) 4);
        System.out.println(newList.toString());
    }
}
