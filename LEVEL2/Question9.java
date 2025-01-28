import java.util.Scanner;

public class Question9 {

    // Method to check whether a number is positive or negative
    public static String isPositive(int number) {
        if (number < 0) {
            return "Negative";
        } else {
            return "Positive";
        }
    }

    // Method to check whether the number is even or odd
    public static String isEven(int number) {
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    // Method to compare two numbers and return 1 if number1 > number2, 0 if equal, -1 if number1 < number2
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to hold 5 numbers
        int[] numbers = new int[5];

        // Taking input for 5 numbers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Checking whether each number is positive or negative and if positive, checking if it's even or odd
        for (int i = 0; i < 5; i++) {
            String positivity = isPositive(numbers[i]);
            if (positivity.equals("Positive")) {
                String evenOdd = isEven(numbers[i]);
                System.out.println("Number " + numbers[i] + " is Positive and " + evenOdd + ".");
            } else {
                System.out.println("Number " + numbers[i] + " is Negative.");
            }
        }

        // Comparing the first and last elements of the array
        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparisonResult == 0) {
            System.out.println("The first number is equal to the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
