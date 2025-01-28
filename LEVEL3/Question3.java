import java.util.Arrays;

public class Question3 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return Integer.toString(Math.abs(number)).length();
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number) {
        int length = countDigits(number);
        int[] digits = new int[length];
        number = Math.abs(number); // Handle negative numbers

        for (int i = length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Method to find the sum of the digits of the number
    public static int sumOfDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    // Method to find the sum of the squares of the digits of the number
    public static double sumOfSquaresOfDigits(int number) {
        int[] digits = storeDigits(number);
        double sum = 0;

        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }

        return sum;
    }

    // Method to check if the number is a Harshad number
    public static boolean isHarshadNumber(int number) {
        int sumOfDigits = sumOfDigits(number);
        return number % sumOfDigits == 0;
    }

    // Method to find the frequency of each digit in the number
    public static int[][] digitFrequency(int number) {
        int[] digits = storeDigits(number);
        int[][] frequency = new int[10][2]; // 10 possible digits (0-9)

        // Initialize the first column with digit values (0 to 9)
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        // Calculate frequency of each digit
        for (int digit : digits) {
            frequency[digit][1]++;
        }

        // Remove empty frequencies
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                count++;
            }
        }

        // Return only the non-zero frequencies
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                result[index] = frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 153; // You can change this number for testing

        // Count digits in the number
        int digitCount = countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        // Store the digits of the number in an array
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        // Find the sum of the digits
        int sumOfDigits = sumOfDigits(number);
        System.out.println("Sum of digits: " + sumOfDigits);

        // Find the sum of the squares of the digits
        double sumOfSquares = sumOfSquaresOfDigits(number);
        System.out.println("Sum of the squares of digits: " + sumOfSquares);

        // Check if the number is a Harshad number
        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad number: " + isHarshad);

        // Find the frequency of each digit
        int[][] frequencies = digitFrequency(number);
        System.out.println("Frequency of digits:");
        for (int[] freq : frequencies) {
            System.out.println("Digit " + freq[0] + ": " + freq[1] + " times");
        }
    }
}
