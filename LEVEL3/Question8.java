import java.util.Scanner;

public class Question8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month < 1 || month > 12) {
            System.out.println("Invalid month.");
            return;
        }

        // Adjust for leap year
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Calculate day of the week for the first day of the month
        int dayOfWeek = dayOfWeek(year, month);

        // Print calendar header
        System.out.println("     " + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print spaces for the first day of the month
        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("    ");
        }

        // Print days of the month
        for (int i = 1; i <= daysInMonth[month - 1]; i++) {
            System.out.printf("%3d ", i);
            if ((i + dayOfWeek) % 7 == 0) {
                System.out.println();
            }
        }

        scanner.close();
    }

    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Calculate day of the week using the Gregorian calendar algorithm
    public static int dayOfWeek(int year, int month) {
        int y0 = (14 - month) / 12;
        int x = year - y0;
        int m0 = month + 12 * y0 - 2;
        int d0 = (x + x / 4 - x / 100 + x / 400 + (31 * m0) / 12) % 7;
        return d0;
    }
}