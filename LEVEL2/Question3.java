import java.util.Scanner;

public class Question3 {

    // Method to check if the given year is a leap year
    public static boolean isLeapYear(int year) {
        // Check if the year is valid according to the Gregorian calendar
        if (year < 1582) {
            System.out.println("Year must be greater than or equal to 1582.");
            return false;  // Invalid year
        }
        
        // Check for leap year conditions
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;  // It's a leap year
        } else {
            return false;  // It's not a leap year
        }
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for the year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year and output the result
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
    }
}
