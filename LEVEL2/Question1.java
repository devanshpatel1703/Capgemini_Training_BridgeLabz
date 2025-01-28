import java.util.Scanner;

public class Question1 {

    // Method to find the factors of the number and return them in an array
    public static int[] findFactors(int number) {
        // First loop to count the number of factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create an array to store the factors
        int[] factors = new int[count];
        int index = 0;

        // Second loop to store the factors in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find the sum of the factors
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors
    public static int findProduct(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the sum of the squares of the factors
    public static double findSumOfSquares(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Call method to find factors
        int[] factors = findFactors(number);

        // Display the factors
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Call method to calculate and display the sum of the factors
        int sum = findSum(factors);
        System.out.println("Sum of the factors: " + sum);

        // Call method to calculate and display the product of the factors
        int product = findProduct(factors);
        System.out.println("Product of the factors: " + product);

        // Call method to calculate and display the sum of the square of the factors
        double sumOfSquares = findSumOfSquares(factors);
        System.out.println("Sum of the squares of the factors: " + sumOfSquares);
    }
}
