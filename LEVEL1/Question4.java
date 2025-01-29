import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();

        // Generate and print Fibonacci sequence
        generateFibonacci(terms);

        scanner.close();
    }

    // Method to generate Fibonacci sequence
    public static void generateFibonacci(int n) {
        int first = 0, second = 1;

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println(); // New line after printing sequence
    }
}
