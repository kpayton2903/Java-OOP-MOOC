
public class PrimitiveOperations {
    public static void main(String[] args) {
        int var1 = 12;
        double var2 = 3.25;
        System.out.println(var1);
        System.out.println(var2);
        double var3 = var1 * var2;
        System.out.println(var3);
        float newVar1 = var1;
        System.out.println(newVar1);
        int newVar2 = (int)var2;
        System.out.println(newVar2);
        char var4 = 'K';
        System.out.println(var4);
        int intVar4 = (int)var4 + 32;
        var4 = (char)intVar4;
        System.out.println(var4);
    }
}
