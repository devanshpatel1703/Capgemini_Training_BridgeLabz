import java.util.Scanner;

public class Question9 {

    // Function for addition
    public static double add(double x, double y) {
        return x + y;
    }

    // Function for subtraction
    public static double subtract(double x, double y) {
        return x - y;
    }

    // Function for multiplication
    public static double multiply(double x, double y) {
        return x * y;
    }

    // Function for division
    public static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Error! Division by zero.");
            return Double.NaN;  // Return NaN to indicate an invalid result
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        // Get user input for the operation
        System.out.print("Enter choice (1/2/3/4): ");
        int choice = scanner.nextInt();

        // Check if the choice is valid
        if (choice >= 1 && choice <= 4) {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            // Perform the chosen operation
            double result = 0;
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("The result of addition is: " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("The result of subtraction is: " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("The result of multiplication is: " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("The result of division is: " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid operation.");
            }
        } else {
            System.out.println("Invalid choice! Please select a valid operation.");
        }

        scanner.close();
    }
}
