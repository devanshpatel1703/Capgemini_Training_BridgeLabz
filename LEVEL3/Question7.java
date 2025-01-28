import java.util.HashSet;
import java.util.Set;

public class Question7 {

    // Method to generate a 6-digit OTP number
    public static int generateOTP() {
        // Generate a random 6-digit OTP number between 100000 and 999999
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to ensure OTP numbers are unique
    public static boolean areUniqueOTPs(int[] otpNumbers) {
        Set<Integer> otpSet = new HashSet<>();

        // Add OTPs to a set to ensure uniqueness
        for (int otp : otpNumbers) {
            if (!otpSet.add(otp)) {
                // If add() returns false, it means the number is a duplicate
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Array to store 10 OTP numbers
        int[] otpNumbers = new int[10];

        // Generate OTP numbers and store them in the array
        for (int i = 0; i < otpNumbers.length; i++) {
            otpNumbers[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otpNumbers[i]);
        }

        // Check if all OTPs are unique
        if (areUniqueOTPs(otpNumbers)) {
            System.out.println("\nAll OTPs are unique!");
        } else {
            System.out.println("\nThere are duplicate OTPs!");
        }
    }
}
