import java.util.Scanner;

public class FahrenheitToCelsiusExceptions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a Fahrenheit value: ");
                int fahrenheit = Integer.parseInt(input.nextLine());
                double celsius = (5.0/9) * (fahrenheit - 32);
                System.out.printf("Fahrenheit: %d\n", fahrenheit);
                System.out.printf("Celsius:    %.1f\n", celsius);
                double x = 1331/fahrenheit;
                break;
            }
            catch (NumberFormatException ime) {
                System.out.println("Sorry, that wasn't an int");
                System.out.println("Please re-run the program again");
            }
            catch (ArithmeticException ae) { 
                System.out.println("You entered an invalid number:");
                System.out.println(ae.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}