import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the sides of the triangular park
        System.out.print("Enter the length of the first side of the triangle (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of the second side of the triangle (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of the third side of the triangle (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate the perimeter
        double perimeter = calculatePerimeter(side1, side2, side3);

        // Distance the athlete wants to cover in meters (5 km = 5000 meters)
        double totalDistance = 5000;

        // Calculate the number of rounds
        int rounds = calculateRounds(totalDistance, perimeter);

        // Output the result
        System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");

        scanner.close();
    }

    // Method to calculate the perimeter of the triangular park
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    // Method to calculate the number of rounds needed
    public static int calculateRounds(double totalDistance, double perimeter) {
        return (int) Math.ceil(totalDistance / perimeter);
    }
}
