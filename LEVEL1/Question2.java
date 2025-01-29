import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        int num1 = getInput("Enter the first number: ", scanner);
        int num2 = getInput("Enter the second number: ", scanner);
        int num3 = getInput("Enter the third number: ", scanner);

        // Find the maximum
        int max = findMax(num1, num2, num3);

        // Display the result
        System.out.println("The maximum of the three numbers is: " + max);

        scanner.close();
    }

    // Method to get user input
    public static int getInput(String message, Scanner scanner) {
        System.out.print(message);
        return scanner.nextInt();
    }

    // Method to find the maximum of three numbers
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
