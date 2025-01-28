import java.util.Arrays;

public class Question2 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return Integer.toString(Math.abs(number)).length();
    }

    // Method to store the digits of the number in an array
    public static int[] storeDigits(int number) {
        int length = countDigits(number);
        int[] digits = new int[length];
        number = Math.abs(number);

        for (int i = length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    // Method to check if a number is a Duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the number is an Armstrong number
    public static boolean isArmstrongNumber(int number) {
        int[] digits = storeDigits(number);
        int length = digits.length;
        int sum = 0;
        int originalNumber = number;

        for (int digit : digits) {
            sum += Math.pow(digit, length);
        }

        return sum == originalNumber;
    }

    // Method to find the largest and second largest digits in the array
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit < largest) {
                secondLargest = digit;
            }
        }

        return new int[] { largest, secondLargest };
    }

    // Method to find the smallest and second smallest digits in the array
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit > smallest) {
                secondSmallest = digit;
            }
        }

        return new int[] { smallest, secondSmallest };
    }

    public static void main(String[] args) {
        int number = 153; // You can change the number to test other cases

        // Count digits in the number
        int digitCount = countDigits(number);
        System.out.println("Number of digits: " + digitCount);

        // Store the digits of the number in an array
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        // Check if the number is a Duck number
        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck number: " + isDuck);

        // Check if the number is an Armstrong number
        boolean isArmstrong = isArmstrongNumber(number);
        System.out.println("Is Armstrong number: " + isArmstrong);

        // Find the largest and second largest digits
        int[] largestDigits = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestDigits[0]);
        System.out.println("Second largest digit: " + largestDigits[1]);

        // Find the smallest and second smallest digits
        int[] smallestDigits = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestDigits[0]);
        System.out.println("Second smallest digit: " + smallestDigits[1]);
    }
}
