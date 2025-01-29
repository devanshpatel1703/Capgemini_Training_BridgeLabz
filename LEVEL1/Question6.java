import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate factorial using recursion
        long factorial = calculateFactorial(number);

        // Display result
        System.out.println("Factorial of " + number + " is: " + factorial);

        scanner.close();
    }

    // Recursive method to calculate factorial
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        }
        return n * calculateFactorial(n - 1); // Recursive call
    }
}
