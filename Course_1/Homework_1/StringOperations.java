public class StringOperations {
    public static void main(String[] args) {
        String name = "Kevin";
        System.out.println(name);
        name = name.replace('K', 'A');
        name = name.replace('n', 'Z');
        System.out.println(name);
        String url = "www.stackoverflow.com";
        System.out.println(url);
        int end = url.length() - 4;
        String newUrl = url.substring(4, end);
        System.out.println(newUrl + "1331");
    }
}
