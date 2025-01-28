import java.util.Scanner;

public class Question9 {

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];  // Array to store quotient and remainder

        // Calculate quotient and remainder
        result[0] = number / divisor;  // Quotient
        result[1] = number % divisor;  // Remainder

        return result;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking two integers as input
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Handle division by zero case
        if (divisor == 0) {
            System.out.println("Divisor cannot be zero.");
        } else {
            // Call the method to find quotient and remainder
            int[] result = findRemainderAndQuotient(number, divisor);

            // Display the results
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }
    }
}
