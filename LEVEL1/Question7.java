import java.util.Scanner;

public class Question7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for n
        System.out.print("Enter a positive integer (n): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Call the method to calculate the sum
            int sum = calculateSum(n);
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }

    // Method to calculate the sum of n natural numbers
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // Add each number to the sum
        }
        return sum;
    }
}
