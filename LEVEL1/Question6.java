import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Month and Day
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();

        // Check if it is Spring Season
        boolean isSpring = checkSpringSeason(month, day);

        // Output the result
        if (isSpring) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }

        scanner.close();
    }

    // Method to check if the given date falls in Spring Season
    public static boolean checkSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) {
            return true; // March 20 to March 31
        } else if (month == 4 && day >= 1 && day <= 30) {
            return true; // April 1 to April 30
        } else if (month == 5 && day >= 1 && day <= 31) {
            return true; // May 1 to May 31
        } else if (month == 6 && day >= 1 && day <= 20) {
            return true; // June 1 to June 20
        } else {
            return false; // Not a Spring Season
        }
    }
}
