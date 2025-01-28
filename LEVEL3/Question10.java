import java.util.Scanner;

public class Question10 {

    // Method to check if three points are collinear using the slope formula
    public static boolean areCollinearUsingSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // To avoid division by zero, we use cross multiplication
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    // Method to check if three points are collinear using the area formula
    public static boolean areCollinearUsingArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coordinates of first point (x1 y1):");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("Enter coordinates of second point (x2 y2):");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        System.out.println("Enter coordinates of third point (x3 y3):");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        boolean resultSlope = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear (using slope)? " + resultSlope);

        boolean resultArea = areCollinearUsingArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear (using area)? " + resultArea);

        scanner.close();
    }
}
