import java.util.Scanner;

public class Calculator {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operator = input.next().toLowerCase();
        switch (operator) {
            case "add": {
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int number1 = input.nextInt();
                    if (input.hasNextInt()) {
                        int number2 = input.nextInt();
                        int answer = number1 + number2;
                        System.out.println("Answer: " + answer);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            }
            
            case "subtract": {
                System.out.println("Enter two integers:");
                if (input.hasNextInt()) {
                    int number1 = input.nextInt();
                    if (input.hasNextInt()) {
                        int number2 = input.nextInt();
                        int answer = number1 - number2;
                        System.out.printf("Answer: %d\n", answer);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            }

            case "multiply": {
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double number1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double number2 = input.nextDouble();
                        double answer = number1 * number2;
                        System.out.printf("Answer: %.2f\n", answer);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            }

            case "divide": {
                System.out.println("Enter two doubles:");
                if (input.hasNextDouble()) {
                    double number1 = input.nextDouble();
                    if (input.hasNextDouble()) {
                        double number2 = input.nextDouble();
                        if (number2 == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                        double answer = number1 / number2;
                        System.out.printf("Answer: %.2f\n", answer);
                        break;
                    }
                }
                System.out.println("Invalid input entered. Terminating...");
                break;
            }
                
            case "alphabetize": {
                System.out.println("Enter two words:");
                String word1 = input.next();
                String word2 = input.next();
                if (word1.toLowerCase().compareTo(word2.toLowerCase()) < 0) {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", word1, word2);
                    break;
                }
                else if (word1.toLowerCase().compareTo(word2.toLowerCase()) > 0) {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", word2, word1);
                    break;
                }
                else {
                    System.out.println("Answer: Chicken or Egg.");
                    break;
                }
            }
            default: 
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
    }
}

