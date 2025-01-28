import java.util.Scanner;

public class Question11 {

    // Method to find the roots of the quadratic equation
    public static double[] findRoots(int a, int b, int c) {
        // Calculate the discriminant (delta)
        double delta = Math.pow(b, 2) - 4 * a * c;

        // If delta is negative, return an empty array (no real roots)
        if (delta < 0) {
            return new double[0];  // No real roots
        }
        
        // If delta is zero, there is exactly one real root
        if (delta == 0) {
            double root = -b / (2.0 * a);
            return new double[]{root};  // One real root
        }
        
        // If delta is positive, calculate two real roots
        double root1 = (-b + Math.sqrt(delta)) / (2.0 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2.0 * a);

        return new double[]{root1, root2};  // Two real roots
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take user input for a, b, and c
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();

        // Call the findRoots method to calculate the roots
        double[] roots = findRoots(a, b, c);

        // Display the results
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("Two real roots: " + roots[0] + " and " + roots[1]);
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
