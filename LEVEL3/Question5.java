public class Question5 {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        
        // Sum the digits of the square
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        
        return sumOfDigits == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;
        
        // Calculate sum and product of digits
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return sum == product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        
        // Check if the square ends with the number itself
        return squareStr.endsWith(numStr);
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        int number = 7; // You can change this number to test other cases
        
        // Check if the number is prime
        boolean prime = isPrime(number);
        System.out.println(number + " is prime: " + prime);

        // Check if the number is a neon number
        boolean neon = isNeon(number);
        System.out.println(number + " is neon: " + neon);

        // Check if the number is a spy number
        boolean spy = isSpy(number);
        System.out.println(number + " is spy: " + spy);

        // Check if the number is an automorphic number
        boolean automorphic = isAutomorphic(number);
        System.out.println(number + " is automorphic: " + automorphic);

        // Check if the number is a buzz number
        boolean buzz = isBuzz(number);
        System.out.println(number + " is buzz: " + buzz);
    }
}
