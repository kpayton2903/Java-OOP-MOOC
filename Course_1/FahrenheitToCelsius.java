import java.util.Scanner;

public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        String day = input.next();
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
        if (fahrenheit > 70)
            System.out.println("Yay! Go to park.");
    }
}

/*
-Names of classes are called identifiers and can contain letters, digits, 
_, and $ and cannot start with a number.
-Java convention uses camal casing.
-We must declare our variables and provide their type.
-int sets the variable to integers ranging from +- 2 billion.
-Double allows us to include a wide range of decimal values.
-There is not just one specific type of integer/real number they all have
various ranges of numbers they can be depending on the storage they take.
-We use classes for everything in python and they contain methods which are
essentially functions.
-Must recompile each time it is updated.
-Three types of errors are Compiler, Runtime, and Logical.
-Compiler errors typically represent syntax violations.
-Runtime errors occur after the program is compiled, and it gives an error
while attempting to run it.
-Variables scope is within their set of curly braces.
-The primitive data types are bye, short, int, long, float, double, char, and boolean.
-Byte, short, int, and long all represent integers,
-Float and double are for real values,
-Char is for characters.
-Boolean is for True/False.
-Numbers are integers by default, so sometimes we must override their default
datatype by using L for long, F for float, D for double, etc.
-We use '' for characters
-Some escape sequences include \t for new tab, \n for newline
\r for carriage return, \\ for a backslash, \' for a single quote and \" for a double quote
-When dividng, the decimal is omitted, so we must make either the numerator or 
denominator a float
-When declaring variables, you cannot change assignments unless that data type is within
the bounds of the new data type
-We can use casting, placing a datatype assignment in parenthesis before a value, to
change its type.
-When creating a new instance of a class we must include the new operator
*/
