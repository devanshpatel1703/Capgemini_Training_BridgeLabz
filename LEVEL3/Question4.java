import java.util.Arrays;

public class Question4 {

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

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int length = digits.length;
        int[] reversed = new int[length];

        for (int i = 0; i < length; i++) {
            reversed[i] = digits[length - 1 - i];
        }

        return reversed;
    }

    // Method to compare two arrays and check if they are equal
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] reversedDigits = reverseArray(digits);
        return areArraysEqual(digits, reversedDigits);
    }

    // Method to check if a number is a Duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true;  // A Duck number contains at least one non-zero digit
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 12321; // You can change this number for testing

        // Count digits in the number
        int digitCount = countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        // Store the digits of the number in an array
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        // Reverse the digits array
        int[] reversedDigits = reverseArray(digits);
        System.out.println("Reversed digits: " + Arrays.toString(reversedDigits));

        // Check if the number is a palindrome
        boolean isPalindrome = isPalindrome(number);
        System.out.println("Is Palindrome: " + isPalindrome);

        // Check if the number is a Duck number
        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck number: " + isDuck);
    }
}
