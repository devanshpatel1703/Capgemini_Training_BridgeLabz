import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Calculate GCD and LCM
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        // Display results
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);

        scanner.close();
    }

    // Recursive method to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        if (b == 0)
            return a;
        return calculateGCD(b, a % b);
    }

    // Method to calculate LCM using GCD
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
