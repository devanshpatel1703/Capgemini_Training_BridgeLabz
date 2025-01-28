import java.util.Scanner;

public class Question2 {

    // Method to find the sum of n natural numbers using recursion
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;  // Base case: sum of first 1 natural number is 1
        }
        return n + recursiveSum(n - 1);  // Recursive step
    }

    // Method to find the sum of n natural numbers using the formula n*(n+1)/2
    public static int formulaSum(int n) {
        return (n * (n + 1)) / 2;  // Formula for the sum of first n natural numbers
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number n
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the input is a positive natural number
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;  // Exit the program if the input is not a natural number
        }

        // Calculate the sum using recursion
        int recursiveResult = recursiveSum(n);

        // Calculate the sum using the formula
        int formulaResult = formulaSum(n);

        // Display both results
        System.out.println("Sum of first " + n + " natural numbers (recursive): " + recursiveResult);
        System.out.println("Sum of first " + n + " natural numbers (formula): " + formulaResult);

        // Compare the two results
        if (recursiveResult == formulaResult) {
            System.out.println("Both methods give the same result, the sum is correct.");
        } else {
            System.out.println("There is an error in the computation.");
        }
    }
}
