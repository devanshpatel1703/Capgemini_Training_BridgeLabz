import java.util.Scanner;

public class Question8 {

    // Method to find the smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] result = new int[2];  // Array to store smallest and largest numbers

        // Finding the smallest number
        result[0] = Math.min(Math.min(number1, number2), number3);

        // Finding the largest number
        result[1] = Math.max(Math.max(number1, number2), number3);

        return result;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking three numbers as input
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        // Call the method to find smallest and largest
        int[] result = findSmallestAndLargest(num1, num2, num3);

        // Display the results
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
    }
}
