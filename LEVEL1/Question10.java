import java.util.Scanner;

public class Question10 {

    // Method to find the number of chocolates each child gets and the remainder
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];  // Array to store quotient (chocolates per child) and remainder (remaining chocolates)

        // Calculate chocolates each child gets (quotient) and the remaining chocolates (remainder)
        result[0] = numberOfChocolates / numberOfChildren;  // Chocolates per child
        result[1] = numberOfChocolates % numberOfChildren;  // Remaining chocolates

        return result;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Handle case when there are no children
        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero.");
        } else {
            // Call the method to find chocolates per child and remainder
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            // Display the results
            System.out.println("Each child will get: " + result[0] + " chocolates.");
            System.out.println("Remaining chocolates: " + result[1]);
        }
    }
}
