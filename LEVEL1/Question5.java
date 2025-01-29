import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check if it's a palindrome
        boolean isPalindrome = checkPalindrome(input);

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        scanner.close();
    }

    // Method to check if a string is a palindrome
    public static boolean checkPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Normalize string (remove spaces, punctuation, and make lowercase)
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // If mismatch, not a palindrome
            }
            left++;
            right--;
        }
        return true; // If loop completes, it's a palindrome
    }
}
